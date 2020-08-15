package com.github.metater.efficax.commands;

import com.github.metater.efficax.Efficax;

public class Commands {
    public void Init(Efficax efficax) {
        efficax.getCommand("diamonds").setExecutor(new CommandDiamonds());
    }
}
