package com.github.metater.efficax.nonight;

import com.github.metater.efficax.Efficax;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class NoNightHandler {
    private Efficax efficax;
    public NoNightHandler(Efficax efficax) { this.efficax = efficax; }
    public boolean anyoneSleeping = false;

    //12541 and 23458


    public void PlayerEnterBed(Player playerInBed)
    {
        if (anyoneSleeping)
            return;
        anyoneSleeping = true;
        efficax.getServer().getScheduler().scheduleSyncDelayedTask(efficax, () ->
        {
            if (playerInBed.isSleeping())
            {
                efficax.getServer().getWorld("world").setTime(0);
                for(Player player : efficax.getServer().getOnlinePlayers())
                {
                    if (player.getWorld().getEnvironment().equals(World.Environment.NORMAL))
                    {
                        player.sendMessage(ChatColor.YELLOW + "Wakey Wakey!");
                    }
                }
                //efficax.getLogger().info(playerInBed.getWorld().getFullTime() + "");
                playerInBed.setStatistic(Statistic.TIME_SINCE_REST, 0);
            }
            anyoneSleeping = false;
        }, 95);
    }
    private static boolean AllPlayersSleeping(Efficax efficax)
    {
        for(Player player : efficax.getServer().getOnlinePlayers())
            if (!player.isSleeping()) return false;
        return true;
    }
}
