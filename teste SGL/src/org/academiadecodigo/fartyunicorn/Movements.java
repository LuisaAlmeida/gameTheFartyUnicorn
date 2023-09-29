package org.academiadecodigo.fartyunicorn;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Movements {

    private Game game;
    private int movUp = 0;
    private boolean jump;
    private boolean boundariesSup;
    private boolean boundariesInf;

    public Movements(Game game) {
        this.game = game;
    }

    public void moves() {
        if (jump) {
            movUp = 20;
            jump = false;
        }
        boundariesSup = game.getUnicorn().getY() >= 10;
        boundariesInf = game.getUnicorn().getMaxY() <= game.getHeight();

        if (movUp > 10 && boundariesSup) {
            movUp--;
            game.getUnicorn().translate(0, -4);
/*
            if (game.getUnicorn().getY() <= 0) {
                game.getUnicorn().translate(0, -4);
            }*/
        } else if (movUp >= 0 && boundariesInf) {
            game.getUnicorn().translate(0, 4);
            movUp--;
        } else if (movUp < 0 && boundariesInf) {
            game.getUnicorn().translate(0, 8);
        }
    }

    public void setJump() {
        jump = true;
    }
}
