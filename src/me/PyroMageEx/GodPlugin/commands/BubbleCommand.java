package me.PyroMageEx.GodPlugin.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
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
		boolean toggle;
		if(!(args[1].equals(""))) {
			target = (Player) sender;
		} else {
			target = Bukkit.getPlayer(args[1]);
		}
		
		if(args[0].equals("on")) {
			toggle = true;
			target.sendMessage("The god of fish smiles upon you.");
			runnable = new BukkitRunnable() {
				int countdown = 600;
		        public void run() {
		        	if(countdown==0) {
		        		target.sendMessage("You have lost the ability to part the seas");
		        		cancel();
		        	}
		        	double radius = 3;
		        	Location loc = target.getLocation();
		        	ArrayList<Block> blocks = new ArrayList<Block>();
		        	for(double x=loc.getX()-radius;x<loc.getX()+radius;x++) {
		        		for(double y=loc.getY()-radius;y<loc.getY()+radius;y++) {
		        			for(double z=loc.getZ()-radius;z<loc.getZ()+radius;z++) {
		        				if(loc.getWorld().getBlockAt((int)Math.floor(x),(int)Math.floor(y),(int)Math.floor(z)).getType()==Material.WATER) {
		        					blocks.add(loc.getWorld().getBlockAt((int)Math.floor(x),(int)Math.floor(y),(int)Math.floor(z)));
		        				}
		        			}
		        		}
		        	}
		        	for(int i=0;i<blocks.size();i++) {
		        		bubble(plugin,blocks.get(i));
		        	}
		        	countdown-=1;
		    	}
		    };
		    runnable.runTaskTimer(plugin, 1, 1);
		    
		    return true;
		} else if (args[0].equals("off")){
			toggle = false;
			return true;
		} else {
			sender.sendMessage("Invalid Option, use /bubble [on/off] [player]");
		}
		return false;
	}
	static void bubble(Plugin plugin, Block b) {
		b.setType(Material.AIR);
		/*BukkitRunnable runnable = new BukkitRunnable() {
	        @Override
	        public void run() {
	        	b.setType(Material.WATER);
	        }
	    };
	    runnable.runTaskLater(plugin, 100);*/
	}
}