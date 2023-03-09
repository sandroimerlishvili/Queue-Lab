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
    private Texture personTexture;

    public Line(float width, float height, float xCenter, float yBottom, int maxSize, Texture barrierTexture, Texture personTexture) {

        this.maxSize = maxSize;

        this.boundingBox = new Rectangle(xCenter - width / 2, yBottom, width, height);

        this.barrierTexture = barrierTexture;

        this.personTexture = personTexture;

    }

    public void draw(Batch batch) {

        // WIP

        if (queue.size() > -1) {

            for (int i = 0; i < queue.size(); i++) {

                queue.get(i).draw(batch);

            }

        }

        for (int i = 1; i <= maxSize; i++) {

            batch.draw(barrierTexture, (boundingBox.getWidth() / maxSize) * i - boundingBox.getWidth() / maxSize, boundingBox.getY(), boundingBox.getWidth() / maxSize, boundingBox.getHeight() / (31/11));

        }





    }

    public void addPerson() {

        if (queue.size() + 1 < maxSize) {

            queue.enqueue(new Person(boundingBox.getWidth() / (maxSize * (5/2)), boundingBox.getHeight() - 30, boundingBox.getWidth() - (boundingBox.getWidth() / maxSize) * (queue.size() + 1) + 125, boundingBox.getY() + boundingBox.getHeight() - 100, personTexture));

        }

    }

    public void removePerson() {

        queue.dequeue();

    }

    public void update(float deltaTime) {

        int random = (int)((Math.random() * 500));

        if (random == 250) {

            removePerson();

        }

    }

}
