package com.minegusta.commandgui.listeners;

import org.bukkit.ChatColor;
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

	public String getCommand()
	{
		List<String> lore = i.getItemMeta().getLore();
		String command = "This is an error.";
		for(String s : lore)
		{
			if(s.contains((ChatColor.YELLOW + "Command: ")))
			{
				command = s.replace(ChatColor.YELLOW + "Command: " + ChatColor.GRAY, "");
			}
		}
		return command;
	}

	public Player getPlayer()
	{
		return p;
	}

	public boolean isGUIMenu()
	{
		return invName.equalsIgnoreCase(ChatColor.RED + "MG-DG Command GUI");
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
