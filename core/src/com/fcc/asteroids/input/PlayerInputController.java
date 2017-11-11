package com.fcc.asteroids.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.fcc.asteroids.screen.game.world.GameWorld;

/**
 * Project name: Asteroids
 * Created by fromCharCode on 11.11.2017.
 */
public class PlayerInputController {

    // == attributes ==
    private final GameWorld gameWorld;

    // == constructor ==
    public PlayerInputController(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    // == public methods ==
    public void update(float delta){

        // velocity
        // direction with rotation

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            // add velocity
        } else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            // reduce velocity, clamp to 0
        }

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            // shoot
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            // change rotation to right // tan -? maybe helping circle around the ship
        } else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            // change rotation to left
        }

    }


    ///// OLD CODE /////
    /**
     *
     public double getRotation(){
     double a = (KeyHandler.getMouseX() - Frame.transx + Frame.cursor.getWidth()/2 - (xpos+size/2));
     double b = (KeyHandler.getMouseY() - Frame.transy + Frame.cursor.getHeight()/2 - (ypos+size/2));
     return Math.atan2(b, a);
     }

     public void draw(Graphics g){
     g.drawImage(rotate(degrees + 90), (int)xpos + Frame.transx, (int)ypos + Frame.transy, null);
     }

     public BufferedImage rotate(double degrees){
     AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(degrees), look.getWidth()/2, look.getHeight()/2);
     BufferedImage rotatedImage = new BufferedImage(look.getWidth(), look.getHeight(), look.getType());
     Graphics2D g = (Graphics2D) rotatedImage.getGraphics();
     g.setTransform(at);
     g.drawImage(look, 0, 0, null);
     return rotatedImage;
     }

     public boolean inMouse(){
     return Collision.circleToCircle(KeyHandler.getMouseX() - Frame.transx, KeyHandler.getMouseY() - Frame.transy, 0, (xpos + size/2), (ypos + size/2), size/2);
     }

     public void update(float tslf, boolean playermovex, boolean playermovey){

     tsls += tslf;
     xspeed = 0;
     yspeed = 0;
     PLAYERSPEED = 200;

     boolean inmouse = inMouse();

     degrees = Math.toDegrees(getRotation());

     if(KeyHandler.isKeyPressed(KeyEvent.VK_SHIFT)) PLAYERSPEED = 350;

     if(KeyHandler.isKeyPressed(KeyEvent.VK_W) && !inmouse){
     xspeed = (float) (Math.cos(getRadianDegrees()) * PLAYERSPEED);
     yspeed = (float) (Math.sin(getRadianDegrees()) * PLAYERSPEED);
     }
     if(KeyHandler.isKeyPressed(KeyEvent.VK_S) && !inmouse){
     xspeed = (float) (Math.cos(getRadianDegrees() + Math.PI) * PLAYERSPEED);
     yspeed = (float) (Math.sin(getRadianDegrees() + Math.PI)* PLAYERSPEED);
     }
     if(KeyHandler.isKeyPressed(KeyEvent.VK_A)){
     xspeed = (float) (Math.cos(getRadianDegrees() - Math.PI/2) * PLAYERSPEED);
     yspeed = (float) (Math.sin(getRadianDegrees() - Math.PI/2)* PLAYERSPEED);
     }
     if(KeyHandler.isKeyPressed(KeyEvent.VK_D)){
     xspeed = (float) (Math.cos(getRadianDegrees() + Math.PI/2) * PLAYERSPEED);
     yspeed = (float) (Math.sin(getRadianDegrees() + Math.PI/2)* PLAYERSPEED);
     }

     oldxpos = xpos;
     oldypos = ypos;

     if(playermovex) xpos+=xspeed*tslf;
     if(playermovey) ypos+=yspeed*tslf;
     if(xpos < 0) xpos = 0;
     if(xpos+size > Game.width) xpos = Game.width-size;
     if(ypos < 0) ypos = 0;
     if(ypos+size > Game.height) ypos = Game.height-size;
     }
     */
}
