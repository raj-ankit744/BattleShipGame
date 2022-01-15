package com.projects.game.battleship.strategies;
/*
 *  Copyright (c) 2022 Amazon.com, Inc.  All rights reserved.
 *
 */

import com.projects.game.battleship.model.Player;

import java.util.ArrayList;
import java.util.List;

public class BasicWinningStrategy implements IWinningStrategy {

    @Override
    public Player getWinner(final List<Player> players) {
        List<Player> alivePlayers = new ArrayList<>();
        for (Player player: players) {
            if (player.isAlive()) {
                alivePlayers.add(player);
            }
        }

        if (alivePlayers.size() == 1) {
            return alivePlayers.get(0);
        }

        return null;
    }
}
