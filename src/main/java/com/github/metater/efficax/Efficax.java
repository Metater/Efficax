package com.github.metater.efficax;

import com.github.metater.efficax.api.APIHandler;
import com.github.metater.efficax.api.data.APIData;
import com.github.metater.efficax.api.requests.APIRequests;
import com.github.metater.efficax.commands.CommandHandler;
import com.github.metater.efficax.nonight.NoNightHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class Efficax extends JavaPlugin {

    public NoNightHandler noNightHandler = new NoNightHandler(this);

    @Override
    public void onEnable() {
        APIData.ServerAction serverAction = new APIData.ServerAction("GaemerBoius", "startup");
        APIRequests.SendDataToAPIVoid(serverAction.ToJSON());
        //getLogger().info("onEnable was called!");
        Init();
    }
    @Override
    public void onDisable() {
        //getLogger().info("onDisable was called!");
        APIData.ServerAction serverAction = new APIData.ServerAction("GaemerBoius", "shutdown");
        APIRequests.SendDataToAPIVoid(serverAction.ToJSON());
    }
    private void Init() {
        new CommandHandler().Init(this);
        new APIHandler().Init(this);
    }
}