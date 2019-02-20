package main;

import model.MovieRatingBasedOrder;

import java.util.ArrayList;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.print("Enter user you want to do analysis on: ");
        Engine engine=new Engine(new Scanner(System.in).nextInt());
        System.out.print("Enter number of movies to recommend: ");
        ArrayList<MovieRatingBasedOrder> recommendations=engine.getRecommendedMovies(new Scanner(System.in).nextInt());
        for (MovieRatingBasedOrder m: recommendations){
            System.out.println(m);
        }
    }
}
