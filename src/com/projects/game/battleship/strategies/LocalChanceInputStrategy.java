package com.projects.game.battleship.strategies;
/*
 *  Copyright (c) 2022 Amazon.com, Inc.  All rights reserved.
 *
 */

import com.projects.game.battleship.model.Coordinate;

import java.util.Scanner;

public class LocalChanceInputStrategy implements ChanceInputStrategy {
    @Override
    public Coordinate getInput() {
        Scanner sc = new Scanner(System.in);
        int xCoordinate = sc.nextInt();
        int yCoordinate = sc.nextInt();
        return new Coordinate(xCoordinate, yCoordinate);
    }
}
