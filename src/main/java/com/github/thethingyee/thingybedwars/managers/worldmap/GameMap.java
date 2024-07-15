package com.github.thethingyee.thingybedwars.managers.worldmap;

import org.bukkit.World;

public interface GameMap {
    boolean loadWorld();
    void unloadWorld();
    boolean restoreFromSource();

    boolean isLoaded();
    World getWorld();
}
