package com.fcc.asteroids.config;

import com.jga.util.viewport.ViewportConfig;
import com.jga.util.viewport.ViewportConfigBuilder;

/**
 * Project name: Asteroids
 * Created by fromCharCode on 11.11.2017.
 */
public class GameConfig {

    // NOTE: desktop only
    public static final int WIDTH = 1280; //px
    public static final int HEIGHT = 768;

    public static final float WORLD_WIDTH = 20f; // wu
    public static final float WORLD_HEIGHT = 12f;

    public static final float HUD_WIDTH = 1280f; // wu 1:1 ppu
    public static final float HUD_HEIGHT = 768f;

    public static final float WORLD_CENTER_X = WORLD_WIDTH / 2f;
    public static final float WORLD_CENTER_Y = WORLD_HEIGHT / 2f;

    public static final float SHIP_WIDTH = 0.405f;
    public static final float SHIP_HEIGHT = 0.81f;

//    public static final float UNIT_SCALE = 1f / 64f; // for constructor of tiledMap

    public static final float MOVE_VELOCITY = 2.5f;
//
    public static final int LIVES_START = 3;
    public static final int HIT_SCORE = 50;
//
//    public static final float LIFE_WIDTH = 40f;
//    public static final float LIFE_HEIGHT = 40f;
//    public static final float LIFE_SPACING = 10f;

    public static ViewportConfig VIEWPORT_CONFIG = new ViewportConfigBuilder()
            .worldSize(WORLD_WIDTH, WORLD_HEIGHT)
            .hudSize(HUD_WIDTH, HUD_HEIGHT)
            .build();

    // == constructors ==
    private GameConfig(){}

}
