package com.fcc.asteroids.common;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.math.MathUtils;
import com.fcc.asteroids.config.GameConfig;
import com.fcc.asteroids.entity.Asteroid;
import com.fcc.asteroids.entity.Ship;

/**
 * Project name: Asteroids
 * Created by fromCharCode on 11.11.2017.
 */
public class EntityFactory {

    // == attributes ==
    private final AssetManager assetManager;

//    particle pools
//    pickup pool

    public EntityFactory(AssetManager assetManager) {
        this.assetManager = assetManager;

        init();
    }

    // == init ==
    private void init(){
//        initialize pools
    }

    // == public methods ==

//    parallax layer

    public Ship createShip(){
        Ship ship = new Ship();
        ship.setSize(GameConfig.SHIP_WIDTH, GameConfig.SHIP_HEIGHT);
        ship.setPosition((GameConfig.WORLD_CENTER_X - GameConfig.SHIP_WIDTH) + GameConfig.SHIP_WIDTH/4f, (GameConfig.WORLD_CENTER_Y - GameConfig.SHIP_HEIGHT) + GameConfig.SHIP_HEIGHT/4f);
        return ship;
    }

    public Asteroid createAsteroid(){
        Asteroid asteroid = new Asteroid();
        asteroid.setPosition((MathUtils.random(0, GameConfig.WORLD_WIDTH - asteroid.getWidth())), ((MathUtils.random(0, GameConfig.WORLD_HEIGHT - asteroid.getHeight()))));
        return asteroid;
    }
}
