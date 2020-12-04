package com.github.metater.efficax.api.data;

public class APIData {
    public static class MCServer
    {
        public String dataType = "mcServerData";
        public String dataSubtype;
        public String serverName;
    }
    public static class PlayerEvent extends MCServer
    {
        public String movementType;
        public String playerName;
        public PlayerEvent(String dataSubtype, String serverName, String movementType, String playerName)
        {
            this.dataSubtype = dataSubtype;
            this.serverName = serverName;
            this.movementType = movementType;
            this.playerName = playerName;
        }
        public String ToJSON()
        {
            return String.format("{\"type\":\"%s\",\"subtype\":\"%s\",\"server\":\"%s\",\"movement\":\"%s\",\"name\":\"%s\"}", dataType, dataSubtype, serverName, movementType, playerName);
        }
    }
    public static class ServerAction extends MCServer
    {
        public String action;
        public ServerAction(String serverName, String action)
        {
            this.dataSubtype = "serverAction";
            this.serverName = serverName;
            this.action = action;
        }
        public String ToJSON()
        {
            return String.format("{\"type\":\"%s\",\"subtype\":\"%s\",\"server\":\"%s\",\"action\":\"%s\"}", dataType, dataSubtype, serverName, action);
        }
    }
}
