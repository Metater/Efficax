package com.github.metater.efficax.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import com.github.metater.efficax.utils.TestUtils;

public class CommandDiamonds implements CommandExecutor {
    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            // Here we need to give items to our player
            if (!(TestUtils.firstArgIsNotNullAndIsIntAndOneArg(args)))
                return false;
            ItemStack diamonds = new ItemStack(Material.DIAMOND, Integer.parseInt(args[0]));
            player.getInventory().addItem(diamonds);
        }
        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
