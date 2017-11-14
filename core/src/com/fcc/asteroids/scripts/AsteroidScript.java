package com.fcc.asteroids.scripts;

import com.badlogic.gdx.math.MathUtils;
import com.fcc.asteroids.config.GameConfig;
import com.fcc.asteroids.entity.Asteroid;
import com.jga.util.entity.script.EntityScriptBase;

/**
 * Project name: Asteroids
 * Created by fromCharCode on 14.11.2017.
 */
public class AsteroidScript extends EntityScriptBase<Asteroid> {

    @Override
    public void added(Asteroid entity) {
        super.added(entity);
        entity.setVelocity(MathUtils.random(0, 360), 2.3f);
    }

    @Override
    public void update(float delta) {
        if (entity.getX() >= GameConfig.WORLD_WIDTH){
            entity.setX(0);
        } else if (entity.getX() <= 0){
            entity.setX(GameConfig.WORLD_WIDTH);
        }

        if(entity.getY()>= GameConfig.WORLD_HEIGHT){
            entity.setY(0);
        } else if (entity.getY() <= 0){
            entity.setY(GameConfig.WORLD_HEIGHT);
        }
    }
}
