package me.PyroMageEx.GodPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Ravager;
import org.bukkit.entity.Zombie;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import me.PyroMageEx.GodPlugin.Main;

public class TrailCommand implements CommandExecutor{
	
	private Main plugin;
	public TrailCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("trail").setExecutor(this);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// /trail [ravager/tnt/bzombie] [player]
		Player t = Bukkit.getPlayer(args[1]);
		String trail = args[0];
		t.sendMessage("You are now being followed by "+trail+" for the next 30 seconds.");
		BukkitRunnable runnable = new BukkitRunnable() {
	        int countdown = 600;
	        public void run() {
	        	if(countdown==0) {
	        		t.sendMessage("You don't sense anything following you anymore.");
	        		cancel();
	        	}
	        	Location l = t.getLocation();
	        	countdown-=40;
	        	switch(trail) {
	        	case "ravager":
	        		Ravager r = (Ravager) t.getWorld().spawnEntity(l, EntityType.RAVAGER);
	        		r.setVelocity(new Vector(10,10,10));
	        		break;
	        	case "bzombie":
	        		Zombie z = (Zombie) t.getWorld().spawnEntity(l, EntityType.ZOMBIE);
	        		z.setBaby();
	        		break;
	        	case "tnt":
	        		t.getWorld().spawnEntity(l, EntityType.PRIMED_TNT);
	        		break;
	        	}
	        }
	    };
	    runnable.runTaskTimer(plugin, 0, 40);
		return true;
	}
}