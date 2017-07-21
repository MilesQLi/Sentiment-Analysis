package edu.pku.sa.feature;

import java.util.ArrayList;
import java.util.List;

import edu.pku.sa.ins.Instance;


/**
 * 
 * @author intfloat@pku.edu.cn, stormier@126.com
 *
 */
public class FeatureExtractor {
	
	private static List<FeatureExtractorInterface> extractors = null;	
	
	/**
	 * setup function<br>
	 * To add a new kind of feature,
	 * you need to write a class implementing <b>FeatureExtractorInterface</b> class
	 * and register your class in setup() function
	 */
	private static void setup() {
//		registerExtractor(new LengthFeatureExtractor());
//		registerExtractor(new LexicalFeatureExtractor());
//		THIS IS THE ONLY POSITION THAT SHOULD BE MODIFIED!
		registerExtractor(new LexicalAndPOSFeatureExtractor());
		registerExtractor(new BigramFeatureExtractor());
		registerExtractor(new ContextFeatureExtractor());
//		registerExtractor(new SyntacticFeatureExtractor());
		registerExtractor(new SentimentWordFeatureExtractor());
//		registerExtractor(new WordnetFeatureExtractor());
		return;
	}
	
	/**
	 * Register feature extractor
	 */
	private static void registerExtractor(FeatureExtractorInterface ext) {
		extractors.add(ext);
	}
	
	/**
	 * Given an instance, extract relevant features
	 * 
	 * @param ins
	 * @return
	 */
	public static List<Feature> extract(Instance ins) {
		if (null == extractors) {
			extractors = new ArrayList<FeatureExtractorInterface>();
            setup();
		}
		List<Feature> result = new ArrayList<Feature>();
		for (FeatureExtractorInterface ext : extractors) {
			ext.extract(ins, result);
		}
		return result;
	} // end method extract

} // end class FeatureExtractor
