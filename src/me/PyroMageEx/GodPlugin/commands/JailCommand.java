package me.PyroMageEx.GodPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

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
		
		if(p.hasPermission("jail.use")) {
			Block b;
			Player j = Bukkit.getPlayer(args[0]);
			Location l = j.getLocation();
			//Bedrock Prison
			b=l.subtract(0, 1, 0).getBlock();
			b.setType(Material.BEDROCK);
			
			b=l.add(1, 0, 0).getBlock();
			b.setType(Material.BEDROCK);
			b=l.subtract(1, 0, 0).getBlock();
			b.setType(Material.BEDROCK);
			b=l.add(0, 0, 1).getBlock();
			b.setType(Material.BEDROCK);
			b=l.subtract(0, 0, 1).getBlock();
			b.setType(Material.BEDROCK);
			b=l.add(0, 3, 0).getBlock();
			b.setType(Material.BEDROCK);
			return true;
		}
		return false;
	}

}
