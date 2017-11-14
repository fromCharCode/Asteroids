package com.fcc.asteroids.common;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.PolygonShape;
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
//        ship.setSize(GameConfig.SHIP_WIDTH, GameConfig.SHIP_HEIGHT);
//        ship.setPosition((GameConfig.WORLD_CENTER_X - GameConfig.SHIP_WIDTH) + GameConfig.SHIP_WIDTH/4f, (GameConfig.WORLD_CENTER_Y - GameConfig.SHIP_HEIGHT) + GameConfig.SHIP_HEIGHT/4f);
//        ship.setOrigin(ship.getX() + ship.getWidth()/2f, ship.getY() + ship.getHeight()/2f);
        return ship;
    }

    public Asteroid createAsteroid(){
        Asteroid asteroid = new Asteroid();

        boolean before = MathUtils.randomBoolean(0.5f);
        boolean top = MathUtils.randomBoolean(0.5f);

        float hGap = GameConfig.WORLD_CENTER_X - 2;
        float vGap = GameConfig.WORLD_CENTER_Y - 2;

        float startX;
        float startY;

        if (before){
            startX = (MathUtils.random(0, hGap));
            if(top){
                startY = (MathUtils.random(GameConfig.WORLD_CENTER_X + vGap, GameConfig.WORLD_HEIGHT));
            } else {
                startY = (MathUtils.random(0, vGap));
            }
        } else {
            startX = (MathUtils.random(GameConfig.WORLD_CENTER_X + hGap, GameConfig.WORLD_WIDTH));
            if (top){
                startY = (MathUtils.random(GameConfig.WORLD_CENTER_X + vGap, GameConfig.WORLD_HEIGHT));
            } else {
                startY = (MathUtils.random(0, vGap));
            }
        }
        asteroid.setPosition(startX, startY);

        return asteroid;
    }
}
