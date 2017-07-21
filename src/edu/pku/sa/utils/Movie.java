package edu.pku.sa.utils;

/**
 * Represent movie, this class should not 
 * be used anywhere else other than IOUtils.java
 * 
 * @author intfloat@pku.edu.cn, stormier@126.com
 *
 */
public class Movie {
	
	private long movieId;
	private String movieName;
	private String director;
	private double avgRating;
	
	/**
	 * Constructor
	 * 
	 * @param id
	 * @param name
	 * @param director
	 * @param rating
	 */
	public Movie(long id, String name, String director, double rating) {
		this.setMovieId(id);
		this.setMovieName(name);
		this.setDirector(director);
		this.setAvgRating(rating);
	}
	
	@Override
	public String toString() {
//		just for debug
		return "Id: " + this.movieId + " name: " + this.movieName
				+ " director: " + this.director + " avgRating: " + this.avgRating;
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
	 * @return the avgRating
	 */
	public double getAvgRating() {
		return avgRating;
	}

	/**
	 * @param avgRating the avgRating to set
	 */
	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
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

} // end class Movie
