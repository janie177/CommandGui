package com.minegusta.commandgui.data;

import com.google.common.collect.Maps;
import com.minegusta.commandgui.GUIItem;
import com.minegusta.commandgui.filemanager.ConfigHandler;
import org.bukkit.*;

import java.util.Set;
import java.util.concurrent.ConcurrentMap;

public class Items
{
    public static ConcurrentMap<String, GUIItem> guiObjects = Maps.newConcurrentMap();

    public static void add(GUIItem item)
    {
        guiObjects.put(item.name(), item);
    }

    public static void loadFromConfig()
    {
        guiObjects.clear();

        Set<String> keys = ConfigHandler.getConfig().getKeys(false);
        for(String s : keys)
        {
            if(!(hasData(s)))continue;

            String desc = ConfigHandler.getConfig().getString(s + ".description");
            Material material = Material.valueOf(ConfigHandler.getConfig().getString(s + ".item").toUpperCase());
            String name = ConfigHandler.getConfig().getString(s + ".name");
            World world = Bukkit.getWorld(ConfigHandler.getConfig().getString(s + ".world"));
            int x = ConfigHandler.getConfig().getInt(s + ".x");
            int y = ConfigHandler.getConfig().getInt(s + ".y");
            int z = ConfigHandler.getConfig().getInt(s + ".z");
            int slot = ConfigHandler.getConfig().getInt(s + ".slot");

            GUIItem item = new GUIItem(name, material, desc, world, x, y, z, slot);

            guiObjects.put(ChatColor.translateAlternateColorCodes('&', item.name()), item);
        }

    }

    private static boolean hasData(String key)
    {
        return ConfigHandler.getConfig().isSet(key + ".name") && ConfigHandler.getConfig().isSet(key + ".world") && ConfigHandler.getConfig().isSet(key + ".description") && ConfigHandler.getConfig().isSet(key + ".item") && ConfigHandler.getConfig().isSet(key + ".x") && ConfigHandler.getConfig().isSet(key + ".y") && ConfigHandler.getConfig().isSet(key + ".z") && ConfigHandler.getConfig().isSet(key + ".slot");
    }

    public static void remove(String name)
    {
        if(guiObjects.containsKey(name)) {
            guiObjects.remove(name);
        }
    }

    public static ConcurrentMap<String, GUIItem> getItems()
    {
        return guiObjects;
    }

    public static boolean contains(String name)
    {
        return guiObjects.containsKey(name);
    }

    public static Location getLocation(String name)
    {
        for(String s : guiObjects.keySet())
        {
            Bukkit.broadcastMessage(" - " + s);
        }
        return guiObjects.get(name).getLocation();
    }
}
