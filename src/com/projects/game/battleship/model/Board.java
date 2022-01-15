package com.projects.game.battleship.model;
/*
 *  Copyright (c) 2022 Amazon.com, Inc.  All rights reserved.
 *
 */

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board {
    private List<BoardItem> ships;

    private RectangularBoundary rectangularBoundary;

    @Getter
    private List<Coordinate> hitLocations;

    public Board(List<BoardItem> ships, RectangularBoundary boundary) {
        //TODO: Validate ships are not overlapping and in the boundary
        this.ships = ships;
        this.rectangularBoundary = boundary;
        this.hitLocations = new ArrayList<>();
    }


    public void hit(Coordinate coordinate) {
        hitLocations.add(coordinate);
    }

    public void printBoard() {
        Set<Coordinate> hits = getHits();
        Set<Coordinate> misses = getMiss();

        for (int i=rectangularBoundary.getTopLeft().getX();i<=rectangularBoundary.getBottomRight().getX();i++) {
            for (int j=rectangularBoundary.getTopLeft().getY();j<=rectangularBoundary.getBottomRight().getX();j++) {
                Coordinate coordinate = new Coordinate(i, j);
                if (hits.contains(coordinate)) {
                    System.out.print("X");
                } else if (misses.contains(coordinate)) {
                    System.out.print("O");
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
    }

    public Boolean isAllShipKilled() {
        for (BoardItem ship: ships) {
            if (!ship.isKilled(hitLocations))
                return false;
        }
        return true;
    }

    private Set<Coordinate> getMiss() {
        Set<Coordinate> allMiss = new HashSet<>();
        for (Coordinate hitLocation : hitLocations) {
            boolean isMiss = true;
            for (BoardItem ship : ships) {
                if (ship.contains(hitLocation)) {
                    isMiss = false;
                    break;
                }
            }
            if (isMiss) {
                allMiss.add(hitLocation);
            }
        }
        return allMiss;
    }
    private Set<Coordinate> getHits() {
        Set<Coordinate> allHits = new HashSet<>();
        for (Coordinate hitLocation : hitLocations) {
            for (BoardItem ship : ships) {
                if (ship.contains(hitLocation)) {
                    allHits.add(hitLocation);
                    break;
                }
            }
        }
        return allHits;
    }

}
