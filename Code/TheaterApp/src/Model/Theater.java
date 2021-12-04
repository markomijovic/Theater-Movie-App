package Model;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;

/**
 * This class is a representation for a movie theater location.
 */
public class Theater {
	/**
	 * The postal code for a theater is unique. This can be used as an id.
	 */
	private String postalCode;
	/**
	 * List of movies playing in the theater along with their show times.
	 */
	private Dictionary<Movie, ArrayList<Showing>> mySchedule;
	
	/**
	 * Constructor for theater that initializes data members.
	 */
	Theater (String postalCode, Dictionary<Movie, ArrayList<Showing>> schedule) {
		this.postalCode = postalCode;
		this.mySchedule = schedule;
	}

	/**
	 * Get the showings of a specific movie.
	 */
	public ArrayList<Showing> getShowings(Movie movie) {
		return mySchedule.get(movie);
	}

	/** 
	 * Searches a for a specific showing.
	 * 
	 * PROMISES: Returns showing with specified id at specific theater for a specific movie.
	 * REQUIRES: Valid theater, movie, and showing id.
	 */
	public Showing searchShowing(Movie myMovie, String showingId) {
		Showing retVal = null;

		ArrayList<Showing> myShowings = getShowings(myMovie);
		if (myShowings != null) {
			int numShowings = myShowings.size();
			for (int i = 0; i < numShowings; i++) {
				if (myShowings.get(i).getId().equals(showingId)) {
					retVal = myShowings.get(i);
					break;
				}
			}
		}
		
		return retVal;
	}

	/**
	 * Returns all theater information.
	 */
	public String getTheaterInfo() {
		String retVal = "Theater postal code: " + postalCode + "\n" +
						"Schedule: \n";
		Enumeration<Movie> myMovies = mySchedule.keys();
		while(myMovies.hasMoreElements()) {
            Movie m = myMovies.nextElement();
			retVal += "Movie:\n" + m.getMovieInfo() + "\n";
			retVal += "Showtimes: \n";
			ArrayList<Showing> myShowings = mySchedule.get(m);
			int numShowings = myShowings.size();
			for (int i = 0; i < numShowings; i++) {
				retVal += myShowings.get(i).getShowtime().toString() + "\n";
			}
        }
		return retVal;
	}
	
	/**
	 * Returns the postal code of the theater. This can be used as a unique id.
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Returns the schedule of the theater.
	 */
	public Dictionary<Movie, ArrayList<Showing>> getMySchedule() {
		return mySchedule;
	}
}
