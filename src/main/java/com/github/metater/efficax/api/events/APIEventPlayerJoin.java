package com.github.metater.efficax.api.events;

import com.github.metater.efficax.Efficax;
import com.github.metater.efficax.api.APIHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class APIEventPlayerJoin implements Listener {
    Efficax efficax;
    public APIEventPlayerJoin(Efficax efficax)
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
                    response = APIHandler.SendDataToAPI("Hello");
                } catch (Exception e) {
                    playerJoinEvent.getPlayer().sendMessage("Failed");
                }
            }
        });
    }
}
