package com.asd.queuelab;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

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

    public static final String person0 = "textures/person0.png";
    public static final String person1 = "textures/person1.png";
    public static final String person2 = "textures/person2.png";
    public static final String person3 = "textures/person3.png";
    public static final String person4 = "textures/person4.png";

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

        manager.load(person0, Texture.class);
        manager.load(person1, Texture.class);
        manager.load(person2, Texture.class);
        manager.load(person3, Texture.class);
        manager.load(person4, Texture.class);

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

