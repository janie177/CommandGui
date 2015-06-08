package com.minegusta.commandgui;

import com.minegusta.commandgui.data.Items;
import com.minegusta.commandgui.filemanager.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
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
		Set<String> keys = getConfig().getKeys(false);
		Inventory inv = createInventory(keys.size());
		for(GUIItem item : Items.getItems().values())
		{
			ItemStack itemToAdd = item.assemble();
			inv.setItem(item.slot(), itemToAdd);
		}
		p.openInventory(inv);

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

		return Bukkit.createInventory(null, slots, ChatColor.RED + "MG-DG Command GUI");
	}
}
