package org.academiadecodigo.fartyunicorn;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Collision {

    private Game game;

    public Collision(Game game) {
        this.game = game;
    }

    public boolean collisionColumns() {

        if (game.getUnicorn().getMaxX() >= game.getColumns().getInf().getX() && game.getUnicorn().getX() <= (game.getColumns().getInf().getX() + game.getColumns().getInf().getWidth())) {
            if (game.getUnicorn().getMaxY() >= game.getColumns().getInf().getY()) {
                return true;
            }
            if (game.getUnicorn().getY() <= game.getColumns().getSup().getHeight()) {
                return true;
            }
        }
        return false;


    }


    public boolean collisionEnemies(Picture unicorn, Enemies enemies) {

        if (unicorn.getMaxX() >= enemies.getImage().getX() && unicorn.getX() <= (enemies.getImage().getX() + enemies.getImage().getWidth())) {
            if (unicorn.getMaxY() >= enemies.getImage().getY() && unicorn.getY() <= enemies.getImage().getMaxY()) {
                return true;
            }
        }


        return false;
    }

    public boolean collisionShot(Picture bullet, Enemies enemies) {
        if (bullet.getMaxX() >= enemies.getImage().getX() && bullet.getX() <= (enemies.getImage().getX() + enemies.getImage().getWidth())) {
            if (bullet.getMaxY() >= enemies.getImage().getY() && bullet.getY() <= enemies.getImage().getMaxY()) {
                return true;
            }
        }
        return false;
    }

}
