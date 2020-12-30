package com.github.metater.efficax.commands;

import com.github.metater.efficax.Efficax;

public class CommandHandler {
    public void Init(Efficax efficax) {
        efficax.getCommand("diamonds").setExecutor(new CommandDiamonds());
        efficax.getCommand("gui").setExecutor(new CommandGUI());
        efficax.getCommand("dist").setExecutor(new CommandSpawnDistance());
    }
}
