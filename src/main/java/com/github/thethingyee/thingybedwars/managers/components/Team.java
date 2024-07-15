package com.github.thethingyee.thingybedwars.managers.components;

import com.github.thethingyee.thingybedwars.managers.GameManager;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Set;

public class Team {

    private final Set<Player> teamPlayers;
    private final TeamColor teamColor;
    private final Location spawnPoint;


    public Team(Set<Player> teamPlayers, TeamColor teamColor, Location spawnPoint) {
        this.teamPlayers = teamPlayers;
        this.teamColor = teamColor;
        this.spawnPoint = spawnPoint;
    }

    public Set<Player> getTeamPlayers() {
        return teamPlayers;
    }

    public TeamColor getTeamColor() {
        return teamColor;
    }

    public Location getSpawnPoint() {
        return spawnPoint;
    }

    public enum TeamColor {
        RED(DyeColor.RED), BLUE(DyeColor.BLUE), GREEN(DyeColor.LIME), YELLOW(DyeColor.YELLOW), AQUA(DyeColor.CYAN), WHITE(DyeColor.WHITE), PINK(DyeColor.PINK), GRAY(DyeColor.GRAY);

        private DyeColor dyeColor;

        private TeamColor(DyeColor dyeColor) {
            this.dyeColor = dyeColor;
        }

        public DyeColor getDyeColor() {
            return dyeColor;
        }

        public ChatColor getChatColor() {
            return ChatColor.valueOf(name());
        }
    }
}
