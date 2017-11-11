package com.fcc.asteroids.entity;

import com.jga.util.entity.EntityBase;
import com.jga.util.shape.ShapeUtils;

/**
 * Project name: Asteroids
 * Created by fromCharCode on 11.11.2017.
 */
public class Asteroid extends EntityBase {

    // == constructors ==
    public Asteroid() {
    }

    @Override
    protected float[] createVertices() {
        return ShapeUtils.createIrregularPolygon(width/2f, height/2f, width/2f, 7);
    }
}
