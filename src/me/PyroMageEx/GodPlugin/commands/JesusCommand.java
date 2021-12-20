package me.PyroMageEx.GodPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.PyroMageEx.GodPlugin.Main;

public class JesusCommand implements CommandExecutor{
	
	private Main plugin;
	public JesusCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("scaffold").setExecutor(this);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = Bukkit.getPlayer(args[0]);
		p.sendMessage("God has touched you for the next 30 seconds.");
		BukkitRunnable runnable = new BukkitRunnable() {
	        @Override
	        public void run() {
	        	createScaffold(plugin, p.getLocation().getBlock());
	        }
	    };
	    runnable.runTaskTimer(plugin, 1, 600);
		return false;
	}
	static void createScaffold(Main plugin, Block b) {
		b.setType(Material.DIRT);
		BukkitRunnable runnable = new BukkitRunnable() {
	        @Override
	        public void run() {
	        	b.setType(Material.AIR);
	        }
	    };
	    runnable.runTaskLater(plugin, 100);
	}

}
