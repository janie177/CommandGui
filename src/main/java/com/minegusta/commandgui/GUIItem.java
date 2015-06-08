package com.minegusta.commandgui;

import com.google.common.collect.Lists;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class GUIItem
{
	private String name;
	private String desc;
	private Material material;
	private Location destination;
	private int slot;

	public GUIItem(String name, Material material, String description, World w, int x, int y, int z, int pitch, int yaw, int slot)
	{
		this.name = name;
		this.material = material;
		this.desc = description;
		this.destination = new Location(w, x, y, z, yaw, pitch);
		this.slot = slot;
	}

	public Material getMaterial()
	{
		return material;
	}

	public ItemStack assemble()
	{
		ItemStack i = new ItemStack(getMaterial(), 1);
		ItemMeta meta = i.getItemMeta();

		List<String> lore = Lists.newArrayList();
		lore.add(ChatColor.translateAlternateColorCodes('&', desc));

		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		meta.setLore(lore);
		i.setItemMeta(meta);

		return i;
	}

	public int slot()
	{
		return slot;
	}

	public String name()
	{
		return name;
	}

	public String desc()
	{
		return desc;
	}

	public Location getLocation()
	{
		return destination;
	}
}
