package com.projects.game.battleship;
/*
 *  Copyright (c) 2022 Amazon.com, Inc.  All rights reserved.
 *
 */

import com.projects.game.battleship.model.IBoundary;
import com.projects.game.battleship.model.RectangularBoundary;
import com.projects.game.battleship.strategies.BasicWinningStrategy;
import com.projects.game.battleship.model.Board;
import com.projects.game.battleship.model.BoardItem;
import com.projects.game.battleship.model.Coordinate;
import com.projects.game.battleship.model.Player;
import com.projects.game.battleship.strategies.LocalChanceInputStrategy;
import com.projects.game.battleship.strategies.RoundRobinPlayerSelectorStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String args[]) {
        Map<Integer, Player> playerMap = new HashMap<>();
        playerMap.put(1, getPlayer1());
        playerMap.put(2, getPlayer2());
        GameController controller = new GameController(new BasicWinningStrategy(),
                                                       new RoundRobinPlayerSelectorStrategy(), playerMap);

        controller.playGame();


    }

    private static Player getPlayer1() {
        final RectangularBoundary boardBoundary = new RectangularBoundary(new Coordinate(0, 0), new Coordinate(10, 10));

        BoardItem ship1 = new BoardItem("Carrier", new RectangularBoundary(new Coordinate(0, 7), new Coordinate(4,7)));
        BoardItem ship2 = new BoardItem("Battleship", new RectangularBoundary(new Coordinate(4, 1), new Coordinate(4,4)));

        List<BoardItem> ships = new ArrayList<>();
        ships.add(ship1);
        ships.add(ship2);

        Board board = new Board(ships, boardBoundary);

        return new Player( 1, board, new LocalChanceInputStrategy());

    }

    private static Player getPlayer2() {
        final RectangularBoundary boardBoundary = new RectangularBoundary(new Coordinate(0, 0), new Coordinate(10, 10));

        BoardItem ship1 = new BoardItem("Carrier", new RectangularBoundary(new Coordinate(0, 7), new Coordinate(4,7)));
        BoardItem ship2 = new BoardItem("Battleship", new RectangularBoundary(new Coordinate(4, 1), new Coordinate(4,4)));

        ArrayList<BoardItem> ships = new ArrayList<>();
        ships.add(ship1);
        ships.add(ship2);

        Board board = new Board(ships, boardBoundary);

        return new Player(2, board, new LocalChanceInputStrategy());
    }
}
