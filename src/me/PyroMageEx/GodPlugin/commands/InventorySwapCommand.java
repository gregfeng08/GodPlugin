package me.PyroMageEx.GodPlugin.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.PyroMageEx.GodPlugin.Main;

public class InventorySwapCommand implements CommandExecutor{
	private Main plugin;
	public InventorySwapCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("swapinv").setExecutor(this);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// /swapinv [target1] [target2]
		Player target1 = Bukkit.getPlayer(args[0]);
		Player target2 = Bukkit.getPlayer(args[1]);
		ArrayList<ItemStack> inv1 = new ArrayList<ItemStack>();
		ArrayList<ItemStack> inv2 = new ArrayList<ItemStack>();
		target1.sendMessage("You feel the contents of your inventory change.");
		target2.sendMessage("You feel the contents of your inventory change.");
		for(int i=0;i<=35;i++) {
			inv1.add(target1.getInventory().getItem(i));
			inv2.add(target2.getInventory().getItem(i));
		}
		for(int i=0;i<=35;i++) {
			target1.getInventory().setItem(i, inv1.get(i));
			target2.getInventory().setItem(i, inv2.get(i));
		}
		return true;
	}
}