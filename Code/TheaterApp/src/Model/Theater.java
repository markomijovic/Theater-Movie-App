package Model;

import java.util.ArrayList;
import java.util.Dictionary;

public class Theater {
	
	private int id;
	private ArrayList<Movie> myMovies;
	private Dictionary<Movie, ArrayList<Showing>> mySchedule;
	
	public String getTheaterInfo() {
		//TODO
		return "";
	}
	
	public int getId() {
		return id;
	}
	
	public ArrayList<Movie> getMyMovies() {
		return myMovies;
	}
	
	public ArrayList<Showing> getShowings(Movie movie) {
		return mySchedule.get(movie);
	}
}
