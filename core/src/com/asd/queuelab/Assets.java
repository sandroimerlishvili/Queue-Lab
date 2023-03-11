package com.asd.queuelab;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/*

This class handles all external files that are in projectName/assets

It is beneficial to use a separate class and AssetManager in order to avoid
having to access each file everytime it is initialized into a variable
in the other classes of the game (saves lots of memory)

 */

public class Assets {

    // All of these strings are name identifiers for the files that are to be loaded

    public static AssetManager manager = new AssetManager();

    // textures

    public static final String background = "textures/floor.jpg";
    public static final String barrier = "textures/barrier.png";

    public static final String personTextures = "textures/personTextures.atlas";

    public static final String ticketBooth = "textures/ticketBooth.png";

    // music

    public static final String music = "audio/music.mp3";

    // sounds

    public static final String peopleTalking = "audio/peopleTalking.mp3";

    // this method loads all the textures (pictures) into memory

    public static void loadTextures() {

        // textures

        manager.load(background, Texture.class);
        manager.load(barrier, Texture.class);

        manager.load(personTextures, TextureAtlas.class);

        manager.load(ticketBooth, Texture.class);

    }

    // this method loads all the audio into memory

    public static void loadAudio() {

        manager.load(music, Music.class);
        manager.load(peopleTalking, Music.class);

    }

    // this method destroys the asset manager when needed

    public static void dispose() {

        manager.dispose();

    }

}

