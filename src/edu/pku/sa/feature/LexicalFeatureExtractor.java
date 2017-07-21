package edu.pku.sa.feature;

import java.util.HashSet;
import java.util.List;
import edu.pku.sa.ins.Instance;
import edu.pku.sa.utils.NLPTools;

/**
 * 
 * @author intfloat@pku.edu.cn, stormier@126.com
 *
 */
public class LexicalFeatureExtractor implements FeatureExtractorInterface {

	
	
	@Override
	public void extract(Instance ins, List<Feature> features) {
		// TODO Auto-generated method stub
		//stop using
		/*
		List<String> segmented_comment = NLPTools.segment(ins.getText());
		HashSet<String> word_set = new HashSet<String>(segmented_comment);
		for (String word : word_set) 
		{
			
			features.add(new Feature(word, 1));
			//for tf feature
			//features.add(new Feature(word, Collections.frequency(segmented_comment,word)));
		}
*/
		return;
	}
	
} // end class LexicalFeatureExtractor
