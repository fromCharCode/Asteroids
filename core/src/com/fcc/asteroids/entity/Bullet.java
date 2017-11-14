package com.fcc.asteroids.entity;

import com.fcc.asteroids.config.GameConfig;
import com.jga.util.entity.ShapeEntityBase;

/**
 * Project name: Asteroids
 * Created by fromCharCode on 14.11.2017.
 */
public class Bullet extends ShapeEntityBase {

    // == attributes ==
    private float speed;

    public Bullet() {
        speed = GameConfig.BULLET_SPEED;
    }
}
