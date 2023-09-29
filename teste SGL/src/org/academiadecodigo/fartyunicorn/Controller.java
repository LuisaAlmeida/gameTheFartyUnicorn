package org.academiadecodigo.fartyunicorn;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

public class Controller implements KeyboardHandler {

    private Game game;
    private Keyboard keyboard;
    private boolean space;
    private ArrayList<Shots> shots = new ArrayList<Shots>();
    private boolean test = false;
    private Picture fart;
    private boolean oneFart=false;

    public Controller(Game game) {
        this.game = game;

        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);

        KeyboardEvent spaceRelease = new KeyboardEvent();
        spaceRelease.setKey(KeyboardEvent.KEY_SPACE);
        spaceRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(spaceRelease);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE && !oneFart) {
            game.jump();
            new Sound(fartSelector());
            fart = new Picture(game.getUnicorn().getX() - Math.ceil(game.getUnicorn().getWidth() / 2) - 50, game.getUnicorn().getY() + 15, "resources/onlyfart/pum.png");
            fart.grow(-fart.getWidth() / 2.8, -fart.getHeight() / 2.8);
            if (fart.getMaxY() <= game.getHeight()) {
                fart.draw();
                oneFart=true;

            }


        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            test = true;
            new Sound("resources/audio/bang.wav");

        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            fart.delete();
            oneFart=false;
        }

    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    private String fartSelector() {
        int randomNumber = (int) Math.ceil(Math.random() * 5);
        switch (randomNumber) {
            case 1:
                return "resources/audio/fart-1.wav";
            case 2:
                return "resources/audio/fart-2.wav";
            case 3:
                return "resources/audio/fart-4.wav";
            case 4:
                return "resources/audio/fart-7.wav";
            case 5:
                return "resources/audio/fart-8.wav";
        }
        return "";
    }
}
