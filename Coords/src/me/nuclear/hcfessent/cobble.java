package me.nuclear.hcfessent;

import java.lang.reflect.Constructor;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cobble implements CommandExecutor{
	
	Main main = Main.getInstance();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(!(p.hasPermission("core.cobble"))) {
			main.noPermission(p);
		} else {
			if(main.getCobble(p) == true) {
				main.takeCobble(p);
				for(String take : main.config.getStringList("cobble-disabled")) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', take));
				}
			} else {
				main.addCobble(p);
				for(String add : main.config.getStringList("cobble-enabled")) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', add));
				}
			}
		}
		
		return true;
	}

}
