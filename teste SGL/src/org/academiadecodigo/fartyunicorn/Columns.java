package org.academiadecodigo.fartyunicorn;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Columns {

    private Game game;
    private Rectangle sup;
    private Rectangle inf;
    public static final int padding=10;
    public static final int COL_WIDTH = 50;
    private boolean sound = false;


    public Columns(Game game) {
        this.game = game;
    }

    public void newColumns(){


        int sortedHeight = heightGenerator();
        this.inf = new Rectangle(game.getWidth() - COL_WIDTH, sortedHeight + game.getOpening(), COL_WIDTH, game.getHeight() - sortedHeight - game.getOpening()+padding);
        inf.setColor(new Color((int) Math.floor(Math.random()*256),(int) Math.floor(Math.random()*256),(int) Math.floor(Math.random()*256)));
        inf.fill();

        this.sup = new Rectangle(game.getWidth() - COL_WIDTH, padding, COL_WIDTH, sortedHeight-padding);
        sup.setColor(new Color((int) Math.floor(Math.random()*256),(int) Math.floor(Math.random()*256),(int) Math.floor(Math.random()*256)));
        sup.fill();

        sound = false;
    }

    private int heightGenerator() {

        return (int) (Math.random() * (game.getHeight() - game.getOpening()));
    }

    public void collumDelete() {
        sup.delete();
        inf.delete();
    }


    public Rectangle getInf() {
        return inf;
    }

    public Rectangle getSup() {
        return sup;
    }

    public boolean isSound() {
        return sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }
}
