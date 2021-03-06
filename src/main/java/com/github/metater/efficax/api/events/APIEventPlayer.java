package com.github.metater.efficax.api.events;

import com.github.metater.efficax.Efficax;
import com.github.metater.efficax.api.data.APIData;
import com.github.metater.efficax.api.requests.APIRequests;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;

import static com.github.metater.efficax.deathcoords.DeathCoordsHandler.PlayerDied;

public class APIEventPlayer implements Listener {

    private Efficax efficax;
    public APIEventPlayer(Efficax efficax)
    {
        this.efficax = efficax;
    }

    @EventHandler public void onPlayerJoin(final PlayerJoinEvent playerJoinEvent) { SendPlayerEventToAPI(playerJoinEvent.getPlayer(), "join"); }
    @EventHandler public void onPlayerQuit(final PlayerQuitEvent playerQuitEvent) { SendPlayerEventToAPI(playerQuitEvent.getPlayer(), "quit"); }
    @EventHandler public void onPlayerDeath(final PlayerDeathEvent playerDeathEvent) {
        Player player = playerDeathEvent.getEntity().getPlayer();
        PlayerDied(efficax, player);
        SendPlayerEventToAPI(player, "death");
    }
    @EventHandler public void onPlayerBedEnter(final PlayerBedEnterEvent playerBedEnterEvent)
    {
        if (playerBedEnterEvent.getBedEnterResult().equals(PlayerBedEnterEvent.BedEnterResult.OK))
            efficax.noNightHandler.PlayerEnterBed(playerBedEnterEvent.getPlayer());
    }
    @EventHandler public void onPlayerPortal(final PlayerPortalEvent playerPortalEvent)
    {
        if (playerPortalEvent.getCause().equals(PlayerPortalEvent.TeleportCause.END_PORTAL))
            playerPortalEvent.setCancelled(true);
    }

    public void SendPlayerEventToAPI(final Player player, final String eventType)
    {
        efficax.getServer().getScheduler().runTaskAsynchronously(efficax, () ->
        {
            APIData.PlayerEvent apiPlayerEventData = new APIData.PlayerEvent("playerEvent", "Test", eventType, player.getDisplayName(),
                    player.getWorld().toString(), Double.toString(player.getLocation().getX()), Double.toString(player.getLocation().getY()), Double.toString(player.getLocation().getZ()));

            String response = APIRequests.SendDataToAPI(apiPlayerEventData.ToJSON());
            if (response.equals("503")) efficax.getLogger().info("API Server is down: " + response);
        });
    }
}
