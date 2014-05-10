package com.minegusta.commandgui;

import com.google.common.collect.Lists;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class GUIItem
{
	private String name;
	private String desc;
	private int itemID;
	private String command;

	public GUIItem(String name, Integer itemID, String description, String command)
	{
		this.name = name;
		this.itemID = itemID;
		this.desc = description;
		this.command = command;
	}

	private Material getMaterial()
	{
		return Material.getMaterial(itemID);
	}

	public ItemStack assemble()
	{
		ItemStack i = new ItemStack(getMaterial(), 1);
		ItemMeta meta = i.getItemMeta();

		List<String> lore = Lists.newArrayList();
		lore.add(ChatColor.AQUA + desc);
		lore.add(ChatColor.YELLOW + "Command: " + ChatColor.GRAY + command);

		meta.setDisplayName(ChatColor.GOLD + name);
		meta.setLore(lore);
		i.setItemMeta(meta);

		return i;
	}


}
