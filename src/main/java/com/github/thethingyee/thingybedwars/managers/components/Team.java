package com.github.thethingyee.thingybedwars.managers.components;

import com.github.thethingyee.thingybedwars.managers.GameManager;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.Set;

public class Team {

    private Set<Player> teamPlayers;
    private final TeamColor teamColor;
    private Location spawnPoint;
    private Block teamBedBlock;


    public Team(TeamColor teamColor) {
        this.teamColor = teamColor;

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

    public void setTeamPlayers(Set<Player> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    public void setSpawnPoint(Location spawnPoint) {
        this.spawnPoint = spawnPoint;
    }

    public Block getTeamBedBlock() {
        return teamBedBlock;
    }

    public void setTeamBedBlock(Block teamBedBlock) {
        this.teamBedBlock = teamBedBlock;
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
