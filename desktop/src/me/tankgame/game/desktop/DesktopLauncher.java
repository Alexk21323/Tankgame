package me.tankgame.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import me.tankgame.game.TankGame;

public class DesktopLauncher 
{
	public static void main (String[] arg) 
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width= 1024;
		config.height = 768;
		config.title = "Tank Game";
		new LwjglApplication(new TankGame(), config);
	}
}
