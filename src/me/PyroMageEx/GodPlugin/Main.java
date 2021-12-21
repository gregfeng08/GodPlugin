package me.PyroMageEx.GodPlugin;

import org.bukkit.plugin.java.JavaPlugin;

import me.PyroMageEx.GodPlugin.commands.BubbleCommand;
import me.PyroMageEx.GodPlugin.commands.InventorySwapCommand;
import me.PyroMageEx.GodPlugin.commands.JailCommand;
import me.PyroMageEx.GodPlugin.commands.JesusCommand;
import me.PyroMageEx.GodPlugin.commands.RemoveHeldItem;
import me.PyroMageEx.GodPlugin.commands.TrailCommand;
import me.PyroMageEx.GodPlugin.commands.WeakenCommand;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		new JailCommand(this);
		new JesusCommand(this);
		new BubbleCommand(this);
		new WeakenCommand(this);
		new InventorySwapCommand(this);
		new RemoveHeldItem(this);
		new TrailCommand(this);
	}
	@Override
	public void onDisable() {
		
	}
}
