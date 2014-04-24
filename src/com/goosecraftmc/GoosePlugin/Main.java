package com.goosecraftmc.GoosePlugin;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;


@SuppressWarnings("deprecation")
public class Main extends JavaPlugin implements Listener{
	public static Main plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	Methods m = new Methods();

	@Override
	public void onEnable() {
		PluginDescriptionFile p = this.getDescription();
		this.logger.info(p.getName() + " Version " + p.getVersion() + " Has been enabled!");
		getServer().getPluginManager().registerEvents(this, this);
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
//EVERYTHING BENEATH THIS POINT IS COMMANDS!!! /COMMANDS!
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		
		if(commandLabel.equalsIgnoreCase("motd")){
			//MOTD Command
			player.sendMessage(ChatColor.GOLD + "[GOOSECRAFT MOTD] " + ChatColor.DARK_AQUA + getConfig().getString("MOTD"));
			
		}else if(commandLabel.equalsIgnoreCase("heal") || commandLabel.equalsIgnoreCase("h")){
			//Heal Command
			player.setHealth(20);
			player.sendMessage(ChatColor.GREEN + "Healed!");
			
		}else if(commandLabel.equalsIgnoreCase("feed") || commandLabel.equalsIgnoreCase("f")){
			//Feed Command
			player.setFoodLevel(20);
			player.sendMessage(ChatColor.GREEN + "Fed!");
			
		}else if(commandLabel.equalsIgnoreCase("gamemode") || commandLabel.equalsIgnoreCase("gm")){
			//Gamemode Command
			if(args.length == 0){
				player.sendMessage(ChatColor.RED + "You must input a gamemode, possible gamemode are, survival (0,s), creative (1,c), or adventure (2,a).");
			}else if(args[0].equalsIgnoreCase("0")||args[0].equalsIgnoreCase("survival")||args[0].equalsIgnoreCase("s")){
				player.setGameMode(GameMode.SURVIVAL);
				player.sendMessage(ChatColor.GREEN + "Gamemode set to survival.");
			}else if(args[0].equalsIgnoreCase("1")||args[0].equalsIgnoreCase("creative")||args[0].equalsIgnoreCase("c")){
				player.setGameMode(GameMode.CREATIVE);
				player.sendMessage(ChatColor.GREEN + "Gamemode set to creative.");
			}else if(args[0].equalsIgnoreCase("2")||args[0].equalsIgnoreCase("adventure")||args[0].equalsIgnoreCase("a")){
				player.setGameMode(GameMode.ADVENTURE);
				player.sendMessage(ChatColor.GREEN + "Gamemode set to adventure.");
			}else{
				player.sendMessage(ChatColor.RED + "ERROR: Unknown gamemode or too many arguments, possible gamemodes are, survival (0,s), creative (1,c), or adventure (2,a).");
			}
			
		}else if(commandLabel.equalsIgnoreCase("killall")){
			//Killall Command
			if(args.length == 0){
				player.sendMessage(ChatColor.RED + "Too little arguments! You must specify players, mobs, or all");
			}else if(args[0].equalsIgnoreCase("players")){
				m.killAllPlayers();
				player.sendMessage(ChatColor.GREEN + "All players killed.");
			}else{
				player.sendMessage(ChatColor.RED + "You have done something wrong, you must specify players, mobs, or all");
			}
			
		}else if(commandLabel.equalsIgnoreCase("fly")){
			
			if(player.getAllowFlight() == false){
				player.sendMessage(ChatColor.GREEN + "Flight enabled.");
				player.setAllowFlight(true);
			}else if(player.getAllowFlight() == true){
				player.sendMessage(ChatColor.GREEN + "Flight disabled!");
				player.setAllowFlight(false);
			}
		}
		return false;		
	}
}
