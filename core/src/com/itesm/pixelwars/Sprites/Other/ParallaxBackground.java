package com.itesm.pixelwars.Sprites.Other;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.itesm.pixelwars.PixelWars;

public class ParallaxBackground extends Actor {

    private int scroll;
    private Array<Texture> layers;
    private final float LAYER_SPEED_DIFFERENCE = 1;

    float x,y,width,heigth,scaleX,scaleY;
    int originX, originY,rotation,srcY;
    float srcX;
    boolean flipX,flipY;

    private float speed;

    public ParallaxBackground(Array<Texture> textures){
        layers = textures;
        for(int i = 0; i <textures.size;i++){
            layers.get(i).setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        }
        scroll = 0;
        speed = 0;

        x = y = originX = originY = rotation = srcY = 0;
        width = PixelWars.ANCHO;
        heigth = PixelWars.ALTO;
        scaleX = scaleY = 1;
        flipX = flipY = false;
    }

    public void setSpeed(float newSpeed){
        this.speed = newSpeed;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a * parentAlpha);

        scroll+=speed;
        for(int i = 0;i<layers.size;i++) {
            srcX = scroll + i*this.LAYER_SPEED_DIFFERENCE *scroll;
            batch.draw(layers.get(i),0,0,originX,originY,layers.get(i).getWidth(),layers.get(i).getHeight(),1,1,0,(int)srcX,0,layers.get(i).getWidth(),layers.get(i).getHeight(),false,false);

        }
    }
}
