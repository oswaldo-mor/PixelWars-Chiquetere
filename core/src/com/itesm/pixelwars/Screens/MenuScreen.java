package com.itesm.pixelwars.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.itesm.pixelwars.PixelWars;
import com.itesm.pixelwars.Scenes.MenuHud;
import com.itesm.pixelwars.Scenes.ParallaxTerrain;
import com.itesm.pixelwars.Sprites.Actors.CastleActor;
import com.itesm.pixelwars.Sprites.Actors.TitleActor;
import com.itesm.pixelwars.Sprites.Animations.TitleAnimation;
import com.itesm.pixelwars.Sprites.Animations.TowerAnimation;

public class MenuScreen implements Screen {
    private PixelWars game;
    private MenuHud menuHud;
    private Viewport gamePort;
    private ParallaxTerrain terrainHud;

    private Stage stage;
    private Texture titleText;
    private TitleActor titleActor;
    private TitleAnimation titleAnimation;



    public MenuScreen(PixelWars game){
        this.game = game;
        gamePort = new StretchViewport(PixelWars.ANCHO,PixelWars.ALTO,game.gamecam);
    }





    @Override
    public void show() {
        terrainHud = new ParallaxTerrain(game);
        menuHud = new MenuHud(game);
        stage = new Stage(gamePort,game.batch);

        createTitle(PixelWars.ANCHO/2-136/2,PixelWars.ALTO/2-20);
        Gdx.input.setInputProcessor(menuHud.stage);
        Gdx.input.setCatchBackKey(false);

    }

    private void createTitle(float x, float y) {
        titleText = new Texture("title3.png");
        titleActor = new TitleActor(titleText);
        stage.addActor(titleActor);
        titleActor.setPosition(x, y);
        Texture titleTextureAnimation = new Texture("title2.png");
        titleAnimation = new TitleAnimation(x, y, titleTextureAnimation);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.setProjectionMatrix(menuHud.stage.getCamera().combined);

        terrainHud.stage.draw();
        menuHud.stage.draw();


        game.batch.begin();
        titleAnimation.render(game.batch);
        game.batch.end();
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
        menuHud.dispose();


    }
}
