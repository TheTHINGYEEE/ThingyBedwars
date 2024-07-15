package com.github.thethingyee.thingybedwars.managers;

import com.github.thethingyee.thingybedwars.ThingyBedwars;
import com.github.thethingyee.thingybedwars.managers.components.Arena;
import com.github.thethingyee.thingybedwars.managers.components.Team;
import org.bukkit.DyeColor;
import org.bukkit.World;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GameManager {

    private final Set<Arena> availableArenas = new HashSet<>();
    private SetupMode setupMode = null;

    private File mapsFolder = null;

    private final ThingyBedwars thingyBedwars;

    public GameManager(ThingyBedwars thingyBedwars) {
        this.thingyBedwars = thingyBedwars;
    }

    public boolean checkArenaNameAvailability(String name) {
        return !(availableArenas.stream().anyMatch(arena -> arena.getName().equalsIgnoreCase(name)));
    }

    public boolean isValidTeamColor(String teamColor) {
        return Team.TeamColor.valueOf(teamColor.toUpperCase()) != null;
    }

    public SetupMode getSetupMode() {
        return setupMode;
    }

    public void setSetupMode(SetupMode setupMode) {
        this.setupMode = setupMode;
    }

    public Set<Arena> getAvailableArenas() {
        return availableArenas;
    }

    public void initializeFiles() {
        thingyBedwars.getDataFolder().mkdirs();

        mapsFolder = new File(thingyBedwars.getDataFolder(), "maps");
        if(!mapsFolder.exists()) mapsFolder.mkdirs();
    }

    public static Team.TeamColor[] parseTeamColors(String... teamColor) {
        ArrayList<Team.TeamColor> teamColorArrayList = new ArrayList<Team.TeamColor>();

        for (String s : teamColor) {
            teamColorArrayList.add(Team.TeamColor.valueOf(s));
        }

        return teamColorArrayList.toArray(new Team.TeamColor[teamColor.length]);
    }

    public File getMapsFolder() {
        return mapsFolder;
    }
}
