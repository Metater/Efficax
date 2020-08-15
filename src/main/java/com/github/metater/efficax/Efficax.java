package com.github.metater.efficax;

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
        getLogger().info("onDisable was called!");
    }
    private void Init() {
        Efficax efficaxInstance = this;
        new CommandHandler().Init(efficaxInstance);
    }
}