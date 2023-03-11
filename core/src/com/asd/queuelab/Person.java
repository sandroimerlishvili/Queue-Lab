package com.asd.queuelab;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Person {

    // graphics

    private TextureRegion personTextureRegion;

    public Person(TextureRegion personTextureRegion) {

        this.personTextureRegion = personTextureRegion;

    }

    public void draw(Batch batch, float width, float height, float xCenter, float yCenter) {

        batch.draw(personTextureRegion, xCenter - width / 2, yCenter - height / 2, width, height);

    }


}
