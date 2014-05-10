package com.minegusta.commandgui.commands;

import com.minegusta.commandgui.GUICreator;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class GUICommand implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args)
	{
		if(!(cmd.getName().equalsIgnoreCase("gui")))return false;
		if(s instanceof ConsoleCommandSender)return false;
		else
		{
			Player p = (Player) s;
			GUICreator.createGUI(p);
			return true;
		}

	}
}
