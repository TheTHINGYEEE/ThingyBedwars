package com.github.thethingyee.thingybedwars.managers;

import com.github.thethingyee.thingybedwars.managers.commands.CreateTeamsCommand;
import com.github.thethingyee.thingybedwars.managers.commands.SetupCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommandManager implements CommandExecutor {

    private Set<com.github.thethingyee.thingybedwars.managers.components.Command> registeredCommands = new HashSet<>();

    private final GameManager gameManager;

    public CommandManager(GameManager gameManager) {
        this.gameManager = gameManager;
        registeredCommands.add(new SetupCommand(gameManager));
        registeredCommands.add(new CreateTeamsCommand(gameManager));
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) return true;
        Player player = (Player) commandSender;

        if(!command.getName().equalsIgnoreCase("bedwars")) return true;
        for(com.github.thethingyee.thingybedwars.managers.components.Command cmd : registeredCommands) {
            if(strings[0].equalsIgnoreCase(cmd.getName())) {
                if(cmd.isSetupCommand() && !gameManager.getSetupMode().onSetupMode()) {
                    player.sendMessage(ChatColor.RED + "You must be in setup mode in order to do this command.");
                    break;
                }
                cmd.execute(player, Arrays.copyOfRange(strings, 1, strings.length));
                break;
            }
        }
        return true;
    }
}
