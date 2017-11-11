package com.fcc.asteroids.screen.game;

import com.badlogic.gdx.assets.AssetManager;
import com.fcc.asteroids.common.EntityFactory;
import com.fcc.asteroids.screen.game.world.GameController;
import com.fcc.asteroids.screen.game.world.GameRenderer;
import com.fcc.asteroids.screen.game.world.GameWorld;
import com.jga.util.game.GameBase;
import com.jga.util.screen.ScreenBaseAdapter;

/**
 * Project name: Asteroids
 * Created by fromCharCode on 11.11.2017.
 */
public class GameScreen extends ScreenBaseAdapter {

    // == attributes ==
    private final GameBase game;
    private final AssetManager assetManager;

    private GameWorld gameWorld;
    private GameController controller;
    private GameRenderer renderer;

    private EntityFactory factory;
//    input controller
//    sound controller

    public GameScreen(GameBase game) {
        this.game = game;
        assetManager = game.getAssetManager();
    }

    @Override
    public void show() {
        factory = new EntityFactory(assetManager);
        gameWorld = new GameWorld(factory); // sound controller, score controller, factory
        renderer = new GameRenderer(gameWorld, game.getBatch(), assetManager, game.getViewportManager()); // gameWorld, batch, assetManager
        controller = new GameController(gameWorld, renderer); // gameWorld, renderer

//        paddle input controller
    }

    @Override
    public void render(float delta) {
        boolean gameOver = gameWorld.isGameOver();

        if(!gameOver){
//            input.update
        }
        controller.update(delta);
        renderer.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        renderer.resize(width, height);
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }
}
