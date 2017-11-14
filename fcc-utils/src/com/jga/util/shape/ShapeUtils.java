package com.jga.util.shape;

import com.badlogic.gdx.math.MathUtils;

/**
 * Shape utilities.
 * Useful for bounds.
 *
 * Edited by fromCharCode
 *
 * @author goran on 30/11/2016.
 * @see com.jga.util.entity.EntityBase
 *
 * @author fromCharCode on 11/11/2017
 */
public class ShapeUtils {
    /**
     * Creates array of vertices that represent octagon.
     *
     * @param originX origin x
     * @param originY origin y
     * @param radius  radius
     * @return array of vertices
     */
    public static float[] createOctagon(float originX, float originY, float radius) {
        return createPolygon(originX, originY, radius, 8);
    }

    /**
     * Creates array of vertices that represent octagon with origin(0,0) and radius.
     *
     * @param radius radius
     * @return array of vertices
     */
    public static float[] createOctagon(float radius) {
        return createOctagon(0, 0, radius);
    }

    /**
     * Creates array of vertices that represent polygon.
     *
     * @param originX     origin x
     * @param originY     origin y
     * @param radius      radius
     * @param vertexCount vertex count
     * @return array of vertices.
     */
    public static float[] createPolygon(float originX, float originY, float radius, int vertexCount) {
        float[] ret = new float[vertexCount * 2];

        for (int i = 0, j = 0; i < vertexCount; i++) {
            ret[j++] = originX + radius * MathUtils.cosDeg(360 * i / vertexCount); // x position
            ret[j++] = originY + radius * MathUtils.sinDeg(360 * i / vertexCount); // y position
        }

        return ret;
    }

    /**
     * Creates array of vertices that represents an irregular polygon
     *
     * @param originX     origin x
     * @param originY     origin y
     * @param radius      radius
     * @param vertexCount vertex count
     * @return array of vertices
     */
    public static float[] createIrregularPolygon(float originX, float originY, float radius, int vertexCount){
        float[] ret; // = new float[vertexCount*2];

        ret = createPolygon(originX, originY, radius, vertexCount);

        for(int i=0; i<ret.length;i++){

            boolean change;
            boolean horizontal;
            change = MathUtils.randomBoolean(0.8f);

            if(change){
                horizontal = MathUtils.randomBoolean(0.5f);
                if(horizontal){
                    ret[i] += MathUtils.random(radius/2);
                } else {
                    ret[i] -= MathUtils.random(radius/2);
                }
            }

        }

        return ret;
    }

    @Deprecated
    public static float[] createArrowTop(float x, float y, float width, float height){
        return new float[]{
                x,y,
                x + width/2, y + height/3,
                x + width, y,
                x + width/2, y + height
        };
    }

    /**
     * Creates array of vertices that represent rectangle at position (0,0).
     *
     * @param width  rectangle width
     * @param height rectangle height
     * @return array of vertices
     */
    public static float[] createRectangle(float width, float height) {
        return createRectangle(0, 0, width, height);
    }

    /**
     * Creates array of vertices that represent rectangle with specified position and size.
     *
     * @param x      rectangle x position
     * @param y      rectangle y position
     * @param width  rectangle width
     * @param height rectangle height
     * @return array of vertices
     */
    public static float[] createRectangle(float x, float y, float width, float height) {
        return new float[]{
                x, y,
                x + width, y,
                x + width, y + height,
                x, y + height
        };
    }



    // == constructors ==
    private ShapeUtils() {
    }
}
