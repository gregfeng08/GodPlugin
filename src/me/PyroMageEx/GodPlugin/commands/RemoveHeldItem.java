package me.PyroMageEx.GodPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.PyroMageEx.GodPlugin.Main;

public class RemoveHeldItem implements CommandExecutor{
	private Main plugin;
	public RemoveHeldItem(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("remheld").setExecutor(this);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player t = Bukkit.getPlayer(args[0]);
		t.sendMessage("Poof");
		t.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
		return true;
	}
}