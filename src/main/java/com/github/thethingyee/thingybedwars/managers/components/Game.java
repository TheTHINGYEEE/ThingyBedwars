package com.github.thethingyee.thingybedwars.managers.components;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Game {

    private final Queue queue;
    private ArrayList<Player> players;

    public Game(Queue queue) {
        this.queue = queue;
    }

    public Queue getQueue() {
        return queue;
    }
}
