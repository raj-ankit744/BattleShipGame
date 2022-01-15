package com.projects.game.battleship.model;
/*
 *  Copyright (c) 2022 Amazon.com, Inc.  All rights reserved.
 *
 */

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BoardItem {
    private String boardItemName;
    private IBoundary rectangularBoundary;

    public Boolean contains(Coordinate coordinate) {
        return rectangularBoundary.getAllCoordinates().contains(coordinate);
    }

    public Boolean isKilled(List<Coordinate> hitLocations) {
        return hitLocations.containsAll(rectangularBoundary.getAllCoordinates());
    }
}
