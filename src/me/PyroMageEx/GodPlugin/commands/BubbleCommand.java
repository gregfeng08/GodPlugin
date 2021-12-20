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

public class BubbleCommand implements CommandExecutor{
	private Main plugin;
	public BubbleCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("bubble").setExecutor(this);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player target;
		BukkitRunnable runnable = null;
		
		if(!(args[1].equals(""))) {
			target = (Player) sender;
		} else {
			target = Bukkit.getPlayer(args[1]);
		}
		
		if(args[0].equals("on")) {
			runnable = new BukkitRunnable() {
		        public void run() {
		        	Block b = target.getLocation().subtract(0,1,0).getBlock();
		        	Material old = b.getType();
		        	b.setType(Material.SPONGE);
		        	BukkitRunnable runnable = new BukkitRunnable() {
		    	        @Override
		    	        public void run() {
		    	        	b.setType(old);
		    	        }
		    	    };
		    	    runnable.runTaskLater(plugin, 1);
		        }
		    };
		    runnable.runTaskTimer(plugin, 1, 1);
		} else if (args[0].equals("off")){
			runnable.cancel();
		} else {
			sender.sendMessage("Invalid Option, use /bubble [on/off] [player]");
		}
		
		
		
		
		
		return false;
	}
}