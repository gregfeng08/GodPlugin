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
		
		p.sendMessage("You gain the ability to fly (somewhat).");
		BukkitRunnable runnable = new BukkitRunnable() {
	        int countdown = 200;
	        public void run() {
	        	if(countdown==0) {
	        		p.sendMessage("Your strength begins to falter.");
	        		cancel();
	        	}
	        	createScaffold(plugin, p.getLocation().subtract(0,1,0).getBlock());
	        	countdown-=1;
	        }
	    };
	    runnable.runTaskTimer(plugin, 1, 1);
		return true;
	}
	static void createScaffold(Main plugin, Block b) {
		b.setType(Material.BARRIER);
		BukkitRunnable runnable = new BukkitRunnable() {
	        @Override
	        public void run() {
	        	b.setType(Material.AIR);
	        }
	    };
	    runnable.runTaskLater(plugin, 100);
	}

}
