package com.itesm.pixelwars.Sprites.Animations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TitleAnimation {
    private Animation animacion;
    private Sprite sprite;
    private float timerAnimacion;

    public TitleAnimation(float x, float y, Texture title){

        TextureRegion region = new TextureRegion(title);
        // Divide la región en frames de 32x64
        TextureRegion[][] titleText = region.split(136,88);
        animacion = new Animation(0.1f,titleText[0][6],titleText[0][5],titleText[0][4],titleText[0][3],titleText[0][2],titleText[0][1],titleText[0][0]);
        animacion.setPlayMode(Animation.PlayMode.LOOP);
        timerAnimacion = 0;
        // Quieto
        sprite = new Sprite(titleText[0][0]);
        sprite.setPosition(x,y);
    }

    public void render(SpriteBatch batch){
        timerAnimacion += Gdx.graphics.getDeltaTime();
        TextureRegion region = (TextureRegion) animacion.getKeyFrame(timerAnimacion);
        batch.draw(region, sprite.getX(), sprite.getY());
    }


    public float getX() {
        return sprite.getX();
    }

    public float getY() {
        return sprite.getY();
    }

    public float getHeight() {
        return sprite.getHeight();
    }

    public float getWidth() {
        return sprite.getWidth();
    }

    public void setX(float x){
        sprite.setX(x);
    }

    public void setY(float y){
        sprite.setY(y);
    }
}
