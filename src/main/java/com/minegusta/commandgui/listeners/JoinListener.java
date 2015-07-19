package com.minegusta.commandgui.listeners;

import com.google.common.collect.Lists;
import com.minegusta.commandgui.util.WorldCheck;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
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

    private static final ItemStack[] armour = new ItemStack[]{new ItemStack(Material.LEATHER_HELMET), new ItemStack(Material.LEATHER_CHESTPLATE), new ItemStack(Material.LEATHER_LEGGINGS), new ItemStack(Material.LEATHER_BOOTS)};

    @EventHandler
    public void onConnect(PlayerJoinEvent e)
    {
        if(e.getPlayer().getGameMode() == GameMode.CREATIVE) return;
        if(!WorldCheck.isEnabled(e.getPlayer().getWorld()))return;

        spawnPlayer(e.getPlayer());
    }

    @EventHandler
    public void onWorldSwitch(PlayerChangedWorldEvent e)
    {
        if(!WorldCheck.isEnabled(e.getPlayer().getWorld()))return;
        if(e.getPlayer().getGameMode() == GameMode.CREATIVE)return;
        spawnPlayer(e.getPlayer());
    }

    private void spawnPlayer(Player p)
    {
        p.getInventory().clear();

        p.getInventory().addItem(watch);

        p.getInventory().setArmorContents(armour);

        p.teleport(p.getWorld().getSpawnLocation());
    }
}
