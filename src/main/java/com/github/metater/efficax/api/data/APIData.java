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
        public String world, x, y, z;
        public PlayerEvent(String dataSubtype, String serverName, String movementType, String playerName, String world, String x, String y, String z)
        {
            this.dataSubtype = dataSubtype;
            this.serverName = serverName;
            this.movementType = movementType;
            this.playerName = playerName;
            this.world = world;
            this.x = x;
            this.y = y;
            this.z = z;
        }
        public String ToJSON()
        {
            return String.format("{\"type\":\"%s\",\"subtype\":\"%s\",\"server\":\"%s\",\"movement\":\"%s\",\"name\":\"%s\",\"world\":\"%s\",\"location\":[%s,%s,%s]}", dataType, dataSubtype, serverName, movementType, playerName, world, x, y, z);
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
