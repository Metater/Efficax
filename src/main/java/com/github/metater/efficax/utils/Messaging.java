package com.github.metater.efficax.utils;

import com.github.metater.efficax.Efficax;
import org.bukkit.entity.Player;

public class Messaging {
    public static void SendDelayedPlayerMessage(Efficax efficax, Player player, String message, long ticks)
    {
        efficax.getServer().getScheduler().scheduleSyncDelayedTask(efficax, () ->
        {
            player.sendMessage(message);
        }, ticks);
    }
}
