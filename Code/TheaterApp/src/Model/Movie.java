package Model;

/** 
 * This class a representation of a movie object.
 */
public class Movie {

	/**
	 * The movie title is unique and can be used as an id.
	 */
	private String title;
	/** 
	 * Movie news can only be accessed by registered users.
	 */
	private String movieNews;
	/**
	 * Overview description of the movie.
	 */
	private String synopsis;
	/**
	 * Main actor name
	 */
	private String leadingActor;
	
	/**
	 * Constructor for movie.
	 */
	Movie(String title, String movieNews, String synopsis, String leadingActor) {
		this.title = title;
		this.synopsis = synopsis;
		this.leadingActor = leadingActor;
		setMovieNews(movieNews);
	}
	
	/** 
	 * Returns all relevant movie information for ordinary users
	 */
	public String getMovieInfo() {
		return title + "\n" +
			   synopsis + "\n" +
			   "Starring " + leadingActor;
	}
	
	/**
	 * Returns movie title that can be used as an id.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the exclusive movie news and notifies all observers that wish to 
	 * get this movie news.
	 */
	public void setMovieNews(String news) {
		//TODO: Implement observer pattern. 
		//      When news are updated, all registered users are notified.
		movieNews = news;
	}
}
