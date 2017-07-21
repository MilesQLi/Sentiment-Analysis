package edu.pku.sa.feature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import edu.pku.sa.ins.Instance;
import edu.pku.sa.utils.NLPTools;
import edu.stanford.nlp.ling.TaggedWord;

/**
 * Part-Of-Speech features for sentiment analysis
 * 
 * @author intfloat@pku.edu.cn, stormier@126.com
 *
 */
public class LexicalAndPOSFeatureExtractor implements FeatureExtractorInterface {

	@Override
	public void extract(Instance ins, List<Feature> features) {
		// TODO Auto-generated method stub		

		for (TaggedWord pos : ins.getPoses()) {
			if (pos.tag().equals("AD") || pos.tag().equals("CD")
					|| pos.tag().equals("CS") || pos.tag().equals("FW")
					|| pos.tag().equals("NN") || pos.tag().equals("NR")
					|| pos.tag().equals("NT") || pos.tag().equals("OD")
					|| pos.tag().equals("ON") || pos.tag().equals("PU")
					|| pos.tag().equals("SP") || pos.tag().equals("VA")
					|| pos.tag().equals("VE") || pos.tag().equals("VV")) {
				features.add(new Feature(pos.word(), 1));
				features.add(new Feature(pos.tag(), 1));
			}
		}
		return;
	}

} // end class POSFeatureExtractor
