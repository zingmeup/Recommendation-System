package main;

import appdata.Data;
import model.Movie;
import model.MovieRatingBasedOrder;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Engine {

    Engine(int subjectUser) {
        Data.getData().getSubject().setUserID(subjectUser);
        fetchResourses(Data.getData().getSubject().getUserID());
        orderMoviesBasedOnRating();
    }

    private void orderMoviesBasedOnRating() {
        Iterator iterator=Data.getData().getMovies().iterator();
        while (iterator.hasNext()){
            Movie m=(Movie) iterator.next();
            if (!Data.getData().getSubject().getWatched().contains((Integer)m.getMoviewID())){
                Data.getData().getOrderedRecommend().add(new MovieRatingBasedOrder(m.getMoviewID(),m.getRatingSum(),m.getUsers()));
            }
        }
        Collections.sort(Data.getData().getOrderedRecommend());
    }

    private void fetchResourses(int user) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    "E:/Java/Movie/src/appdata/ratings"));
            String line = reader.readLine();
            while (line != null) {
                String[] attr = line.split(" ");
                if (attr[0].equals(String.valueOf(user))){
                    Data.getData().getSubject().getWatched().add(Integer.valueOf(attr[1]));
                }else{
                    //if(Double.valueOf(attr[2])>2.5)
                    reduceToMapMovie(attr);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void reduceToMapMovie(String[] attr) {
        Movie m = new Movie(Integer.parseInt(attr[1]));
        if (!Data.getData().getMovies().contains(m)) {
            Data.getData().getMovies().add(m);              //add movie to TreeSet if not already added
        }
        Iterator i = Data.getData().getMovies().iterator();
        boolean found = false;
        while (i.hasNext() && !found) {                     //Traverse to movie in the TreeSet
            Movie im = (Movie) i.next();
            if (im.getMoviewID() == Integer.parseInt(attr[1])) { found = true;
                im.setUsers(im.getUsers()+1);
                im.setRatingSum(im.getRatingSum()+Double.valueOf(attr[2]));
            }
        }
    }
    public ArrayList<MovieRatingBasedOrder> getRecommendedMovies(int num) {
        ArrayList<MovieRatingBasedOrder> returnMovies=new ArrayList<>();
        for (int i = Data.getData().getOrderedRecommend().size()-1; i>=Data.getData().getOrderedRecommend().size()-num ; i--) {
            returnMovies.add(Data.getData().getOrderedRecommend().get(i));
        }
        return returnMovies;
    }
}
