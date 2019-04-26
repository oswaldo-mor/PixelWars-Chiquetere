package com.itesm.pixelwars.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.itesm.pixelwars.PixelWars;
import com.itesm.pixelwars.Scenes.AboutHud;
import com.itesm.pixelwars.Scenes.MenuHud;
import com.itesm.pixelwars.Scenes.ParallaxTerrain;
import com.itesm.pixelwars.Sprites.Animations.TitleAnimation;

public class AboutScreen implements Screen {
    private PixelWars game;
    private Viewport gamePort;

    private ParallaxTerrain terrainHud;
    private AboutHud aboutHud;
    private Texture texture;


    public AboutScreen(PixelWars game){
        this.game = game;
        gamePort =  new FitViewport(game.ANCHO,game.ALTO,game.gamecam);
    }

    @Override
    public void show() {

        gamePort = new StretchViewport(PixelWars.ANCHO,PixelWars.ALTO,game.gamecam);



        terrainHud = new ParallaxTerrain(game);
        aboutHud = new AboutHud(game);
        texture = new Texture("title1.png");

        Gdx.input.setInputProcessor(aboutHud.stage);
        Gdx.input.setCatchBackKey(false);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.setProjectionMatrix(aboutHud.stage.getCamera().combined);

        terrainHud.stage.draw();
        aboutHud.stage.draw();



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
        terrainHud.dispose();
        aboutHud.dispose();

    }
}
