package com.itesm.pixelwars.Scenes;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.itesm.pixelwars.PixelWars;



public class TerrainHud implements Disposable {
    public Stage stage;
    private PixelWars game;
    private Viewport viewport;
    private OrthographicCamera camera;

    private Texture skytext,bgrass,bmountains,bclouds;

    public TerrainHud(PixelWars game, OrthographicCamera camera){
        this.game = game;
        this.camera = camera;
        viewport = new FitViewport(game.ANCHO,game.ALTO, camera);

        stage = new Stage(viewport,game.batch);
        skytext = new Texture("bSky.png");
        bgrass = new Texture("bGrass.ong");
        bmountains = new Texture("bMtns.png");


    }

    @Override
    public void dispose() {

    }
}
