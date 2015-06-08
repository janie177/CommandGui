package com.minegusta.commandgui;

import com.minegusta.commandgui.commands.GUICommand;
import com.minegusta.commandgui.data.Items;
import com.minegusta.commandgui.data.Manager;
import com.minegusta.commandgui.filemanager.ConfigHandler;
import com.minegusta.commandgui.listeners.GUIListener;
import com.minegusta.commandgui.listeners.JoinListener;
import org.bukkit.Bukkit;
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
		//Config
		ConfigHandler.createConfig();

		//Load the items
		Items.loadFromConfig();

		//Commands
		getCommand("gui").setExecutor(new GUICommand());

		//Listener
		Bukkit.getPluginManager().registerEvents(new GUIListener(), this);
		Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
	}

	@Override
	public void onDisable()
	{
		ConfigHandler.saveConfig();

	}

}
