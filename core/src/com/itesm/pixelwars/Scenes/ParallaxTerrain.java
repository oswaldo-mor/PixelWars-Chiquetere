package com.itesm.pixelwars.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.itesm.pixelwars.PixelWars;
import com.itesm.pixelwars.Sprites.Other.*;


public class ParallaxTerrain implements Disposable {
    public Stage stage;
    private PixelWars game;
    private Viewport viewport;
    Array<Texture> textures;



    public ParallaxTerrain(PixelWars game){
        this.game = game;

        viewport = new StretchViewport(game.ANCHO,game.ALTO, game.gamecam);
        stage = new Stage(viewport,game.batch);
        textures = new Array<Texture>();
        textures.add(new Texture("bSky1.png"));
        textures.get(textures.size-1).setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        textures.add(new Texture("bbClouds.png"));
        textures.get(textures.size-1).setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        textures.add(new Texture("bbMtns.png"));
        textures.get(textures.size-1).setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        textures.add(new Texture("bbGrass.png"));
        textures.get(textures.size-1).setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);

        ParallaxBackground parallaxBackground = new ParallaxBackground(textures);
        parallaxBackground.setSize(PixelWars.ANCHO,PixelWars.ALTO);
        parallaxBackground.setSpeed(1f);
        stage.addActor(parallaxBackground);



    }

    @Override
    public void dispose() {
        stage.dispose();

    }
}
