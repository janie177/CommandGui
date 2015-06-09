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
	private static int maxSlot = 0;

	public static void setMaxSlot()
	{
		for(GUIItem item : Items.getItems().values())
		{
			if(item.slot() > maxSlot)
			{
				maxSlot = item.slot();
			}
		}
	}

	public static void createGUI(Player p)
	{
		Inventory inv = createInventory(maxSlot + 1);
		for(GUIItem item : Items.getItems().values())
		{
			ItemStack itemToAdd = item.assemble();
			inv.setItem(item.slot(), itemToAdd);
		}
		p.openInventory(inv);

	}

	private static Inventory createInventory(int slots)
	{
		if(slots % 9 != 0)
		{
			slots = slots + 9 - (slots % 9);
		}

		return Bukkit.createInventory(null, slots, ChatColor.RED + "" + ChatColor.BOLD + "DG"+ ChatColor.DARK_GRAY + "-" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "MG" + ChatColor.DARK_GRAY + " " + ChatColor.BOLD + "CLUB");
	}
}
