关于程序的运行过程：

一.预训练

调用包含所有特征的类扫描一遍训练语料库，得到所有特征的维度。

二.训练

学习各个回归模型的参数。

三.测试

给测试集分类标注。


――――――――――――――――――――――――――――――――――――――――――――――――――――――――――

关于特征：

――――――――――――――――――――――――

Feature接口

至少包含：

int dimension

//预训练，不断更新dimension值

pretrain(String sentence)

//输入twitter消息，返回特征空间数据

List<float> produce(String sentence)

――――――――――――――――――――――――

Features类

至少包含：

//所有特征

List<Feature>

int dimension

add_feature(Feature feature)

//这是在预训练结束阶段调用，从所有特征取出dimension加到一起得到总的dimension

set_dimension()

//给定消息输出特征向量

List<float> get_vector(String sentence)

――――――――――――――――――――――――――――――――――――――――――――――――――――――――――

整体模型：

Models类

//添加一个回归模型

add_regression_model(RegressionModel model)

train()

//给定一段影评，返回星级

int predict(String sentence)

――――――――――――――――――――――――

RegressionModel

int dimension

set_dimension()

train()

predict()































