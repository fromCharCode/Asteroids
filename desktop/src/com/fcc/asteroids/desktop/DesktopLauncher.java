package com.fcc.asteroids.desktop;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.fcc.asteroids.AsteroidsGame;
import com.fcc.asteroids.config.GameConfig;
import com.jga.util.ads.NullAdController;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = GameConfig.WIDTH;
		config.height = GameConfig.HEIGHT;

		new LwjglApplication(new AsteroidsGame(NullAdController.INSTANCE), config);
	}
}
