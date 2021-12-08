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
	 * The theater app observs movie for any news to send to customers.
	 */
	private TheaterApp myObserver;

	private int showingListID;

	/**
	 * Constructor for movie.
	 */
	Movie(String title, String movieNews, TheaterApp myObserver, int sID) {
		this.title = title;
		this.myObserver = myObserver;
		setMovieNews(movieNews);
		showingListID = sID;
	}
	
	/** 
	 * Returns all relevant movie information for ordinary users
	 */
	public String getMovieInfo() {
		return "Movie ID: "+title + " - Exclusive:" + movieNews;
	}
	
	/**
	 * Returns movie title that can be used as an id.
	 */
	public String getTitle() {
		return title;
	}

	public int getShowingListID() {
		return showingListID;
	}

	/**
	 * Sets the exclusive movie news and notifies all observers that wish to 
	 * get this movie news.
	 */
	public void setMovieNews(String news) {
		// Observer Pattern: When news are updated, all registered users are notified.
		movieNews = news;
		myObserver.sendExclusiveMovieNews(news);
	}
}
