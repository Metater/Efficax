package com.github.metater.efficax.api.events;

import com.github.metater.efficax.Efficax;
import com.github.metater.efficax.api.APIHandler;
import org.bukkit.entity.Player;
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

    @EventHandler public void onPlayerJoin(final PlayerJoinEvent playerJoinEvent) { SendPlayerEventToAPI(playerJoinEvent.getPlayer(), "join"); }
    @EventHandler public void onPlayerQuit(final PlayerQuitEvent playerQuitEvent) { SendPlayerEventToAPI(playerQuitEvent.getPlayer(), "quit"); }

    public void SendPlayerEventToAPI(final Player player, final String eventType)
    {
        efficax.getServer().getScheduler().runTaskAsynchronously(efficax, () ->
        {
            String response = APIHandler.SendDataToAPI("{\"player\":\"" + player.getDisplayName() + "\",\"event\":\"" + eventType + "\"}");
            if (response == "503") efficax.getLogger().info("API Server is down: " + response);
        });
    }
}
