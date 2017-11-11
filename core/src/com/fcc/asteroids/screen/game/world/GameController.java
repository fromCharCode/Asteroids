package com.fcc.asteroids.screen.game.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.fcc.asteroids.entity.Ship;

/**
 * Project name: Asteroids
 * Created by fromCharCode on 11.11.2017.
 */
public class GameController {

    // == attributes ==
    private final GameWorld gameWorld;
    private final GameRenderer renderer;

    // == constructors ==
    public GameController(GameWorld gameWorld, GameRenderer renderer) {
        this.gameWorld = gameWorld;
        this.renderer = renderer;
    }

    // == public methods ==
    public void update(float delta){
        // handle debug input
        handleDebugInput();

        if(gameWorld.isGameOver()){
            return;
        }

        Ship ship = gameWorld.getShip();

        if(gameWorld.isNotActive() && Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            gameWorld.activate();
        }

        gameWorld.update(delta);
    }

    // == private methods ==
    private void handleDebugInput(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.F5)){
            gameWorld.toggleDrawGrid();
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.F6)){
            gameWorld.toggleDebug();
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.F7)){
            gameWorld.toggleDebugInput();
        }
    }
}
