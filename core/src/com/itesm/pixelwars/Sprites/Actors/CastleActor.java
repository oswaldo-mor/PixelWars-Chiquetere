package com.itesm.pixelwars.Sprites.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class CastleActor extends Actor {
    private Texture castillo;
    private int hp;
    private boolean isAlive;

    public CastleActor(Texture castillo){
        setSize(castillo.getWidth(), castillo.getHeight());
        this.castillo = castillo;
        this.hp = 500;
        this.isAlive = true;

    }



    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(castillo, getX(), getY());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isAlive() {
        return isAlive;
    }
}