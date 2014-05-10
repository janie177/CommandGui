package com.minegusta.commandgui.filemanager;

import com.minegusta.commandgui.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigHandler
{
	public static void createConfig()
	{
		Main.PLUGIN.getConfig().options().copyDefaults(true);
		Main.PLUGIN.saveDefaultConfig();
	}

	public static FileConfiguration getConfig()
	{
		return Main.PLUGIN.getConfig();
	}

}
