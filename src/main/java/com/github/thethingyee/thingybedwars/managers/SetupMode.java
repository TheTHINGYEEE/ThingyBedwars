package com.github.thethingyee.thingybedwars.managers;

import com.github.thethingyee.thingybedwars.managers.components.Arena;
import com.github.thethingyee.thingybedwars.managers.components.Team;
import com.github.thethingyee.thingybedwars.managers.worldmap.GameMap;
import com.github.thethingyee.thingybedwars.managers.worldmap.LocalGameMap;

import java.io.File;
import java.util.ArrayList;

public class SetupMode {

    private final GameManager gameManager;
    private boolean setupMode = false;

    public SetupMode(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public static int MAX_TEAMS_ALLOWED = Team.TeamColor.values().length;
    public static int MIN_TEAMS_NEEDED = 2;

    private String mapName;
    private GameMap gameMap;

    private Arena arena = null;

    private File worldFolder;

    // Team components
    private ArrayList<Team> availableTeams = new ArrayList<>();

    public void setSetupMode(boolean setupMode) {
        this.setupMode = setupMode;
    }

    public Arena createArena() {
        return (arena = new Arena(mapName, gameMap, gameManager));
    }

    public GameMap createGameMap(File worldFolder, String mapName, boolean loadoninit) {
        this.mapName = mapName;
        this.worldFolder = worldFolder;
        return (gameMap = new LocalGameMap(worldFolder, mapName, loadoninit));
    }

    public ArrayList<Team> createTeams(Team.TeamColor... teamColors) {
        for (Team.TeamColor teamColor : teamColors) {
            availableTeams.add(new Team(null, teamColor, null));
        }
        return availableTeams;
    }

    public boolean onSetupMode() {
        return setupMode;
    }

    public ArrayList<Team> getAvailableTeams() {
        return availableTeams;
    }

    public Team getTeamByTeamColor(Team.TeamColor teamColor) {
        return availableTeams.stream().filter(team -> team.getTeamColor().equals(teamColor)).findFirst().get();
    }
}
