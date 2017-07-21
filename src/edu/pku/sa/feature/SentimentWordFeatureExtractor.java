package edu.pku.sa.feature;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import edu.pku.sa.ins.Instance;
import edu.pku.sa.utils.NLPTools;

public class SentimentWordFeatureExtractor implements FeatureExtractorInterface {

	private List<String> positive_words;
	private List<String> negative_words;

	@Override
	public void extract(Instance ins, List<Feature> features) {
		// TODO Auto-generated method stub
		List<String> segmented_comment = ins.getSegmented_comment();
		int positive = 0;
		int negative = 0;
		for (String word : segmented_comment) {
			if (positive_words.contains(word)) {
				positive++;
		//		System.out.println("find positive word:" + word);
			} else if (negative_words.contains(word)) {
				negative++;
		//		System.out.println("find negtive word:" + word);
			}

		}
		features.add(new Feature("POSITIVE", positive));
		features.add(new Feature("NEGTIVE", negative));
/*
		if (positive != 0)
			System.out.println("positive word number:" + positive);

		if (negative != 0)
			System.out.println("negtive word number:" + negative);
			*/
		return;
	}

	public SentimentWordFeatureExtractor() {
		positive_words = new ArrayList<String>();
		negative_words = new ArrayList<String>();

		try {
			BufferedReader positive_buffer = new BufferedReader(
					new InputStreamReader(new FileInputStream(
							"data/positive.txt"), "UTF-8"), 512);
			BufferedReader negtive_buffer = new BufferedReader(
					new InputStreamReader(new FileInputStream(
							"data/negative.txt"), "UTF-8"), 512);
			String line = "";
			while ((line = positive_buffer.readLine()) != null) {
				positive_words.add(line);
	//			System.out.println(line);
			}
			positive_buffer.close();
			while ((line = negtive_buffer.readLine()) != null) {
				negative_words.add(line);
	//			System.out.println(line);
			}
			negtive_buffer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
