package com.github.thethingyee.thingybedwars.managers.commands;

import com.github.thethingyee.thingybedwars.managers.GameManager;
import com.github.thethingyee.thingybedwars.managers.SetupMode;
import com.github.thethingyee.thingybedwars.managers.components.Arena;
import com.github.thethingyee.thingybedwars.managers.components.Command;
import com.github.thethingyee.thingybedwars.managers.worldmap.GameMap;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class SetupCommand extends Command {

    public SetupCommand(GameManager gameManager) {
        super(gameManager);
    }

    @Override
    public String getName() {
        return "setup";
    }

    @Override
    public String getArguments() {
        return null;
    }

    @Override
    public void execute(Player player, String[] args) {

        // bw setup <world_name>

        if(getGameManager().getSetupMode() == null) getGameManager().setSetupMode(new SetupMode(getGameManager()));

        SetupMode setup = getGameManager().getSetupMode();

        GameMap gameMap = setup.createGameMap(getGameManager().getMapsFolder(), args[0], true);
        player.teleport(gameMap.getWorld().getSpawnLocation());
        player.setFlying(true);
        player.setGameMode(GameMode.CREATIVE);

        Arena arena = setup.createArena();
        setup.setSetupMode(true);

        String msg = this.getGameManager().getSetupMode().onSetupMode() ? ChatColor.GREEN + "Setup mode for the current world is now ENABLED." : ChatColor.RED + "Setup mode for the current world is now DISABLED.";

        player.sendMessage(msg);

    }

    @Override
    public boolean isSetupCommand() {
        return false;
    }
}
