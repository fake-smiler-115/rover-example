package com.tw.step.rover.roversystem;

import com.tw.step.rover.boundary.Boundary;
import com.tw.step.rover.boundary.Plateau;
import com.tw.step.rover.commands.CommandCreator;
import com.tw.step.rover.position.Coordinate;
import com.tw.step.rover.position.Navigator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoverSystemParserTest {
    @Test
    void shouldParseAndExecuteRoverSystem() {
        RoverSystemScanner scanner = RoverSystemScanner.from("5 5\n1 2 N\nRFF");
        RoverSystemParser parser = new RoverSystemParser(scanner, Navigator.create(), new CommandCreator());

        RoverSystem roverSystem = parser.parse();
        roverSystem.execute();

        assertEquals("3 2 E ALIVE", roverSystem.toString());
    }

    @Test
    void scanPlateau() {
        RoverSystemScanner scanner = RoverSystemScanner.from("5 5\n1 2 N");
        RoverSystemParser parser = new RoverSystemParser(scanner, Navigator.create(), new CommandCreator());

        Coordinate bottomLeft = new Coordinate(0, 0);
        Coordinate topRight = new Coordinate(5, 5);
        Boundary plateau = new Plateau(bottomLeft, topRight);
        assertEquals(plateau, parser.parsePlateau());
    }
}
