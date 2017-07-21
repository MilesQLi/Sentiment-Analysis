package edu.pku.sa.utils;

import java.io.File;
import java.util.List;

import edu.pku.sa.ins.Instance;


/**
 * 
 * @author intfloat@pku.edu.cn, stormier@126.com
 * 
 * IOUtils for interacting with xml files
 *
 */
public class IOUtils {
	
	/**
	 * 
	 * @param train
	 * @param movie
	 * @return a list of instance in training set
	 */
	public static List<Instance> loadTrainData(File train, File movie) {
		if (!train.exists() || !movie.exists()) {
			System.err.println("File path for training data is invalid");
			return null;
		}
		List<Instance> result = XMLUtils.readCommentXML(train);
		List<Movie> movies = XMLUtils.readMovieXML(movie);
		for (Movie mv : movies) {
			for (Instance ins : result) {
				if (mv.getMovieId() == ins.getMovieId()) {
					ins.setDirector(mv.getDirector());
					ins.setMovieAvgRating(mv.getAvgRating());
					ins.setMovieName(mv.getMovieName());
				}
			} // end inner for loop
		} // end outer for loop
		return result;
	} // end method loadTrainData
	
	/**
	 * 
	 * @param test
	 * @return a list of instances in test set
	 */
	public static List<Instance> loadTestData(File test, File movie) {
//		TODO: the format of test data is still unknown, 
		if (!test.exists() || !movie.exists()) {
			System.err.println("File path for test data is invalid");
			return null;
		}
		List<Instance> result = XMLUtils.readCommentXML(test);
		List<Movie> movies = XMLUtils.readMovieXML(movie);
		for (Movie mv : movies) {
			for (Instance ins : result) {
				if (mv.getMovieId() == ins.getMovieId()) {
					ins.setDirector(mv.getDirector());
					ins.setMovieAvgRating(mv.getAvgRating());
					ins.setMovieName(mv.getMovieName());
				}
			} // end inner for loop
		}
		return result;
	} // end method loadTestData

} // end class IOUtils
