package com.itesm.pixelwars.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.itesm.pixelwars.PixelWars;
import com.itesm.pixelwars.Screens.MenuScreen;

public class AboutHud implements Disposable {
    public Stage stage;
    private Table table;
    private PixelWars game;
    private Viewport viewport;
    private BitmapFont bitmapFont,sbitmapFont;
    private Label.LabelStyle labelStyle,slabelStyle;
    private Label label1,label2,label3,label4,label5,label6,label7,label8,label9;


    public AboutHud(final PixelWars game){
        this.game = game;
        viewport = new StretchViewport(game.ANCHO,game.ALTO, game.gamecam);
        stage = new Stage(viewport,game.batch);
        table = new Table();

        //Text
        labelStyle = new Label.LabelStyle();
        bitmapFont = new BitmapFont(Gdx.files.internal("pixel.fnt"));
        labelStyle.font = bitmapFont;
        labelStyle.fontColor = Color.WHITE;

        slabelStyle = new Label.LabelStyle();
        sbitmapFont = new BitmapFont(Gdx.files.internal("spixel.fnt"));
        slabelStyle.font = sbitmapFont;
        slabelStyle.fontColor = Color.WHITE;

        float row_height = PixelWars.ALTO/16;
        label1 = new Label("Credits",labelStyle);
        label1.setSize(PixelWars.ANCHO/2-label1.getWidth(),row_height);
        label1.setPosition(PixelWars.ANCHO/2+10,PixelWars.ALTO-row_height*3);
        label1.setAlignment(Align.center);
        stage.addActor(label1);

        label2 = new Label("Sonia Leilani",slabelStyle);
        label2.setSize(PixelWars.ANCHO/2,row_height);
        label2.setPosition(-5,PixelWars.ALTO-row_height*6);
        label2.setAlignment(Align.center);
        stage.addActor(label2);

        label3 = new Label("Raul Fuentes",slabelStyle);
        label3.setSize(PixelWars.ANCHO/2+1+label2.getWidth(),row_height);
        label3.setPosition(5,PixelWars.ALTO-row_height*6);
        label3.setAlignment(Align.center);
        stage.addActor(label3);

        label4 = new Label("Marlon Velasco",slabelStyle);
        label4.setSize(PixelWars.ANCHO/2+1+label3.getWidth()+4,row_height);
        label4.setPosition(15,PixelWars.ALTO-row_height*6);
        label4.setAlignment(Align.center);
        stage.addActor(label4);

        label5 = new Label("Pedro Cortes",slabelStyle);
        label5.setSize(PixelWars.ANCHO/2,row_height);
        label5.setPosition(30,PixelWars.ALTO-row_height*8);
        label5.setAlignment(Align.center);
        stage.addActor(label5);

        label6 = new Label("Oswaldo Morales",slabelStyle);
        label6.setSize(PixelWars.ANCHO/2+label5.getWidth(),row_height);
        label6.setPosition(50,PixelWars.ALTO-row_height*8);
        label6.setAlignment(Align.center);
        stage.addActor(label6);


        label7 = new Label("Art",labelStyle);
        label7.setSize(PixelWars.ANCHO/2-label7.getWidth(),row_height);
        label7.setPosition(PixelWars.ANCHO/2-(label7.getWidth()/2),PixelWars.ALTO-row_height*12);
        label7.setAlignment(Align.center);
        stage.addActor(label7);

        label8 = new Label("Diego Perez",slabelStyle);
        label8.setSize(PixelWars.ANCHO/2+label5.getWidth(),row_height);
        label8.setPosition(0,PixelWars.ALTO-row_height*14);
        label8.setAlignment(Align.center);
        stage.addActor(label8);


        //Buttons & Textures
        //Button 1 Player
        Texture texturetback = new Texture("back.png");
        //Texture texturebtnbackp = new Texture("btn1P_Pressed.png");

        TextureRegionDrawable trdaback = new TextureRegionDrawable(texturetback);
        //TextureRegionDrawable trdaplayp = new TextureRegionDrawable(texturebtnplayp);

        ImageButton btnBack = new ImageButton(trdaback);
        stage.addActor(btnBack);
        btnBack.setPosition(PixelWars.ANCHO-btnBack.getWidth()-1,PixelWars.ALTO-btnBack.getHeight()-1);


        //Listeneres

        //List 1 Player
        btnBack.addListener(new ClickListener() {
                                @Override
                                public void clicked(InputEvent event, float x, float y) {
                                    super.clicked(event, x, y);
                                    //Responder al evento del boton
                                    game.setScreen(new MenuScreen(game));
                                }
                            }
        );



        stage.addActor(table);
        //Layout


        //prueba = new Label("PRUEBA",new Label.LabelStyle(new BitmapFont(), Color.WHITE));

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
