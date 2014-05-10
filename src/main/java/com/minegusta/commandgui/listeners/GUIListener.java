package com.minegusta.commandgui.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIListener implements Listener
{
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e)
	{
		InventoryListener inv = InventoryListener.listen(e);

		if(!inv.isGUIMenu())return;
		if(!inv.isNotAir())
		{
			inv.cancel();
			return;
		}
		if(!inv.hasNoItem())
		{
			inv.cancel();
		}
		else
		{
			inv.cancel();
			inv.closeInv();

			inv.getPlayer().chat("/" + inv.getCommand());
		}
	}
}
