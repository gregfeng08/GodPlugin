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

public class JailCommand implements CommandExecutor{
	private Main plugin;
	public JailCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("jail").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		Player j = Bukkit.getPlayer(args[0]);
		Block b;
		if(p.hasPermission("jail.use")) {
			
			Location l = j.getLocation();
			//Bedrock Prison
			b=l.add(0, -1, 0).getBlock();
			b.setType(Material.BEDROCK);
			b=l.add(1, 1, 0).getBlock();
			b.setType(Material.BEDROCK);
			b=l.add(-2, 0, 0).getBlock();
			b.setType(Material.BEDROCK);
			b=l.add(1, 0, 1).getBlock();
			b.setType(Material.BEDROCK);
			b=l.add(0, 0, -2).getBlock();
			b.setType(Material.BEDROCK);
			b=l.add(0, 2, 1).getBlock();
			b.setType(Material.BEDROCK);
			p.sendMessage("You've been jailed for the next 15 seconds.");
			BukkitRunnable runnable = new BukkitRunnable() {
		        @Override
		        public void run() {
		        	Block b;
		        	Location l = j.getLocation();
					b=l.add(1, 0, 0).getBlock();
					b.setType(Material.AIR);
					b=l.add(-2, 0, 0).getBlock();
					b.setType(Material.AIR);
					b=l.add(1, 0, 1).getBlock();
					b.setType(Material.AIR);
					b=l.add(0, 0, -2).getBlock();
					b.setType(Material.AIR);
					b=l.add(0, 2, 1).getBlock();
					b.setType(Material.AIR);
					p.sendMessage("You've been freed!");
		        }
		    };
		    runnable.runTaskLater(plugin, 300);
			return true;
		}
		p.sendMessage("You do not have permission to use this command.");
		return false;
	}

}
