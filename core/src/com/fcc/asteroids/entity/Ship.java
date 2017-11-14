package com.fcc.asteroids.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.fcc.asteroids.config.GameConfig;
import com.jga.util.entity.EntityBase;
import com.jga.util.entity.ShapeEntityBase;
import com.jga.util.shape.ShapeUtils;

/**
 * Project name: Asteroids
 * Created by fromCharCode on 11.11.2017.
 */
public class Ship extends ShapeEntityBase {

    // == attributes ==
    private float maxSpeed;
    private float acceleration;
    private float deceleration;

    private boolean left;
    private boolean right;
    private boolean up;

    // == constructor ==
    public Ship() {
        x = GameConfig.WORLD_CENTER_X;
        y = GameConfig.WORLD_CENTER_Y;

        maxSpeed = 15;
        acceleration = 3f;
        deceleration = 1f;

        shapeX = new float[4];
        shapeY = new float[4];

        radians = 3.1415f/2f;
        rotationSpeed = 2f;
    }

    public void setShape() {
        // top or peak

        shapeX[0] = x + MathUtils.cos(radians) * GameConfig.SHIP_HEIGHT;
        shapeY[0] = y + MathUtils.sin(radians) * GameConfig.SHIP_HEIGHT;

        shapeX[1] = x + MathUtils.cos(radians - (GameConfig.SHIP_HEIGHT/2f) * 3.1415f / (GameConfig.SHIP_HEIGHT*0.625f)) * GameConfig.SHIP_WIDTH;
        shapeY[1] = y + MathUtils.sin(radians - (GameConfig.SHIP_HEIGHT/2f) * 3.1145f / (GameConfig.SHIP_HEIGHT*0.625f)) * GameConfig.SHIP_WIDTH;

        // middle part
        shapeX[2] = x + MathUtils.cos(radians + 3.1415f) * 0.15f;
        shapeY[2] = y + MathUtils.sin(radians + 3.1415f) * 0.15f;

        shapeX[3] = x + MathUtils.cos(radians + (GameConfig.SHIP_HEIGHT/2f) * 3.1415f / (GameConfig.SHIP_HEIGHT*0.625f)) * GameConfig.SHIP_WIDTH;
        shapeY[3] = y + MathUtils.sin(radians + (GameConfig.SHIP_HEIGHT/2f) * 3.1415f / (GameConfig.SHIP_HEIGHT*0.625f)) * GameConfig.SHIP_WIDTH;
    }

    public void update(float dt) {

        // turning
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            radians += rotationSpeed * dt;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            radians -= rotationSpeed * dt;
        }

        // accelerating
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            dx += MathUtils.cos(radians) * acceleration * dt;
            dy += MathUtils.sin(radians) * acceleration * dt;
        }

        // deceleration
        float vec = (float) Math.sqrt(dx * dx + dy * dy);
        if(vec > 0) {
            dx -= (dx / vec) * deceleration * dt;
            dy -= (dy / vec) * deceleration * dt;
        }
        if(vec > maxSpeed) {
            dx = (dx / vec) * maxSpeed;
            dy = (dy / vec) * maxSpeed;
        }

        // set position
        x += dx * dt;
        y += dy * dt;

        // set shape
        setShape();

        // wrap
        wrap(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT);
    }

    public void draw(ShapeRenderer sr) {

        for(int i = 0, j = shapeX.length - 1;
            i < shapeX.length;
            j = i++) {
            sr.line(shapeX[i], shapeY[i], shapeX[j], shapeY[j]);
        }
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.right = false;
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.left = false;
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }
}
