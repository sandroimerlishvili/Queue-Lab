package com.asd.queuelab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

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

    private Texture barrierTexture;

    private String[] personTextureNames = {"person0", "person1", "person2", "person3", "person4",
                                            "person5", "person6", "person7", "person8", "person9"};

    private Texture ticketBoothTexture;

    // world parameters

    private final int WORLD_WIDTH = 1280;
    private final int WORLD_HEIGHT = 720;

    // lines

    Line l1, l2, l3, l4;
    Line[] lines;

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

        parent.peopleTalking.setVolume(0.8f);
        parent.peopleTalking.setLooping(true);
        parent.peopleTalking.play();

        // textures

        barrierTexture = Assets.manager.get(Assets.barrier, Texture.class);

        ticketBoothTexture = Assets.manager.get(Assets.ticketBooth, Texture.class);

        // lines

        l1 = new Line(WORLD_WIDTH - 150, WORLD_HEIGHT / 4f, 0, WORLD_HEIGHT - (WORLD_HEIGHT / 4) * 1, 5, barrierTexture);
        l2 = new Line(WORLD_WIDTH - 150, WORLD_HEIGHT / 4f, 0, WORLD_HEIGHT - (WORLD_HEIGHT / 4) * 2, 5, barrierTexture);
        l3 = new Line(WORLD_WIDTH - 150, WORLD_HEIGHT / 4f, 0, WORLD_HEIGHT - (WORLD_HEIGHT / 4) * 3, 5, barrierTexture);
        l4 = new Line(WORLD_WIDTH - 150, WORLD_HEIGHT / 4f, 0, WORLD_HEIGHT - (WORLD_HEIGHT / 4) * 4, 5, barrierTexture);

        lines = new Line[4];

        lines[0] = l1;
        lines[1] = l2;
        lines[2] = l3;
        lines[3] = l4;

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

        for (int i = 0; i < lines.length; i++) {

            batch.draw(ticketBoothTexture, lines[i].boundingBox.getWidth(), lines[i].boundingBox.getY(), lines[i].boundingBox.getWidth() / (lines[i].boundingBox.getWidth() / 150), lines[i].boundingBox.getHeight());

        }

        // update lines

        for (Line l : lines) {

            l.update(deltaTime);

        }

        addPeople(deltaTime);

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

    // this method finds the shortest line and randomly adds a person (1 in 120 chance every millisecond)

    public void addPeople(float deltaTime) {

        int random = (int)((Math.random() * 120));

        if (random == 60) {

            Line shortestLine = lines[0];

            for (int i = 0; i < lines.length; i++) {

                if (shortestLine.size() > lines[i].size()) {

                    shortestLine = lines[i];

                }

            }

            random = (int)((Math.random()) * personTextureNames.length);

            shortestLine.addPerson(Assets.manager.get(Assets.personTextures, TextureAtlas.class).findRegion(personTextureNames[random]));

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