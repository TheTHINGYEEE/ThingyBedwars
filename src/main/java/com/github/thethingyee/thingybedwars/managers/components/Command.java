package com.github.thethingyee.thingybedwars.managers.components;

import com.github.thethingyee.thingybedwars.managers.GameManager;
import org.bukkit.entity.Player;

public abstract class Command {

    private final GameManager gameManager;

    public Command(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public abstract String getName();
    public abstract String getArguments();
    public abstract void execute(Player player, String[] args);
    public abstract boolean isSetupCommand();

    public GameManager getGameManager() {
        return gameManager;
    }
}

