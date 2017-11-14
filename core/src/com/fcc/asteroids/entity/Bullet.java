package com.fcc.asteroids.entity;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.fcc.asteroids.config.GameConfig;
import com.jga.util.entity.ShapeEntityBase;
import com.jga.util.shape.ShapeUtils;

/**
 * Project name: Asteroids
 * Created by fromCharCode on 14.11.2017.
 */
public class Bullet extends ShapeEntityBase {

    // == attributes ==
    private float acceleration;
    private Polygon bounds;

    public Bullet(float x, float y, float radians) {
        acceleration = GameConfig.BULLET_SPEED;

        this.radians = radians;
        this.x = x;
        this.y = y;
    }

    public void update(float delta){
        dx = MathUtils.cos(radians) * acceleration * delta;
        dy = MathUtils.sin(radians) * acceleration * delta;


        x += dx * delta;
        y += dy * delta;
    }

    public Polygon getBounds() {
        return bounds;
    }

    public void draw(ShapeRenderer sr) {

        sr.circle(x, y, 0.2f, 10);
    }
}
