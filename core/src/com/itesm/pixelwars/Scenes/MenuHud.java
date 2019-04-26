package com.itesm.pixelwars.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import com.badlogic.gdx.utils.Disposable;

import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.itesm.pixelwars.PixelWars;
import com.itesm.pixelwars.Screens.AboutScreen;
import com.itesm.pixelwars.Screens.GameScreen;
import com.itesm.pixelwars.Screens.LoadingScreen;
import com.itesm.pixelwars.Screens.MenuScreen;
import com.itesm.pixelwars.Screens.SettingsScreen;
import com.itesm.pixelwars.Sprites.Actors.TitleActor;
import com.itesm.pixelwars.Sprites.Animations.TitleAnimation;

public class MenuHud implements Disposable {
    public Stage stage;
    private PixelWars game;
    private Viewport viewport;


    public MenuHud(final PixelWars game){
        this.game = game;
        viewport = new StretchViewport(game.ANCHO,game.ALTO, game.gamecam);
        stage = new Stage(viewport,game.batch);






        //Buttons & Textures


        //Button 1 Player
        Texture texturetbtnplay = new Texture("btn1P.png");
        Texture texturebtnplayp = new Texture("btn1P_Pressed.png");

        TextureRegionDrawable trdaplay = new TextureRegionDrawable(texturetbtnplay);
        TextureRegionDrawable trdaplayp = new TextureRegionDrawable(texturebtnplayp);

        ImageButton btnPlay = new ImageButton(trdaplay,trdaplayp);
        stage.addActor(btnPlay);
        btnPlay.setPosition(PixelWars.ANCHO/2-btnPlay.getWidth()-9,PixelWars.ANCHO*0.0625F+4-7);


        //Button 2 Players
        Texture texture2players = new Texture("btn2P.png");
        Texture texture2playersp = new Texture("btn2P_Pressed.png");

        TextureRegionDrawable trda2play = new TextureRegionDrawable(texture2players);
        TextureRegionDrawable trda2playp = new TextureRegionDrawable(texture2playersp);

        ImageButton btn2Players = new ImageButton(trda2play,trda2playp);
        stage.addActor(btn2Players);
        btn2Players.setPosition(PixelWars.ANCHO/2-2,PixelWars.ALTO*.125F-7);

        //Button About
        Texture texturebtnabout= new Texture("btnAbout.png");
        Texture texturebtnaboutP = new Texture("btnAbout_Pressed.png");

        TextureRegionDrawable trdabout = new TextureRegionDrawable(texturebtnabout);
        TextureRegionDrawable trdaboutp = new TextureRegionDrawable(texturebtnaboutP);

        ImageButton btnAbout = new ImageButton(trdabout,trdaboutp);

        stage.addActor(btnAbout);
        btnAbout.setPosition(PixelWars.ANCHO-btnAbout.getWidth()-2,PixelWars.ALTO-btnAbout.getHeight()-1);

        //Button Options
        Texture texturebtnsett = new Texture("btnOptions.png");
        Texture texturebtnsettp = new Texture("btnOptions_Pressed.png");

        TextureRegionDrawable trdasett = new TextureRegionDrawable(texturebtnsett);
        TextureRegionDrawable trdasettp = new TextureRegionDrawable(texturebtnsettp);

        ImageButton btnSett = new ImageButton(trdasett,trdasettp);
        stage.addActor(btnSett);
        btnSett.setPosition(PixelWars.ANCHO-btnSett.getWidth()-1,PixelWars.ALTO-btnAbout.getHeight()-btnSett.getHeight());



        //Listeneres

        //List 1 Player
        btnPlay.addListener(new ClickListener() {
                                @Override
                                public void clicked(InputEvent event, float x, float y) {
                                    super.clicked(event, x, y);
                                    //Responder al evento del boton
                                    game.setScreen(new GameScreen(game));

                                }
                            }
        );

        //Options
        btnSett.addListener(new ClickListener() {
                                   @Override
                                   public void clicked(InputEvent event, float x, float y) {
                                       super.clicked(event, x, y);
                                       //Responder al evento del boton
                                       game.setScreen(new SettingsScreen(game));

                                   }
                               }
        );


        //2 Players
        btn2Players.addListener(new ClickListener() {
                                     @Override
                                     public void clicked(InputEvent event, float x, float y) {
                                         super.clicked(event, x, y);
                                         //Responder al evento del boton

                                         game.setScreen(new LoadingScreen(game));

                                     }
                                 }
        );

        //About
        btnAbout.addListener(new ClickListener() {
                                    @Override
                                    public void clicked(InputEvent event, float x, float y) {
                                        super.clicked(event, x, y);
                                        //Responder al evento del boton
                                        game.setScreen(new AboutScreen(game));

                                    }
                                }
        );

        //Layout






        //prueba = new Label("PRUEBA",new Label.LabelStyle(new BitmapFont(), Color.WHITE));

    }

    @Override
    public void dispose() {
        stage.dispose();
        }
    }

