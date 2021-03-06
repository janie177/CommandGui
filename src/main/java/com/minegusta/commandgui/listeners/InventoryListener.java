package com.minegusta.commandgui.listeners;

import com.minegusta.commandgui.data.Items;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class InventoryListener
{
	private Player p;
	private String invName;
	private InventoryClickEvent e;
	private ItemStack i;

	private InventoryListener(InventoryClickEvent e)
	{
		this.e = e;
		this.p = (Player) e.getWhoClicked();
		this.invName = e.getInventory().getName();
		this.i = e.getCurrentItem();
	}

	public static InventoryListener listen(InventoryClickEvent e)
	{
		return new InventoryListener(e);
	}

	//Methods

	public Location getLocation()
	{
		return Items.getLocation(i.getItemMeta().getDisplayName());
	}

	public Player getPlayer()
	{
		return p;
	}

	public boolean isGUIMenu()
	{
		return invName.equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD +  "Mine" + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD +  "Gusta" + ChatColor.DARK_GRAY + " " + ChatColor.BOLD + "GUI");
	}

	public boolean isNotAir()
	{
		return e.getCurrentItem() != null;
	}

	public boolean hasNoItem()
	{
		return e.getCursor() != null && e.getCursor().getType().equals(Material.AIR);
	}

	public void closeInv()
	{
		p.closeInventory();
	}

	public void cancel()
	{
		e.setCancelled(true);
	}
}
