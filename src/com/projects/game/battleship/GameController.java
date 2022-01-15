package com.projects.game.battleship;
/*
 *  Copyright (c) 2022 Amazon.com, Inc.  All rights reserved.
 *
 */

import com.projects.game.battleship.strategies.IPlayerSelectorStrategy;
import com.projects.game.battleship.strategies.IWinningStrategy;
import com.projects.game.battleship.model.Player;
import com.projects.game.battleship.model.PlayerChance;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class GameController {
    private IWinningStrategy winningStrategy;
    private IPlayerSelectorStrategy playerSelectorStrategy;
    private Map<Integer, Player> playersMap;

    public void playGame() {
        List<Player> players = new ArrayList<>(playersMap.values());
        System.out.println("Players " + players.stream().map(Player::getPlayerId).collect(Collectors.toList()));
        Player curPlayer = playerSelectorStrategy.getNextPlayer(null, players);
        System.out.println("Starting Game with Player " + curPlayer.getPlayerId());

        while(true) {
            curPlayer.printBoard();
            Player opponent = playerSelectorStrategy.getNextPlayer(curPlayer, players);
            System.out.println("Player: " + curPlayer.getPlayerId() + " is attacking on opponent " + opponent.getPlayerId());

            PlayerChance chance = curPlayer.takeInput(opponent);

            chance.getPlayer().takeChance(chance.getCoordinate());

            Player winner = winningStrategy.getWinner(players);

            if (winner != null) {
                System.out.println("Player " + winner + " Has won !!!");
                return;
            }

            curPlayer = playerSelectorStrategy.getNextPlayer(curPlayer, players);
        }
    }
}
