package com.itesm.pixelwars.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.itesm.pixelwars.PixelWars;



public class LoadingScreen implements Screen {
    private PixelWars game;
    Texture loadingTexture;
    private OrthographicCamera gamecam;
    private Viewport gamePort;

    //Tiempo
    private float timeCounter = 0;

    public LoadingScreen(PixelWars game) {
        this.game = game;
    }

    @Override
    public void show() {
        gamecam = new OrthographicCamera(PixelWars.ANCHO,PixelWars.ALTO);
        gamecam.position.set(PixelWars.ANCHO/2,PixelWars.ALTO/2,0);
        gamePort = new StretchViewport(PixelWars.ANCHO,PixelWars.ALTO,gamecam);

        //Texutre
        loadingTexture = new Texture("loading.png");


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();

        game.batch.draw(loadingTexture,0,0);
        game.batch.end();


        timeCounter+= delta;
        if (timeCounter >= 2){
            game.setScreen(new MenuScreen(game));
        }


    }


    @Override
    public void resize(int width, int height) {
        gamePort.update(width,height);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

        loadingTexture.dispose();
    }
}
