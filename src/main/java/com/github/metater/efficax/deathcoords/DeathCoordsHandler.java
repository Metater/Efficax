package com.github.metater.efficax.deathcoords;

import com.github.metater.efficax.Efficax;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static com.github.metater.efficax.utils.Messaging.SendDelayedPlayerMessage;

import static com.github.metater.efficax.utils.Formatting.FormatWorldText;

public class DeathCoordsHandler {
    public static void PlayerDied(Efficax efficax, Player player)
    {
        String message = "";
        message += ChatColor.AQUA + player.getDisplayName()+ "'s Death Coordinates: " + ChatColor.RED + "(";
        message += ((int)player.getLocation().getX()) + ", ";
        message += ((int)player.getLocation().getY()) + ", ";
        message += ((int)player.getLocation().getZ()) + ")\n";
        message += ChatColor.AQUA + "You died while in the " + ChatColor.RED + FormatWorldText(player.getLocation().getWorld().getName());

        SendDelayedPlayerMessage(efficax, player, message, 5);
    }
}
