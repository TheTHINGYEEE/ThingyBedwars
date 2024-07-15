package com.github.thethingyee.thingybedwars.managers.components;


import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Set;

public class Queue {

    private Set<Player> playerList;
    private BukkitRunnable countdownRunnable;

    public Queue(Set<Player> playerList, BukkitRunnable countdownRunnable) {
        this.playerList = playerList;
        this.countdownRunnable = countdownRunnable;
    }

    public Set<Player> getPlayerList() {
        return playerList;
    }

    public BukkitRunnable getCountdownRunnable() {
        return countdownRunnable;
    }

    public void setPlayerList(Set<Player> playerList) {
        this.playerList = playerList;
    }

    public void setCountdownRunnable(BukkitRunnable countdownRunnable) {
        this.countdownRunnable = countdownRunnable;
    }
}
