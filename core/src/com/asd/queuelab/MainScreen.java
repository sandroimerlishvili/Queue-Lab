package com.asd.queuelab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.asd.queuelab.Queue;

/*

This class is the entry screen of the program, displaying instructions for the user
to type in the zipcode they want to convert and handling the input once it has been received

*/

public class MainScreen extends ScreenAdapter {

    private QueueLab parent;

    // screen

    private Camera camera;
    private Viewport viewport;

    // graphics

    private SpriteBatch batch;

    private Texture background;

    // world parameters

    private final int WORLD_WIDTH = 1280;
    private final int WORLD_HEIGHT = 720;

    // lines

    Line l1, l2, l3, l4;

    public MainScreen(QueueLab parentClass) {

        // GameClass Setup

        parent = parentClass;

        // initialize backgrounds

        background = Assets.manager.get(Assets.background);

        // audio

        parent.music = Assets.manager.get(Assets.music, Music.class);

        parent.music.setVolume(1f);
        parent.music.setLooping(true);
        parent.music.play();

        parent.peopleTalking = Assets.manager.get(Assets.peopleTalking, Music.class);

        parent.peopleTalking.setVolume(0.7f);
        parent.peopleTalking.setLooping(true);
        parent.peopleTalking.play();

        // lines

        l1 = new Line(WORLD_WIDTH, WORLD_HEIGHT / 4, 0, WORLD_HEIGHT - (WORLD_HEIGHT / 4) * 1, 5, Assets.manager.get(Assets.barrier, Texture.class));
        l2 = new Line(WORLD_WIDTH, WORLD_HEIGHT / 4, 0, WORLD_HEIGHT - (WORLD_HEIGHT / 4) * 2, 5, Assets.manager.get(Assets.barrier, Texture.class));
        l3 = new Line(WORLD_WIDTH, WORLD_HEIGHT / 4, 0, WORLD_HEIGHT - (WORLD_HEIGHT / 4) * 3, 5, Assets.manager.get(Assets.barrier, Texture.class));
        l4 = new Line(WORLD_WIDTH, WORLD_HEIGHT / 4, 0, WORLD_HEIGHT - (WORLD_HEIGHT / 4) * 4, 5, Assets.manager.get(Assets.barrier, Texture.class));

        batch = new SpriteBatch();

    }

    // this method renders the elements that are on screen (it is called continuously with increasing deltaTime)

    @Override
    public void render(float deltaTime) {

        batch.begin();

        batch.draw(background, 0, 0, WORLD_WIDTH, WORLD_HEIGHT);

        l1.draw(batch);
        l2.draw(batch);
        l3.draw(batch);
        l4.draw(batch);

        detectInput(deltaTime);

        batch.end();

    }


    // this method detects input from the user (used for escape key)

    private void detectInput(float deltaTime) {

        // escape

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {

            super.dispose();
            System.exit(0);

        }

    }

    // this method initializes the screen variables needed and shows the initial elements of the screen before render starts to be called

    @Override
    public void show() {

        camera = new OrthographicCamera();
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

    }

    @Override
    public void resize(int width, int height) {

        viewport.update(width, height, true);
        batch.setProjectionMatrix(camera.combined);

    }

    // this method disposes various instance variables that are not needed when switching to a different screen

    @Override
    public void dispose() {

        batch.dispose();

    }

}