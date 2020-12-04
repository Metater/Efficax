package com.github.metater.efficax.api.events;

import com.github.metater.efficax.Efficax;
import com.github.metater.efficax.api.data.APIData;
import com.github.metater.efficax.api.requests.APIRequests;
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
            APIData.PlayerEvent apiPlayerEventData = new APIData.PlayerEvent("playerEvent", "GaemerBoius", eventType, player.getDisplayName());

            String response = APIRequests.SendDataToAPI(apiPlayerEventData.ToJSON());
            if (response.equals("503")) efficax.getLogger().info("API Server is down: " + response);
        });
    }
}
