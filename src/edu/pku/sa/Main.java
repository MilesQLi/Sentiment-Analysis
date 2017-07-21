package edu.pku.sa;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import edu.pku.sa.feature.FeatureExtractor;
import edu.pku.sa.feature.FeatureMap;
import edu.pku.sa.ins.Instance;
import edu.pku.sa.model.LogisticRegression;
import edu.pku.sa.model.Model;
import edu.pku.sa.utils.IOUtils;
import edu.pku.sa.utils.NLPTools;

/**
 * 
 * @author intfloat@pku.edu.cn, stormier@126.com
 * 
 * Entry point for whole project
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		NLPTools.initalize();
//		Step 1: load training data
		System.out.println("start to load data...");
		List<Instance> trainIns;
		if (args.length == 5)
			trainIns = IOUtils.loadTrainData(new File(args[0]), new File(args[1]));
		else
			trainIns = IOUtils.loadTrainData(new File("data/train.xml"), new File("data/movies.xml"));
		FeatureMap.clearFeatureMap();		
		
//		Step 2: extract features for training data
		System.out.println("start to extract features...");		
		
		for (Instance ins : trainIns) {			
			ins.setFeatures(FeatureExtractor.extract(ins));			
		}
		FileWriter writer;
		if (args.length == 5)
		  writer = new FileWriter(new File(args[3]));
		else
		  writer = new FileWriter(new File("train_xy.txt"));
		for (Instance ins : trainIns) {
			writer.write(ins + "\n");			
		}
		writer.flush();
		writer.close();
		
//		Step 3: train a regression or classification model
//		System.out.println("start to train a model...");
//		Model lr = new LogisticRegression();
//		
//		System.out.println("start to train...");
//		lr.train(trainIns);
//		System.out.println("all done.");
		
//		Step 4: load test data
		
		System.out.println("start to predict...");
		List<Instance> testIns;
		if (args.length == 5)
			testIns = IOUtils.loadTestData(new File(args[2]), new File(args[1]));
		else
			testIns = IOUtils.loadTestData(new File("data/test.xml"), new File("data/movies.xml"));
		
		for (Instance ins : testIns) {		
			ins.setFeatures(FeatureExtractor.extract(ins));			
		}
		if (args.length == 5)
		    writer = new FileWriter(new File(args[4]));
		else
			writer = new FileWriter(new File("test_xy.txt"));
		for (Instance ins : testIns) {
			writer.write(Long.toString(ins.getCommentId()) + " " + ins + "\n");			
		}
		writer.flush();
		writer.close();
		
//		Step 5: extract features for test data
		
		/*
		for (Instance ins : testIns) {
			ins.setFeatures(FeatureExtractor.extract(ins));
		}
		
//		Step 6: predict rating for test data
		for (Instance ins : testIns) {
			System.out.println(ins.getCommentId() + "\t" + lr.predict(ins));
		}
		*/
		System.out.println("done");		
	} // end method main

} // end class Main
