package com.github.metater.efficax.api;

import com.github.metater.efficax.Efficax;
import com.github.metater.efficax.api.events.APIEventPlayer;

public class APIHandler {
    public void Init(Efficax efficax) {
        efficax.getServer().getPluginManager().registerEvents(new APIEventPlayer(efficax), efficax);
    }
}
