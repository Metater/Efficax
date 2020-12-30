package com.github.metater.efficax.commands;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpawnDistance implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.getWorld().getEnvironment().equals(World.Environment.NORMAL)){
                player.sendMessage(ChatColor.AQUA + "You are " + (int)player.getLocation().distance(player.getWorld().getSpawnLocation()) + " blocks away from spawn");
            }
            else
            {
                player.sendMessage(ChatColor.RED + "You are not in the overworld");
            }
        }
        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
