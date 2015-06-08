package com.minegusta.commandgui.listeners;

import com.google.common.collect.Lists;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinListener implements Listener{

    private static final ItemStack watch = new ItemStack(Material.WATCH, 1)
    {
        {
            ItemMeta meta = getItemMeta();
            meta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Teleport Interface");
            meta.setLore(Lists.newArrayList(ChatColor.LIGHT_PURPLE + "Use this to navigate!"));

            setItemMeta(meta);
        }
    };

    @EventHandler
    public void onConnect(PlayerJoinEvent e)
    {
        e.getPlayer().setItemInHand(watch);
    }
}
