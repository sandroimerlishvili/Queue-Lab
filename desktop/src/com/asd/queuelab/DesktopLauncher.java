package com.asd.queuelab;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.asd.queuelab.QueueLab;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

		config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());

		config.setForegroundFPS(60);
		config.setTitle("Queue Lab");

		new Lwjgl3Application(new QueueLab(), config);

	}
}
