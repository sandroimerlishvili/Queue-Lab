package com.asd.queuelab;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/*

This is the "main" class for the whole program, it handles switching between
different visual environments (screens) which each handle a different aspect of the game

*/

public class QueueLab extends Game {

	// screens

	protected MainScreen mainScreen;

	// audio

	protected Music music;
	protected Music peopleTalking;

	// this method loads the assets into memory and creates the initial mainScreen

	public void create() {

		Assets.loadTextures();
		Assets.loadAudio();
		Assets.manager.finishLoading();

		mainScreen = new MainScreen(this);
		setScreen(mainScreen);


	}
	// This method disposes the asset manager as well as calls the super method (in the Game class)

	@Override
	public void dispose() {

		Assets.dispose();
		super.dispose();

	}



}
