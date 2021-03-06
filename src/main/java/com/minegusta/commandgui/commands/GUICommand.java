package com.minegusta.commandgui.commands;

import com.minegusta.commandgui.GUICreator;
import com.minegusta.commandgui.GUIItem;
import com.minegusta.commandgui.data.Items;
import com.minegusta.commandgui.data.Manager;
import com.minegusta.commandgui.filemanager.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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
		if(s instanceof ConsoleCommandSender)return false;

		Player p = (Player) s;

		if(p.isOp() && args.length > 0){

			if(args[0].equalsIgnoreCase("add"))
			{
				try
				{
					Material item = Material.valueOf(args[2].toUpperCase());
					String name = args[1];
					int slot = Integer.parseInt(args[3]);
					String desc = "";

					for(int i = 4; i < args.length; i++)
					{
						desc = desc + args[i] + " ";
					}

					if(slot > 35)
					{
						s.sendMessage(ChatColor.RED + "Slot cannot be higher than 35.");
						return true;
					}

					Manager.addItem(new GUIItem(name, item, desc, p.getWorld(), (int) p.getLocation().getX(), (int) p.getLocation().getY(), (int) p.getLocation().getZ(), (int) p.getLocation().getPitch(), (int) p.getLocation().getYaw(), slot));

					s.sendMessage(ChatColor.GREEN + "You added " + name + ChatColor.GREEN + " to the GUI!");
					return true;

				}catch (Exception ignored)
				{
					s.sendMessage(ChatColor.RED + "Usage: /gui remove <name>");
					s.sendMessage(ChatColor.RED + "Usage: /gui add <name> <material> <slot> <description>");
					s.sendMessage(ChatColor.RED + "Usage: /gui list");
				}
			}
			else if(args .length > 1 && args[0].equalsIgnoreCase("remove"))
			{
				try
				{
					String name = args[1];
					Manager.removeItem(name);
					s.sendMessage(ChatColor.GREEN + "You removed " + name + ChatColor.GREEN + " from the GUI!");

					return true;

				}catch (Exception ignored)
				{
					s.sendMessage(ChatColor.RED + "Usage: /gui remove <name>");
					s.sendMessage(ChatColor.RED + "Usage: /gui add <name> <material> <slot> <description>");
					s.sendMessage(ChatColor.RED + "Usage: /gui list");
				}
			}
			else if(args[0].equalsIgnoreCase("list"))
			{
				s.sendMessage(ChatColor.YELLOW + "All GUI items: ");
				for(String string : Items.getItems().keySet())
				{
					s.sendMessage(ChatColor.DARK_GRAY + " - " + ChatColor.LIGHT_PURPLE + string);
				}
				return true;
			}
			s.sendMessage(ChatColor.RED + "Usage: /gui remove <name>");
			s.sendMessage(ChatColor.RED + "Usage: /gui add <name> <material> <slot> <description>");
			s.sendMessage(ChatColor.RED + "Usage: /gui list");
			return true;
		}

		GUICreator.createGUI(p);
		return true;
	}
}
