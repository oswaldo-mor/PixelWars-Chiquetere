package com.itesm.pixelwars.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.itesm.pixelwars.PixelWars;

public class GameHud implements Disposable {
    //Scene2D.ui Stage and its own Vieport for HUD
    public Stage stage;
    private Viewport viewport;

    private boolean timeUp;
    private float timeCount;
    private static Integer score;
    private Integer worldTimer;

    //Scene2d widgets
    private Label countdownLabel;
    private static Label scoreLabel;
    private Label timeLabel;

    public GameHud(SpriteBatch sb){
        //Define our tracking variables
        worldTimer = 300;
        timeCount = 0;
        score = 0;

        //setup the Hud viewport using a new camera separte from our gamecam
        //define our stage using that viewport and our game spritebatch
        viewport = new FitViewport(PixelWars.ANCHO, PixelWars.ALTO, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        //define a table used to organize our hud´s labels
        Table table = new Table();
        //Top Aling table
        table.top();
        //Make the table fill the entire stage
        table.setFillParent(true);

        //define our labels using the String, and a Label style consisting of a font and color
        countdownLabel = new Label(String.format("%03d",worldTimer),new Label.LabelStyle(new BitmapFont(),Color.WHITE));
        scoreLabel = new Label(String.format("%06d",score),new Label.LabelStyle(new BitmapFont(),Color.WHITE));


        //Add our labels to our table, padding the top and giving them all equal width with expand X
        table.add(countdownLabel).expandX().padTop(10);
        table.add(scoreLabel).expandX().padTop(10);

        //Add table to stage
        stage.addActor(table);
    }


    public void update(float dt){
        timeCount += dt;
        if(timeCount >= 1){
            if(worldTimer >0){
                worldTimer--;
            }
            else{
                timeUp = true;
            }
            countdownLabel.setText(String.format("%03d",worldTimer));
            timeCount =0;
        }
    }

    public static void addScore(int value){
        score += value;
        scoreLabel.setText(String.format("%06d",score));
    }
    @Override
    public void dispose() {
        stage.dispose();

    }
    public boolean isTimeUp(){
        return timeUp;
    }
}
