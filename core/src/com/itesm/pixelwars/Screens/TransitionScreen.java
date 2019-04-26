package com.itesm.pixelwars.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.itesm.pixelwars.PixelWars;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.delay;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

public class TransitionScreen implements Screen {
    private PixelWars game;
    private Stage stage;
    private Texture backgroundTexture;
    private Texture logoTexture;
    private Viewport gamePort;


    public TransitionScreen(PixelWars game){
        this.game = game;
    }

    @Override
    public void show() {
        gamePort = new StretchViewport(PixelWars.ANCHO,PixelWars.ALTO,game.gamecam);
        stage = new Stage(gamePort,game.batch);
        Gdx.input.setInputProcessor(stage);

        backgroundTexture = new Texture(Gdx.files.internal("tec.png"));
        logoTexture = new Texture(Gdx.files.internal("fobutec.png"));

        Image background = new Image(backgroundTexture);
        Image logo = new Image(logoTexture);

        stage.addActor(background);
        stage.addActor(logo);

        logo.getColor().a = 0f;


        background.addAction(sequence(delay(1),fadeIn(1), fadeOut(2)));
        logo.addAction(sequence(delay(4), fadeIn(2),delay(2), fadeOut(2), run(new Runnable() {
            @Override
            public void run() {
                game.setScreen(new MenuScreen(game));
                dispose();
            }
        })));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(Color.WHITE.r, Color.WHITE.g, Color.WHITE.b, Color.WHITE.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.setProjectionMatrix(stage.getCamera().combined);

        stage.act(delta);
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width,height);
        stage.getViewport().update(width,height,true);

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
        logoTexture.dispose();
        backgroundTexture.dispose();
        stage.dispose();

    }
}
