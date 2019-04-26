package com.itesm.pixelwars.Sprites.Animations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static com.itesm.pixelwars.Sprites.Animations.EstadoGuerrero.CAMINANDO;
import static com.itesm.pixelwars.Sprites.Animations.EstadoGuerrero.MUERTO;
import static com.itesm.pixelwars.Sprites.Animations.EstadoGuerrero.ATACANDO;
import static com.itesm.pixelwars.Sprites.Animations.EstadoGuerrero.QUIETO;


public class AnimacionGuerrero {


    private Sprite sprite;
    private Sprite spriteAtacando;
    private Animation animacionCaminando;
    private Animation animacionParado;
    private Animation animacionAtacando;
    private float timerAnimacion;
    private Texture texturaCaminando;
    private Texture texturaParado;
    private Texture texturaAtacando;

    private EstadoGuerrero estado;
    private TextureRegion[][] texturaGuerreroCaminando;
    private TextureRegion[][] texturaGuerreroParado;
    private TextureRegion[][] texturaGuerreroAtacando;






    private int hp;
    private int ataque;

    public AnimacionGuerrero(float x, float y, Texture guerreroCaminando, Texture guerreroParado, Texture guerreroAtacando, int caminandoWidth, int caminandoHeight,int paradoWidth, int paradoHeight, int atacandoWidth, int atacandoHeight, int hp, int ataque){
        this.texturaCaminando = guerreroCaminando;
        this.texturaAtacando = guerreroAtacando;
        this.texturaParado = guerreroParado;
        this.hp= hp;
        this.ataque = ataque;

        // Crea una region Caminando
        TextureRegion regionCaminando = new TextureRegion(texturaCaminando);
        // Divide la región en frames de 29x44
        texturaGuerreroCaminando = regionCaminando.split(caminandoWidth,caminandoHeight);
        animacionCaminando = new Animation(0.15f,texturaGuerreroCaminando[0][5],texturaGuerreroCaminando[0][4],texturaGuerreroCaminando[0][3],texturaGuerreroCaminando[0][2],texturaGuerreroCaminando[0][1],texturaGuerreroCaminando[0][0]);
        animacionCaminando.setPlayMode(Animation.PlayMode.LOOP);

        // Crea una region Parado
        TextureRegion regionParado = new TextureRegion(texturaParado);
        // Divide la región en frames de 29x44
        texturaGuerreroParado = regionParado.split(paradoWidth,paradoHeight);
        animacionParado = new Animation(0.15f,texturaGuerreroParado[0][3],texturaGuerreroParado[0][2],texturaGuerreroParado[0][1],texturaGuerreroParado[0][0]);
        animacionParado.setPlayMode(Animation.PlayMode.LOOP);

        // Crea una region Atacando
        TextureRegion regionAtacando = new TextureRegion(texturaAtacando);
        // Divide la región en frames de 59x42
        texturaGuerreroAtacando = regionAtacando.split(atacandoWidth,atacandoHeight);
        animacionAtacando = new Animation(0.15f,texturaGuerreroAtacando[0][3],texturaGuerreroAtacando[0][2],texturaGuerreroAtacando[0][1],texturaGuerreroAtacando[0][0]);
        animacionAtacando.setPlayMode(Animation.PlayMode.LOOP);

        // Quieto
        sprite = new Sprite(texturaGuerreroCaminando[0][0]);
        spriteAtacando = new Sprite(texturaGuerreroAtacando[0][0]);

        sprite.setPosition(x,y);
        spriteAtacando.setPosition(x,y);
        timerAnimacion = 0;

        estado = CAMINANDO;

    }

    public void render(SpriteBatch batch){
        timerAnimacion += Gdx.graphics.getDeltaTime();
        switch (estado){
            case QUIETO:
                TextureRegion regionParado = (TextureRegion) animacionParado.getKeyFrame(timerAnimacion);
                batch.draw(regionParado, sprite.getX(), sprite.getY());
                break;
            case CAMINANDO:
                TextureRegion regionCaminando = (TextureRegion) animacionCaminando.getKeyFrame(timerAnimacion);
                batch.draw(regionCaminando, sprite.getX(), sprite.getY());
                break;
            case ATACANDO:
                spriteAtacando.setPosition(sprite.getX(), sprite.getY());
                TextureRegion regionAtacando = (TextureRegion) animacionAtacando.getKeyFrame(timerAnimacion);
                batch.draw(regionAtacando, spriteAtacando.getX(), spriteAtacando.getY());
                break;
            case MUERTO:
                sprite.setColor(1,0,0,1);
                sprite.draw(batch);
        }

    }


    public  EstadoGuerrero getEstado() {
        return estado;
    }

    public void setEstado(EstadoGuerrero estado) {
        this.estado = estado;
    }


    public float getX() {
        return sprite.getX();
    }

    public float getY() {
        return sprite.getY();
    }

    public float getHeight() {
        return sprite.getHeight();
    }

    public float getWidth() {
        return sprite.getWidth();
    }

    public void setX(float x){
        sprite.setX(x);
    }

    public void setY(float y){
        sprite.setY(y);
    }

    public void moverX(float dx){
        sprite.setX(sprite.getX() + dx);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public Sprite getSpriteAtacando(){
        return spriteAtacando;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }






}

