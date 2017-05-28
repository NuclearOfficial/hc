package me.nuclear.hcfessent;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class coords implements CommandExecutor{
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(!(p instanceof Player)) {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "You must be a player to use this command."));
		} else if(!(p.hasPermission("core.coords"))) {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().config.getString("no-permission")));
		} else {
			for(String coords : Main.getInstance().config.getStringList("coords")) {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', coords));
				
			}
			
		}
		
		return true;
	}

}
