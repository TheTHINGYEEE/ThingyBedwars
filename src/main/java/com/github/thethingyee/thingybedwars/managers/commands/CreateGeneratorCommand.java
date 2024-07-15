package com.github.thethingyee.thingybedwars.managers.commands;

import com.github.thethingyee.thingybedwars.managers.GameManager;
import com.github.thethingyee.thingybedwars.managers.components.Arena;
import com.github.thethingyee.thingybedwars.managers.components.Command;
import com.github.thethingyee.thingybedwars.managers.components.Generator;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CreateGeneratorCommand extends Command {
    public CreateGeneratorCommand(GameManager gameManager) {
        super(gameManager);
    }

    @Override
    public String getName() {
        return "creategenerator";
    }

    @Override
    public String getArguments() {
        return "<diamond || emerald>";
    }

    @Override
    public void execute(Player player, String[] args) {
        if(args.length != 1) {
            player.sendMessage(ChatColor.RED + "Please specify a generator type!");
            return;
        }

        if(!isValidGenerator(args[0])) {
            player.sendMessage(ChatColor.RED + "Please specify a VALID generator type!");
            return;
        }

        Arena arena = getGameManager().getSetupMode().getArena();
        switch(args[0]) {
            case "diamond": {
                arena.getGenerators().add(new Generator(Generator.Type.DIAMOND, player.getLocation().getBlock().getLocation()));
                player.sendMessage(ChatColor.GREEN + "Successfully placed a diamond generator! (Total: " + arena.getGenerators().size() + ")");
                break;
            }
            case "emerald": {
                arena.getGenerators().add(new Generator(Generator.Type.EMERALD, player.getLocation().getBlock().getLocation()));
                player.sendMessage(ChatColor.GREEN + "Successfully placed a emerald generator! (Total: " + arena.getGenerators().size() + ")");
                break;
            }
        }
    }

    private boolean isValidGenerator(String s) {
        try {
            Generator.Type.valueOf(s.toUpperCase());
        } catch(IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isSetupCommand() {
        return false;
    }
}
