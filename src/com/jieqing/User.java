package com.jieqing;

public class User implements Comparable<User> {

    private int points;

    public User(int points) {
        this.points = points;
    }

    @Override
    public int compareTo(User other) {
        // this < other -> -1
        // this == other -> 0
        // this > other -> 1
        if (points < other.points)
            return -1;
        if (points == other.points)
            return 0;
        return -1;
        // OR
        // return points - other.points;
    }
}







