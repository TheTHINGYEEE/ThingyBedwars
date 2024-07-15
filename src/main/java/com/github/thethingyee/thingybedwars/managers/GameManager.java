package com.github.thethingyee.thingybedwars.managers;

import com.github.thethingyee.thingybedwars.ThingyBedwars;
import com.github.thethingyee.thingybedwars.managers.components.Arena;
import com.github.thethingyee.thingybedwars.managers.components.Generator;
import com.github.thethingyee.thingybedwars.managers.components.Team;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GameManager {

    private final Set<Arena> availableArenas = new HashSet<>();
    private SetupMode setupMode = null;

    private File mapsFolder = null;

    private final ThingyBedwars thingyBedwars;

    public GameManager(ThingyBedwars thingyBedwars) {
        this.thingyBedwars = thingyBedwars;
    }

    public boolean checkArenaNameAvailability(String name) {
        return availableArenas.stream().noneMatch(arena -> arena.getName().equalsIgnoreCase(name));
    }

    public boolean isValidTeamColor(String teamColor) {
        try {
            Team.TeamColor.valueOf(teamColor.toUpperCase());
        } catch(IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public List<Generator> getDiamondGenerators(Arena arena) {
        return arena.getGenerators().stream().filter(generator -> generator.getType().equals(Generator.Type.DIAMOND)).collect(Collectors.toList());
    }

    public List<Generator> getEmeraldGenerators(Arena arena) {
        return arena.getGenerators().stream().filter(generator -> generator.getType().equals(Generator.Type.EMERALD)).collect(Collectors.toList());
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
            teamColorArrayList.add(Team.TeamColor.valueOf(s.toUpperCase()));
        }

        return teamColorArrayList.toArray(new Team.TeamColor[teamColor.length]);
    }

    public File getMapsFolder() {
        return mapsFolder;
    }
}
