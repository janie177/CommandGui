package com.minegusta.commandgui;

import com.minegusta.commandgui.filemanager.ConfigHandler;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{

	public static Plugin PLUGIN;

	public Main()
	{
		PLUGIN = this;
	}

	@Override
	public void onEnable()
	{
		ConfigHandler.createConfig();
	}

	@Override
	public void onDisable()
	{

	}

}
