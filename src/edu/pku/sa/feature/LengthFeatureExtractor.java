package edu.pku.sa.feature;

import java.util.List;

import edu.pku.sa.ins.Instance;

public class LengthFeatureExtractor implements FeatureExtractorInterface {

	@Override
	public void extract(Instance ins, List<Feature> features) {
		// TODO Auto-generated method stub		
//		a simple example
		features.add(new Feature("COM_LEN", ins.getText().length()));
		return;
	}

} // end class LengthFeatureExtractor
