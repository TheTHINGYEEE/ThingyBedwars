package com.github.thethingyee.thingybedwars.managers.components;

import com.github.thethingyee.thingybedwars.managers.GameManager;
import com.github.thethingyee.thingybedwars.managers.worldmap.GameMap;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Arena {

    private final String name;
    private final GameMap gameMap;
    private Location lobbyLocation;
    private final Set<Generator> generators = new HashSet<>();
    private final ArrayList<Team> teams = new ArrayList<>();
    private final GameManager gameManager;

    public Arena(String name, GameMap gameMap, GameManager gameManager) {
        this.gameMap = gameMap;
        this.gameManager = gameManager;
        this.name = name;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public Set<Generator> getGenerators() {
        return generators;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    public String getName() {
        return name;
    }

    public Location getLobbyLocation() {
        return lobbyLocation;
    }

    public void setLobbyLocation(Location lobbyLocation) {
        this.lobbyLocation = lobbyLocation;
    }
}
