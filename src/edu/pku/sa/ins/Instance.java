package edu.pku.sa.ins;

import java.util.ArrayList;
import java.util.List;

import edu.pku.sa.feature.Feature;
import edu.pku.sa.feature.FeatureMap;
import edu.pku.sa.utils.NLPTools;
import edu.stanford.nlp.ling.TaggedWord;

/**
 * 
 * @author intfloat@pku.edu.cn, stormier@126.com
 * 
 * An instance
 *
 */
public class Instance {
	
	private List<Feature> features;
	private long movieId;
	private String director;
	private String movieName;
	private double movieAvgRating;
	private double rating;
	private long commentId;
	private String text;
	private List<String> segmented_comment;
	private List<TaggedWord> poses;
	
	/**
	 * Constructor
	 */
	public Instance() {
		this.features = new ArrayList<Feature>();
	}
	
	@Override
	public String toString() {
		

		String result = String.valueOf(this.rating);
		
		/*
		HashMap<Integer,Double> hash = new HashMap<Integer,Double>();
		ArrayList<Integer> index_List = new ArrayList<Integer>();
		for (Feature f : this.features)
		{
			hash.put(f.getIndex(), f.getValue());
		}
		List<HashMap.Entry<Integer,Double>> infoIds = new ArrayList<HashMap.Entry<Integer,Double>>(hash.entrySet()); 
		Collections.sort(infoIds, new Comparator<HashMap.Entry<Integer,Double>>() {  
            public int compare(HashMap.Entry<Integer,Double> o1,  
                    HashMap.Entry<Integer,Double> o2) {  
                return (int)o1.getKey()-(int)o2.getKey();  
            }  
        }); 
		
	        for (int i = 0; i < infoIds.size(); i++) {  
	            String id = infoIds.get(i).toString();  
	            result += " " + infoIds.get(i).getKey()+":"+infoIds.get(i).getValue();
	        }  
		*/
		for (Feature f : this.features)
			if(FeatureMap.getFeatureFrequency(f) > 1)
			{
			  result += " " + f;
			}
		return result;
//		return "movieId: " + this.movieId				
//				+ " rating: " + this.rating
//				+ " commentId: " + this.commentId
//				+ " text: " + this.text
//				+ " director: " + this.director
//				+ " movieName: " + this.movieName
//				+ " movieAvgRating: " + this.movieAvgRating
//				+ "number of features: " + this.features.size();
	}
	
	/**
	 * Add feature via a string description
	 * 
	 * @param f
	 */
	public void addFeature(String f) {
		addFeature(new Feature(f));
	}
	
	/**
	 * Add feature via a Feature object
	 * 
	 * @param f
	 */
	public void addFeature(Feature f) {
		this.features.add(f);
	}

	/**
	 * @return the features
	 */
	public List<Feature> getFeatures() {
		return features;
	}

	/**
	 * @param features the features to set
	 */
	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	/**
	 * @return the movieAvgRating
	 */
	public double getMovieAvgRating() {
		return movieAvgRating;
	}

	/**
	 * @param movieAvgRating the movieAvgRating to set
	 */
	public void setMovieAvgRating(double movieAvgRating) {
		this.movieAvgRating = movieAvgRating;
	}

	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}

	/**
	 * @param movieName the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	/**
	 * @return the movieId
	 */
	public long getMovieId() {
		return movieId;
	}

	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return the commentId
	 */
	public long getCommentId() {
		return commentId;
	}

	/**
	 * @param commentId the commentId to set
	 */
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
		this.segmented_comment = NLPTools.segment(this.text);
		this.poses = NLPTools.postag(this.segmented_comment);
	}

	/**
	 * @return the poses
	 */
	public List<TaggedWord> getPoses() {
		return poses;
	}

	/**
	 * @param poses the poses to set
	 */
	public void setPoses(List<TaggedWord> poses) {
		this.poses = poses;
	}

	/**
	 * @return the segmented_comment
	 */
	public List<String> getSegmented_comment() {
		return segmented_comment;
	}

	/**
	 * @param segmented_comment the segmented_comment to set
	 */
	public void setSegmented_comment(List<String> segmented_comment) {
		this.segmented_comment = segmented_comment;
	}

} // end class Instance
