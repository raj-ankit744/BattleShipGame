package com.projects.game.battleship.model;
/*
 *  Copyright (c) 2022 Amazon.com, Inc.  All rights reserved.
 *
 */

import com.projects.game.battleship.strategies.ChanceInputStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Player {

    private Integer playerId;

    private Board board;

    private ChanceInputStrategy localChanceInputStrategy;

    public PlayerChance takeInput(Player player) {
        return new PlayerChance(player , localChanceInputStrategy.getInput());
    }

    public void takeChance(Coordinate coordinate) {
        board.hit(coordinate);
    }

    public void printBoard() {
        System.out.println("Player " + playerId + " Board:  ");
        board.printBoard();
    }

    public Boolean isAlive() {
        return !board.isAllShipKilled();
    }

}
