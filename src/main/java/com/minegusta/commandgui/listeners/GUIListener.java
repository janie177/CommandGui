package com.minegusta.commandgui.listeners;

import com.minegusta.commandgui.GUICreator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class GUIListener implements Listener
{
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e)
	{
		InventoryListener inv = InventoryListener.listen(e);

		if(!inv.isGUIMenu()){return;}
		if(!inv.isNotAir())
		{
			inv.cancel();
			inv.getPlayer().updateInventory();
			return;
		}
		if(!inv.hasNoItem())
		{
			inv.cancel();
			inv.getPlayer().updateInventory();
			return;
		}
		inv.cancel();
		inv.closeInv();
		try {
			inv.getPlayer().teleport(inv.getLocation());
		} catch (Exception ignored){}
	}

	@EventHandler
	public void onRightClick(PlayerInteractEvent e)
	{
		Player p = e.getPlayer();
		ItemStack s = p.getItemInHand();
		Material m = s.getType();

		if((e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && m.equals(Material.WATCH))
		{
			GUICreator.createGUI(p);
		}
	}
}
