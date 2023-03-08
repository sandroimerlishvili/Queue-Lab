package com.asd.queuelab;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Line {

    private Queue<Person> queue = new Queue<Person>();

    // characteristics

    private int maxSize;

    // position & dimensions

    protected Rectangle boundingBox;

    // graphics

    private Texture barrierTexture;

    public Line(float width, float height, float xCenter, float yBottom, int maxSize, Texture barrierTexture) {

        this.maxSize = maxSize;

        this.boundingBox = new Rectangle(xCenter - width / 2, yBottom, width, height);

        this.barrierTexture = barrierTexture;

    }

    public void draw(Batch batch) {

        // WIP

        for (int i = 1; i <= maxSize; i++) {

            batch.draw(barrierTexture, (boundingBox.getWidth() / maxSize) * i - boundingBox.getWidth() / maxSize, boundingBox.getY(), boundingBox.getWidth() / maxSize, boundingBox.getHeight() - 100);

        }

        if (queue.size() > -1) {

            for (int i = 1; i <= queue.size(); i++) {

                // WIP

            }

        }



    }

    public void addPerson(Person person) {

        queue.enqueue(person);

    }

    public void removePerson() {

        queue.dequeue();

    }

}
