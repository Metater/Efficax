package com.github.metater.efficax.utils;

public class Formatting {
    public static String FormatWorldText(String world)
    {
        switch (world)
        {
            case "world": return "overworld";
            case "world_nether": return "nether";
            case "world_the_end": return "end";
            default: return world;
        }
    }
}
