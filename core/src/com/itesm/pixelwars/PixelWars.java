package com.itesm.pixelwars;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.itesm.pixelwars.Screens.GameScreen;
import com.itesm.pixelwars.Screens.TransitionScreen;

public class PixelWars extends Game {
	public SpriteBatch batch;
	public OrthographicCamera gamecam;


	//Tamaño Pantalla
	public static final int ANCHO = 320;
	public static final int ALTO = 180;


	@Override
	public void create () {
		batch = new SpriteBatch();
		gamecam = new OrthographicCamera(ANCHO,ALTO);
		gamecam.position.set(ANCHO/2,ALTO/2,0);
		setScreen(new TransitionScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	

}
