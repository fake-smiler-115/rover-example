package com.tw.step.rover.boundary;

import com.tw.step.rover.position.Coordinate;
import com.tw.step.rover.roversystem.RoverSystemScanner;

import java.util.Objects;

public class Plateau implements Boundary {
    private final Coordinate bottomLeft;
    private final Coordinate topRight;

    public Plateau(Coordinate bottomLeft, Coordinate topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    @Override
    public boolean isWithin(Coordinate coord) {
        return coord.isWithin(bottomLeft,topRight);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Plateau plateau = (Plateau) o;
        return Objects.equals(bottomLeft, plateau.bottomLeft) && Objects.equals(topRight, plateau.topRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bottomLeft, topRight);
    }
}
