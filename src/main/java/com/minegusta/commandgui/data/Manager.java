package com.minegusta.commandgui.data;

import com.minegusta.commandgui.GUIItem;
import com.minegusta.commandgui.filemanager.ConfigHandler;

public class Manager
{
    public static void addItem(GUIItem item)
    {
        Items.add(item);

        String s = item.name();

        ConfigHandler.getConfig().set(s + ".description", item.desc());
        ConfigHandler.getConfig().set(s + ".item", item.getMaterial());
        ConfigHandler.getConfig().set(s + ".name", item.name());
        ConfigHandler.getConfig().set(s + ".world", item.getLocation().getWorld().getName());
        ConfigHandler.getConfig().set(s + ".x", (int) item.getLocation().getX());
        ConfigHandler.getConfig().set(s + ".y", (int) item.getLocation().getY());
        ConfigHandler.getConfig().set(s + ".z", (int) item.getLocation().getZ());
        ConfigHandler.getConfig().set(s + ".slot", item.slot());

        ConfigHandler.saveConfig();
    }

    public static void removeItem(GUIItem item)
    {
        ConfigHandler.getConfig().set(item.name(), null);
        Items.remove(item.name());

        ConfigHandler.saveConfig();
    }
}
