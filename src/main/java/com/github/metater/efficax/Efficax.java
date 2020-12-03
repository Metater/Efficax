package com.github.metater.efficax;

import com.github.metater.efficax.api.APIHandler;
import com.github.metater.efficax.commands.CommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class Efficax extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("onEnable was called!");
        Init();
    }
    @Override
    public void onDisable() {
        //getLogger().info("onDisable was called!");
        tellAPIServerShutdown();
    }
    private void tellAPIServerShutdown()
    {
        APIHandler.SendDataToAPIVoid("{\"shutdown\":true}");
    }
    private void Init() {
        Efficax efficaxInstance = this;
        new CommandHandler().Init(efficaxInstance);
        new APIHandler().Init(efficaxInstance);
    }
}