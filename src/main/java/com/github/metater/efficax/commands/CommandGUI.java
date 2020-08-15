package com.github.metater.efficax.commands;

import com.github.metater.efficax.gui.GUIExample;
import com.github.metater.efficax.utils.TestUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGUI implements CommandExecutor {
    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (TestUtils.argsIsNotNull(args))
                return false;
            new GUIExample().openInventory(player);
        }
        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
