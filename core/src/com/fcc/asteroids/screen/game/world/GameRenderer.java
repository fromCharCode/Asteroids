package com.fcc.asteroids.screen.game.world;


import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.fcc.asteroids.config.GameConfig;
import com.jga.util.GdxUtils;
import com.jga.util.debug.DebugCameraController;
import com.jga.util.debug.ShapeRendererUtils;
import com.jga.util.viewport.ViewportManager;
import com.jga.util.viewport.ViewportUtils;

/**
 * Project name: Asteroids
 * Created by fromCharCode on 11.11.2017.
 */

public class GameRenderer implements Disposable {

    // == attributes ==
    private final GameWorld gameWorld;
    private final SpriteBatch batch;
    private final AssetManager assetManager;
    private final ViewportManager viewportManager;
    // glyph layout

    private OrthographicCamera camera;
    private Viewport worldViewport;
    private Viewport hudViewport;
    private ShapeRenderer shapeRenderer;
    private DebugCameraController debugCameraController;



    public GameRenderer(GameWorld gameWorld, SpriteBatch batch, AssetManager assetManager, ViewportManager viewportManager) {
        this.gameWorld = gameWorld;
        this.batch = batch;
        this.assetManager = assetManager;
        this.viewportManager = viewportManager;

        init();
    }

    // == init ==
    private void init(){
        camera = viewportManager.getWorldCamera();
        worldViewport = viewportManager.getWorldViewport();
        hudViewport = viewportManager.getHudViewport();
        shapeRenderer = new ShapeRenderer();

        debugCameraController = new DebugCameraController();
        debugCameraController.setStartPosition(GameConfig.WORLD_CENTER_X, GameConfig.WORLD_CENTER_Y);

//        TextureAtlas
//        regions
//        fonts
//        textures
    }

    // == public methods ==
    public void render(float delta){
        // handle debug camera input
        if(gameWorld.isHandleDebug()){
            debugCameraController.handleDebugInput(delta);
        }
        debugCameraController.applyTo(camera);

        // clear screen
        GdxUtils.clearScreen();

//        render background

//        render game play

//        render debug
        renderDebug();
    }

    public void resize(int width, int height){
        viewportManager.resize(width, height);
        viewportManager.debugPixelsPerUnit();
    }


    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }

    // == private methods ==

    private void renderDebug(){

        if(gameWorld.isDrawGrid()){
            ViewportUtils.drawGrid(worldViewport, shapeRenderer);
        }

        if(!gameWorld.isDrawDebug()){
            return;
        }

        Color oldColor = shapeRenderer.getColor().cpy();

        worldViewport.apply();
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        drawDebug();

        shapeRenderer.end();
        shapeRenderer.setColor(oldColor);
    }

    private void drawDebug(){
        shapeRenderer.setColor(Color.GREEN);
        ShapeRendererUtils.entity(shapeRenderer, gameWorld.getShip());

        shapeRenderer.setColor(Color.RED);
        ShapeRendererUtils.entity(shapeRenderer, gameWorld.getAsteroid());
    }
}
