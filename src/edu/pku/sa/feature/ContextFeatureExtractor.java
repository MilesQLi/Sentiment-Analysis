package edu.pku.sa.feature;

import java.util.List;

import edu.pku.sa.ins.Instance;

/**
 * 
 * @author intfloat@pku.edu.cn, stormier@126.com
 *
 */
public class ContextFeatureExtractor implements FeatureExtractorInterface {

	@Override
	public void extract(Instance ins, List<Feature> features) {
		// TODO Auto-generated method stub
		features.add(new Feature(ins.getDirector(), 1));
		features.add(new Feature(String.valueOf(ins.getMovieId()), 1));
		features.add(new Feature("AVG_RATING", ins.getMovieAvgRating()));
		return;
	}

} // end class ContextFeatureExtractor
