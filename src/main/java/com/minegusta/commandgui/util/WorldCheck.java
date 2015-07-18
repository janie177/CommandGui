package com.minegusta.commandgui.util;

import com.minegusta.commandgui.filemanager.ConfigHandler;
import org.bukkit.World;

import java.util.List;

public class WorldCheck
{
    private static List<String> worlds;

    public static boolean isEnabled(World world)
    {
        return worlds.contains(world.getName());
    }

    public static void setWorlds()
    {
        worlds = ConfigHandler.getConfig().getStringList("enabled-worlds");
    }
}
