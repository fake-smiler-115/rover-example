package com.tw.step.rover.rover;

import com.tw.step.rover.boundary.Boundary;
import com.tw.step.rover.position.Navigator;

public class DeadRoverState implements RoverState {
    private final Rover rover;

    public DeadRoverState(Rover rover) {
        this.rover = rover;
    }

    @Override
    public RoverState turnLeft(Navigator navigator, Boundary boundary) {
        return this;
    }

    @Override
    public RoverState turnRight(Navigator navigator, Boundary boundary) {
        return this;
    }

    @Override
    public RoverState move(Navigator navigator, Boundary boundary) {
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(RoverStatus.LOST);
    }
}
