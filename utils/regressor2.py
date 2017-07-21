# -*- coding: utf-8 -*-
import logging
import sys
from sklearn.linear_model import SGDClassifier
from sklearn.feature_extraction import FeatureHasher
from sklearn.feature_extraction import DictVectorizer
from sklearn.ensemble import GradientBoostingRegressor, RandomForestRegressor
from sklearn import tree
from numpy import asarray
from random import random
from sklearn import svm
from sklearn.linear_model import BayesianRidge
from sklearn.linear_model import SGDRegressor
from numpy.random import shuffle
from sklearn.metrics import mean_squared_error

# Support Vector Regression
if __name__ == '__main__':
    logging.basicConfig(level = logging.DEBUG,
                format='%(asctime)s %(filename)s[line:%(lineno)d] %(levelname)s %(message)s',
                datefmt='%a, %d %b %Y %H:%M:%S',
                filename='sa.log',
                filemode='w')

    logging.info('start to load data...')
    if len(sys.argv) == 4:
        reader = open(sys.argv[1], 'r')
    else:
        reader = open('../src/train_xy.txt', 'r')
    data = []
    for instance in reader:
        instance = instance.split()
        y = float(instance[0])
        x = {'BIAS':1}
        for feature in instance[1:]:
            pos = feature.rfind(':')
            key, val = feature[:pos], feature[pos + 1:]
            x[key] = float(val)
        data.append([x, y])
    logging.info('Total number of instance: ' + str(len(data)))

#   random shuffle and split data into training set & test set
    shuffle(data)
    X = [ins[0] for ins in data]
    Y = [ins[1] for ins in data]
  ##  mid = int(len(data) * .8)
    vectorizer = DictVectorizer()
    X = vectorizer.fit_transform(X).toarray()
    logging.info('Feature dimension: ' + str(len(X[0])))

  #  train_x, test_x = X[:mid], X[mid:]
  #  train_y, test_y = Y[:mid], Y[mid:]
     
    train_x, train_y = X, Y
	 
    logging.info('Number of train data: ' + str(len(train_x)))

    logging.info('start to train model...')
    # linear kernel seems to take a much longer time to train
    # clf = svm.SVR(kernel = 'rbf',C=2.2,epsilon=0.01,gamma=0.001)
    clf = GradientBoostingRegressor()
    # vectorizer = FeatureHasher(input_type = 'dict', non_negative = True)
    clf.fit(train_x, train_y)

    logging.info('start to test model...')
    if len(sys.argv) == 4:
        test_reader = open(sys.argv[2], 'r')
    else:
        test_reader = open('../src/test_xy.txt', 'r')
    test_data = []
    comment_id = []
    for instance in test_reader:
        instance = instance.split()
        comment_id.append(int(instance[0]))
        x = {'BIAS':1}
        for feature in instance[2:]:
            pos = feature.rfind(':')
            key, val = feature[:pos], feature[pos + 1:]
            x[key] = float(val)
        test_data.append(x)
    logging.info('Total number of instance: ' + str(len(test_data)))
    test_x = test_data
    test_x = vectorizer.transform(test_x).toarray()
    pred_y = clf.predict(test_x)
    pred_y = [max(1.0, min(5.0, py)) for py in pred_y]
    
    if len(sys.argv) == 4:
        result_writer = open(sys.argv[3], 'w')
    else:
        result_writer = open('../src/result.txt', 'w')
    for i in range(0, len(test_x)):
        result_writer.write("%d %f\n" % (comment_id[i], pred_y[i]))
