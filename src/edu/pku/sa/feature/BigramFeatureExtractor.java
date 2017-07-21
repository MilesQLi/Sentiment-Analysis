package edu.pku.sa.feature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import edu.pku.sa.ins.Instance;
import edu.pku.sa.utils.NLPTools;
import edu.stanford.nlp.ling.TaggedWord;

public class BigramFeatureExtractor  implements FeatureExtractorInterface{
	
	
	@Override
	public void extract(Instance ins, List<Feature> features) {
		// TODO Auto-generated method stub
		List<String> segmented_comment = ins.getSegmented_comment();
		List<TaggedWord> poses = ins.getPoses();
		
		for(int i = 0; i < segmented_comment.size() - 1; i++)
		{
			features.add(new Feature(segmented_comment.get(i) + "_" + segmented_comment.get(i + 1), 1));
		}
		
		for (int i = 0; i < poses.size() - 1; ++i) {
			features.add(new Feature(poses.get(i).tag() + "_" + poses.get(i + 1).tag(), 1));
		}
		
		return;
	}
	
}
