package model;

import java.util.ArrayList;

public class User implements Comparable {
    private int userID;
    private ArrayList<Integer> watched;

    public User() {
        this.watched=new ArrayList<>();
    }

    public int getUserID() {
        return userID;
    }

    public ArrayList<Integer> getWatched() {
        return watched;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setWatched(ArrayList<Integer> watched) {
        this.watched= watched;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.userID, ((User)o).userID);
    }
}
