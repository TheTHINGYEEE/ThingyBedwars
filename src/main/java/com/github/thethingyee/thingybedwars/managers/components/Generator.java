package com.github.thethingyee.thingybedwars.managers.components;

import org.bukkit.Location;

public class Generator {
    public enum Type {
        EMERALD, DIAMOND;
    }

    private final Generator.Type type;
    private Location location;
    private int interval;


    public Generator(Generator.Type type, Location location) {
        this.type = type;
        this.location = location;
    }

    public void spawnItem() {
        return;
    }

    public Type getType() {
        return type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }
}
