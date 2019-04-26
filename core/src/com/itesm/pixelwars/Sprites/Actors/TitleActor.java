package com.itesm.pixelwars.Sprites.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class TitleActor extends Actor {
    private Texture title;

    public TitleActor(Texture title){
        setSize(title.getWidth(), title.getHeight());
        this.title = title;

    }



    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(title, getX(), getY());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

}