package com.projects.game.battleship.model;
/*
 *  Copyright (c) 2022 Amazon.com, Inc.  All rights reserved.
 *
 */

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class RectangularBoundary implements IBoundary {

    @Getter
    private Coordinate topLeft;

    @Getter
    private Coordinate bottomRight;

    @Override
    public Set<Coordinate> getAllCoordinates() {
        Set<Coordinate> allCoordinates = new HashSet<>();
        for (int i=topLeft.getX();i<=bottomRight.getX();i++) {
            for (int j=topLeft.getY();j<=bottomRight.getY();j++) {
                allCoordinates.add(new Coordinate(i, j));
            }
        }
        return allCoordinates;
    }
}
