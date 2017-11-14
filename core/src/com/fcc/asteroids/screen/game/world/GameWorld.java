package com.fcc.asteroids.screen.game.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Intersector;
import com.fcc.asteroids.common.EntityFactory;
import com.fcc.asteroids.config.GameConfig;
import com.fcc.asteroids.entity.Asteroid;
import com.fcc.asteroids.entity.Bullet;
import com.fcc.asteroids.entity.Ship;
import com.fcc.asteroids.scripts.AsteroidScript;
import com.jga.util.entity.script.EntityScript;

import java.util.ArrayList;
import java.util.List;

/**
 * Project name: Asteroids
 * Created by fromCharCode on 11.11.2017.
 */
public class GameWorld {

    // == attributes ==
    private final EntityFactory factory;

    private Ship ship;

    private boolean drawGrid = true;
    private boolean drawDebug = true;
    private boolean handleDebug = true;
    private boolean notActive;

    private List<Asteroid> asteroids;
    private List<Bullet> bullets;

    private int lives = GameConfig.LIVES_START;

    public GameWorld(EntityFactory factory) {
        this.factory = factory;
        init();
    }

    // == init ==
    private void init(){
        ship = factory.createShip();

        bullets = new ArrayList<Bullet>();

        asteroids = new ArrayList<Asteroid>();
        for(int i=0; i<5; i++){
            Asteroid asteroid = factory.createAsteroid();
            asteroid.addScript(new AsteroidScript());
            asteroids.add(asteroid);
        }
    }

    // == public methods ==
    public void update(float delta){

        // update ship
        ship.update(delta);

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            Bullet bullet = factory.createBullet(ship.getTopX(), ship.getTopY(), ship.getRadians());
            bullets.add(bullet);
        }

        // update bullets
        for (Bullet bullet : bullets){
            bullet.update(delta);
        }

        // update asteroids
        for (Asteroid asteroid: asteroids) {
            asteroid.update(delta);
        }

        checkCollision();
    }


    public void activate() {
        notActive = false;
    }

    public void toggleDrawGrid(){
        drawGrid = !drawGrid;
    }

    public void toggleDebug(){
        drawDebug = !drawDebug;
    }

    public void toggleDebugInput(){
        handleDebug = !handleDebug;
    }

    // getter setter

    public Ship getShip() {
        return ship;
    }

    public List<Asteroid> getAsteroids() {
        return asteroids;
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public boolean isGameOver(){
        return false;   // // TODO: 11.11.2017 change for game according to lives
    }

    public boolean isNotActive() {
        return notActive;
    }

    public boolean isDrawGrid() {
        return drawGrid;
    }

    public boolean isDrawDebug() {
        return drawDebug;
    }

    public boolean isHandleDebug() {
        return handleDebug;
    }

    public int getLives() {
        return lives;
    }


    // ==  private methods ==
    private void checkCollision(){
        for(Asteroid asteroid : asteroids){
            if (Intersector.overlapConvexPolygons(ship.getPolygon(), asteroid.getBounds())){
                lives--;
                System.out.println("Lives: " + lives);
            }
        }
    }
}
