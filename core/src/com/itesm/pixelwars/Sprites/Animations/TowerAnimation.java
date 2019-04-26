package com.itesm.pixelwars.Sprites.Animations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TowerAnimation {

    private Animation animacion;
    private Sprite sprite;
    private float timerAnimacion;

    public TowerAnimation(float x, float y, Texture torre){
        // Cargar textura
        //Texture textura = new Texture("torreAzul");  // 400x66 = tamaño de la imagen

        // Crea una region
        TextureRegion region = new TextureRegion(torre);
        // Divide la región en frames de 32x64
        TextureRegion[][] texturaTorre = region.split(69,124);
        animacion = new Animation(0.15f,texturaTorre[0][5],texturaTorre[0][4],texturaTorre[0][3],texturaTorre[0][2],texturaTorre[0][1],texturaTorre[0][0]);
        animacion.setPlayMode(Animation.PlayMode.LOOP);
        timerAnimacion = 0;
        // Quieto
        sprite = new Sprite(texturaTorre[0][0]);
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

    public Sprite getSprite() {
        return sprite;
    }
}

