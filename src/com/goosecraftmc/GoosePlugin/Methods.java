package com.goosecraftmc.GoosePlugin;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


@SuppressWarnings("deprecation")
public class Methods{

	public void killAllPlayers(){
		List<Player> onlinePlayerList = Arrays.asList(Bukkit.getServer().getOnlinePlayers());
		Iterator<Player> itr = onlinePlayerList.iterator();
		
		while(itr.hasNext()){
			Player player = itr.next();
			player.setHealth(0);
		}
	}
}
