package com.projects.game.battleship.model;
/*
 *  Copyright (c) 2022 Amazon.com, Inc.  All rights reserved.
 *
 */

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlayerChance {

    private Player player;

    private Coordinate coordinate;
}
