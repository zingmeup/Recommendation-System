package model;

public class MovieRatingBasedOrder implements Comparable {
    private int id;
    private double ratingSum;
    private int userNum;

    public MovieRatingBasedOrder(int id, double rating, int userNum) {
        this.id = id;
        this.ratingSum = rating;
        this.userNum = userNum;
    }

    @Override
    public int compareTo(Object o) {
        //required

        double thisavg=this.ratingSum/this.userNum;
        double thatAvg=((MovieRatingBasedOrder)o).ratingSum/((MovieRatingBasedOrder)o).userNum;
        return Double.compare(thisavg,thatAvg);

        //improvised
        //return Double.compare(this.ratingSum, ((MovieRatingBasedOrder)o).ratingSum);
    }

    @Override
    public String toString() {
        String string="Movie ID: "+id+" Avg Rating: "+(ratingSum/userNum)+" By "+userNum+" users.";
        return string;
    }
}
