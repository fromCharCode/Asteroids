package com.fcc.asteroids.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.fcc.asteroids.screen.game.world.GameWorld;

/**
 * Project name: Asteroids
 * Created by fromCharCode on 11.11.2017.
 */
public class PlayerInputController {

    // == attributes ==
    private final GameWorld gameWorld;

    // == constructor ==
    public PlayerInputController(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    // == public methods ==
    public void update(float delta){

        // velocity
        // direction with rotation

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            // add velocity
        } else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            // reduce velocity, clamp to 0
        }

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            // shoot
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            // change rotation to right // tan -? maybe helping circle around the ship
        } else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            // change rotation to left
        }

    }
}
