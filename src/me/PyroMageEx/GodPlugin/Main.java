package me.PyroMageEx.GodPlugin;

import org.bukkit.plugin.java.JavaPlugin;

import me.PyroMageEx.GodPlugin.commands.BubbleCommand;
import me.PyroMageEx.GodPlugin.commands.JailCommand;
import me.PyroMageEx.GodPlugin.commands.JesusCommand;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		new JailCommand(this);
		new JesusCommand(this);
		new BubbleCommand(this);
	}
	@Override
	public void onDisable() {
		
	}
}
