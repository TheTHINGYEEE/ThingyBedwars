package com.github.thethingyee.thingybedwars;

import com.github.thethingyee.thingybedwars.managers.CommandManager;
import com.github.thethingyee.thingybedwars.managers.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class ThingyBedwars extends JavaPlugin {
    private GameManager gameManager;

    @Override
    public void onEnable() {
        this.gameManager = new GameManager(this);

        gameManager.initializeFiles();

        this.getCommand("bedwars").setExecutor(new CommandManager(gameManager));

        for(Player player : Bukkit.getOnlinePlayers()) {
            player.teleport(Bukkit.getWorlds().getFirst().getSpawnLocation());
        }
    }

    @Override
    public void onDisable() {

    }
}
