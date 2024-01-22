package dto;


import java.util.Arrays;

public class Movie
{
       private int movieid;
       private String moviename;
       private double movieprice;
       private double movierating;
       private String moviegeneric;
       private String movielanguage;
       private byte[] movieimage;

	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public double getMovieprice() {
		return movieprice;
	}
	public void setMovieprice(double movieprice) {
		this.movieprice = movieprice;
	}
	public double getMovierating() {
		return movierating;
	}
	public void setMovierating(double movierating) {
		this.movierating = movierating;
	}
	public String getMoviegeneric() {
		return moviegeneric;
	}
	public void setMoviegeneric(String moviegeneric) {
		this.moviegeneric = moviegeneric;
	}
	public String getMovielanguage() {
		return movielanguage;
	}
	public void setMovielanguage(String movielanguage) {
		this.movielanguage = movielanguage;
	}
	public byte[] getMovieimage() {
		return movieimage;
	}
	public void setMovieimage(byte[] movieimage) {
		this.movieimage = movieimage;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	@Override
	public String toString() {
		return "Movie [movieid=" + movieid + ", moviename=" + moviename + ", movieprice=" + movieprice
				+ ", movierating=" + movierating + ", moviegeneric=" + moviegeneric + ", movielanguage=" + movielanguage
				+ ", movieimage=" + Arrays.toString(movieimage) + "]";
	}
       
}
