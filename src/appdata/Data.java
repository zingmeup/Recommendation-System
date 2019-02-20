package appdata;

import model.Movie;
import model.MovieRatingBasedOrder;
import model.User;

import java.util.ArrayList;
import java.util.TreeSet;

public class Data {
    private static Data data;
    TreeSet<Movie> movies;
    User subject;
    ArrayList<MovieRatingBasedOrder> orderedRecommend;

    public Data() {
        this.movies =new TreeSet<Movie>();
        this.subject=new User();
        this.orderedRecommend=new ArrayList<>();
    }

    public ArrayList<MovieRatingBasedOrder> getOrderedRecommend() {
        return orderedRecommend;
    }

    public void setOrderedRecommend(ArrayList<MovieRatingBasedOrder> orderedRecommend) {
        this.orderedRecommend = orderedRecommend;
    }

    public static Data getData() {
        if (data==null) data=new Data();
        return data;
    }

    public User getSubject() {
        return subject;
    }


    public TreeSet<Movie> getMovies() {
        return movies;
    }

}
