package com.github.thethingyee.thingybedwars.managers.commands;

import com.github.thethingyee.thingybedwars.managers.GameManager;
import com.github.thethingyee.thingybedwars.managers.SetupMode;
import com.github.thethingyee.thingybedwars.managers.components.Command;
import com.github.thethingyee.thingybedwars.managers.components.Team;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class CreateTeamsCommand extends Command {
    public CreateTeamsCommand(GameManager gameManager) {
        super(gameManager);
    }

    @Override
    public String getName() {
        return "createteams";
    }

    @Override
    public String getArguments() {
        return "";
    }

    @Override
    public void execute(Player player, String[] args) {
        if(args.length <= SetupMode.MIN_TEAMS_NEEDED) return;

        SetupMode setup = getGameManager().getSetupMode();

        ArrayList<Team> teams = setup.createTeams(GameManager.parseTeamColors(args));
        teams.forEach(team -> {
            player.sendMessage(team.getTeamColor().getChatColor() + "" + ChatColor.BOLD + "Successfully created " + team.getTeamColor().name() + " team");
        });
    }

    @Override
    public boolean isSetupCommand() {
        return true;
    }
}
