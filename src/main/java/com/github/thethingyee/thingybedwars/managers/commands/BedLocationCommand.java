package com.github.thethingyee.thingybedwars.managers.commands;

import com.github.thethingyee.thingybedwars.managers.GameManager;
import com.github.thethingyee.thingybedwars.managers.SetupMode;
import com.github.thethingyee.thingybedwars.managers.components.Command;
import com.github.thethingyee.thingybedwars.managers.components.Team;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Bed;
import org.bukkit.entity.Player;

public class BedLocationCommand extends Command {
    public BedLocationCommand(GameManager gameManager) {
        super(gameManager);
    }

    @Override
    public String getName() {
        return "bedloc";
    }

    @Override
    public String getArguments() {
        return "";
    }

    @Override
    public void execute(Player player, String[] args) {
        if(args.length != 1) {
            player.sendMessage(ChatColor.RED + "Please specify the team color to set the bed to.");
            return;
        }


        Block block = player.getTargetBlockExact(5);
        if(!(block instanceof Bed)) {
            player.sendMessage(ChatColor.RED + "Please select a bed to set.");
            return;
        }
        SetupMode setup = getGameManager().getSetupMode();

        Team selectedTeam = setup.getTeamByTeamColor(GameManager.parseTeamColors(args[0])[0]);
        selectedTeam.setTeamBedBlock(block);

        player.sendMessage(ChatColor.GREEN + "Successfully set bed location for team " + selectedTeam.getTeamColor().name());
    }

    @Override
    public boolean isSetupCommand() {
        return true;
    }
}
