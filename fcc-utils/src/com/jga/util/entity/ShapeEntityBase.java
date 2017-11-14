package com.jga.util.entity;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;

/**
 * Project name: Asteroids
 * Created by fromCharCode on 14.11.2017.
 */
public abstract class ShapeEntityBase {

    // == attributes ==

    protected float x;
    protected float y;

    protected float dx;
    protected float dy;

    protected float radians;
    protected float speed;
    protected float rotationSpeed;

    protected float width;
    protected float height;

    protected float shapeX[];
    protected float shapeY[];

    protected void wrap(float maxWidth, float maxHeight) {
        if(x < 0) x = maxWidth;
        if(x > maxWidth) x = 0;
        if(y < 0) y = maxHeight;
        if(y > maxHeight) y = 0;
    }

    public Polygon getPolygon(){

        float[] verts = new float[shapeX.length*2];

        for (int i=0; i<shapeX.length; i++){
            verts[i*2] = shapeX[i];
            verts[i*2 + 1] = shapeY[i];
        }

        return new Polygon(verts);

    }
}
