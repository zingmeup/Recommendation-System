package model;

public class Movie implements Comparable {
    private int moviewID;
    private int usersNum;
    private double ratingSum;

    public Movie(int moviewID) {
        this.moviewID = moviewID;
    }

    public void setMoviewID(int moviewID) {
        this.moviewID = moviewID;
    }

    public int getUsers() {
        return usersNum;
    }

    public void setUsers(int users) {
        this.usersNum = users;
    }

    public double getRatingSum() {
        return ratingSum;
    }

    public void setRatingSum(double ratingSum) {
        this.ratingSum = ratingSum;
    }

    public int getMoviewID() {
        return moviewID;
    }


    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.moviewID, ((Movie) o).moviewID);
    }
}
