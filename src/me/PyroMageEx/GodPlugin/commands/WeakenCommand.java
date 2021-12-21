package me.PyroMageEx.GodPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.PyroMageEx.GodPlugin.Main;

public class WeakenCommand implements CommandExecutor{
	private Main plugin;
	public WeakenCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("splash").setExecutor(this);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player target = Bukkit.getPlayer(args[0]);
		int random = (int) (Math.random()*2+1);
		switch(random) {
			case 1:
				badSplash(target);
				break;
			case 2:
				goodSplash(target);
				break;
		}
		
		return true;
	}
	static void goodSplash(Player target) {
		target.sendMessage("You feel invigorated, like you just had a good nap.");
		target.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200, 2));
		target.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 1200, 5));
		target.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, 2));
		target.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 2));
		target.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 1200, 2));
	}
	static void badSplash(Player target) {
		target.sendMessage("You stumble, knees weak, palms sweaty.");
		target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1200, 2));
		target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1200, 1));
		target.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 1200, 1));
		target.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 1200, 1));
		target.addPotionEffect(new PotionEffect(PotionEffectType.UNLUCK, 1200, 3));
	}

}
