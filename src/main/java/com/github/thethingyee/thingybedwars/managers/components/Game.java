package com.github.thethingyee.thingybedwars.managers.components;

import java.util.ArrayList;

public class Game {

    private final Queue queue;
    private ArrayList<Team> teamSet;

    public Game(Queue queue) {
        this.queue = queue;
    }

    public Queue getQueue() {
        return queue;
    }
}
