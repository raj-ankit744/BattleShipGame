package com.projects.game.battleship.strategies;
/*
 *  Copyright (c) 2022 Amazon.com, Inc.  All rights reserved.
 *
 */

import com.projects.game.battleship.model.Player;

import java.util.List;

public interface IPlayerSelectorStrategy {
    Player getNextPlayer(Player currentPlayer, List<Player> player);
}
