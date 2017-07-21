package edu.pku.sa.feature;

import java.util.List;

import edu.pku.sa.ins.Instance;

/**
 * 
 * @author intfloat@pku.edu.cn, stormier@126.com
 *
 */
public interface FeatureExtractorInterface {
	
	/**
	 * 
	 * @param ins
	 * @return a list of certain type of features
	 */
	public void extract(Instance ins, List<Feature> features);

}
