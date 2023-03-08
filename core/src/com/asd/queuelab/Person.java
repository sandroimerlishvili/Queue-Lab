package com.asd.queuelab;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public class Person {

    // position & dimensions

    private Rectangle boundingBox;

    // graphics

    private Texture personTexture;

    public Person(float width, float height, float xCenter, float yCenter, Texture personTexture) {

        this.boundingBox = new Rectangle(xCenter - width / 2, yCenter - height / 2, width, height);
        this.personTexture = personTexture;

    }

    public void draw(Batch batch) {

        batch.draw(personTexture, boundingBox.getX(), boundingBox.getY(), boundingBox.getWidth(), boundingBox.getHeight());

    }


}
