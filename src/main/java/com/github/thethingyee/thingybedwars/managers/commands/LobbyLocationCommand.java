package com.github.thethingyee.thingybedwars.managers.commands;

import com.github.thethingyee.thingybedwars.managers.GameManager;
import com.github.thethingyee.thingybedwars.managers.components.Arena;
import com.github.thethingyee.thingybedwars.managers.components.Command;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class LobbyLocationCommand extends Command {
    public LobbyLocationCommand(GameManager gameManager) {
        super(gameManager);
    }

    @Override
    public String getName() {
        return "lobbyloc";
    }

    @Override
    public String getArguments() {
        return "";
    }

    @Override
    public void execute(Player player, String[] args) {
        Location loc = player.getLocation();
        Arena arena = getGameManager().getSetupMode().getArena();
        arena.setLobbyLocation(loc);

        player.sendMessage(ChatColor.GREEN + "Successfully set lobby location spawn!");
    }

    @Override
    public boolean isSetupCommand() {
        return true;
    }
}
