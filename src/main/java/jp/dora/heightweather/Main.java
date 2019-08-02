package jp.dora.heightweather;

import org.bukkit.Location;
import org.bukkit.WeatherType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		Location location = player.getLocation();
		boolean weather = player.getWorld().hasStorm();

		if (location.getY() >= 130) {
			player.setPlayerWeather(WeatherType.CLEAR);
		} else if(weather) {
			player.setPlayerWeather(WeatherType.DOWNFALL);
		} else {
			player.setPlayerWeather(WeatherType.CLEAR);
		}
	}

}
