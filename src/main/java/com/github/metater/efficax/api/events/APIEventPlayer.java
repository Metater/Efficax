package com.github.metater.efficax.api.events;

import com.github.metater.efficax.Efficax;
import com.github.metater.efficax.api.APIHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class APIEventPlayer implements Listener {
    Efficax efficax;
    public APIEventPlayer(Efficax efficax)
    {
        this.efficax = efficax;
    }
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent playerJoinEvent)
    {
        playerJoinEvent.getPlayer().sendMessage("Gamer");
        efficax.getServer().getScheduler().runTaskAsynchronously(efficax, () -> {
            {
                String response = "Failed";
                try {
                    response = APIHandler.SendDataToAPI(playerJoinEvent.getPlayer().getDisplayName());
                } catch (Exception e) {
                    playerJoinEvent.getPlayer().sendMessage("Failed");
                }
            }
        });
    }
    @EventHandler
    public void onPlayerQuit(final PlayerQuitEvent playerQuitEvent)
    {
        playerQuitEvent.getPlayer().sendMessage("Gamer");
        efficax.getServer().getScheduler().runTaskAsynchronously(efficax, () -> {
            {
                String response = "503";
                try {
                    response = APIHandler.SendDataToAPI(playerQuitEvent.getPlayer().getDisplayName());
                } catch (Exception e) {
                }
            }
        });
    }
}
