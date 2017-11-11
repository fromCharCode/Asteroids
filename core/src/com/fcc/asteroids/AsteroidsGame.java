package com.fcc.asteroids;

import com.fcc.asteroids.config.GameConfig;
import com.fcc.asteroids.screen.game.GameScreen;
import com.jga.util.ads.AdController;
import com.jga.util.game.GameBase;
import com.jga.util.viewport.ViewportConfig;

public class AsteroidsGame extends GameBase {

	public AsteroidsGame(AdController adController) {
		super(adController, GameConfig.VIEWPORT_CONFIG);
	}

	@Override
	public void postCreate() {
		setScreen(new GameScreen(this));
	}
}
