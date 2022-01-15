package com.projects.game.battleship.strategies;
/*
 *  Copyright (c) 2022 Amazon.com, Inc.  All rights reserved.
 *
 */

import com.projects.game.battleship.model.Player;

import java.util.List;

public class RoundRobinPlayerSelectorStrategy implements IPlayerSelectorStrategy {
    @Override
    public Player getNextPlayer(final Player currentPlayer, final List<Player> players) {
        if (currentPlayer == null) {
            return players.get(0);
        }
        int size = players.size();
        int nextPlayerIndex = (findIndex(currentPlayer, players) + 1) % size;
        return players.get(nextPlayerIndex);
    }

    private int findIndex(final Player currentPlayer, final List<Player> players) {
        return players.indexOf(currentPlayer);
    }
}
