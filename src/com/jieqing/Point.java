package com.jieqing;

import java.util.Objects;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        // If current object references to the same object received
        if (this == obj)
            return true;
        // Object is not an instance of Point
        if (!(obj instanceof Point))
            return false;

        Point other = (Point)obj; // Down Casting Object to Point
        return other.x == x && other.y == y; // Compare x and y of the current object to the 'other' object
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}





