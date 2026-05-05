package com.tw.step.rover.roversystem;

import com.tw.step.rover.boundary.Boundary;
import com.tw.step.rover.boundary.Plateau;
import com.tw.step.rover.commands.CommandCreator;
import com.tw.step.rover.commands.RoverCommand;
import com.tw.step.rover.commands.RoverCommands;
import com.tw.step.rover.position.Coordinate;
import com.tw.step.rover.position.Direction;
import com.tw.step.rover.position.Navigator;
import com.tw.step.rover.rover.Rover;

public class RoverSystemParser {
    private final RoverSystemScanner scanner;
    private final Navigator navigator;
    private Boundary boundary;
    private final CommandCreator commandCreator;

    public RoverSystemParser(RoverSystemScanner scanner, Navigator navigator, CommandCreator commandCreator) {
        this.scanner = scanner;
        this.navigator = navigator;
        this.commandCreator = commandCreator;
    }

    private Rover parseRover() {
        Coordinate coordinate = scanner.scanCoordinate();
        Direction heading = scanner.scanDirection();
        return new Rover(coordinate, heading);
    }

    public RoverSystem parse() {
        RoverSystem roverSystem = new RoverSystem();
        this.boundary = parsePlateau();
        Rover rover = parseRover();
        roverSystem.addRover(rover);
        RoverCommands roverCommands = parseRoverCommands();
        roverSystem.addCommands(roverCommands);
        return roverSystem;
    }

    public Boundary parsePlateau() {
        Coordinate bottomLeft = new Coordinate(0, 0);
        Coordinate topRight = this.scanner.scanCoordinate();
        return new Plateau(bottomLeft,topRight);
    }

    private RoverCommands parseRoverCommands() {
        RoverCommands roverCommands = new RoverCommands();
        String instructions = scanner.consume();
        for (int i = 0; i < instructions.length(); i++) {
            RoverCommand roverCommand = commandCreator.create(instructions.charAt(i), navigator, boundary);
            roverCommands.add(roverCommand);
        }

        return roverCommands;
    }
}
