package edu.pku.sa.model;

import java.util.List;

import edu.pku.sa.ins.Instance;


/**
 * 
 * @author intfloat@pku.edu.cn, stormier@126.com
 *
 * An interface for classifier
 */
public interface Model {
	
	/**
	 * 
	 * @param ins
	 */
	public void train(List<Instance> ins);
	
	/**
	 * 
	 * @param ins
	 * @return predicted sentiment value
	 */
	public double predict(Instance ins);
	
	/**
	 * Report performance of this model on validation data
	 */
	public void reportPerformance();

} // end interface classifier
