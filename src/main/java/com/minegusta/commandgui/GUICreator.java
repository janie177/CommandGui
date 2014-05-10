package com.minegusta.commandgui;

import com.minegusta.commandgui.filemanager.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public class GUICreator
{
	private static FileConfiguration getConfig()
	{
		return ConfigHandler.getConfig();
	}

	public static void createGUI(Player p)
	{
		int count = 0;
		Set<String> keys = getConfig().getKeys(false);
		Inventory inv = createInventory(keys.size());
		for(String s : keys)
		{
			if(!(hasPerm(s, p)) || !(hasData(s)))return;

			String desc = getConfig().getString(s + ".description");
			String command = getConfig().getString(s + ".command");
			int id = getConfig().getInt(s + ".item");
			String name = getConfig().getString(s + ".name");

			GUIItem item = new GUIItem(name, id, desc, command);
			ItemStack itemToAdd = item.assemble();

			inv.setItem(count, itemToAdd);
			count++;
			p.openInventory(inv);
		}

	}

	//private methods for the creation

	private static boolean hasPerm(String key, Player p)
	{
		return !(getConfig().isSet(key + ".permissions-node")) || p.hasPermission(getConfig().getString(key + ".permissions-node"));
	}

	private static boolean hasData(String key)
	{
		return getConfig().isSet(key + ".name") && getConfig().isSet(key + ".command") && getConfig().isSet(key + ".description") && getConfig().isSet(key + ".item");
	}





	private static Inventory createInventory(int slots)
	{
		if(slots < 9)
		{
			slots = 9;
		}
		if(slots > 9)
		{
			slots = 18;
		}
		if(slots > 18)
		{
			slots = 27;
		}

		return Bukkit.createInventory(null, slots, ChatColor.GOLD + "Minegusta Command GUI");
	}
}
