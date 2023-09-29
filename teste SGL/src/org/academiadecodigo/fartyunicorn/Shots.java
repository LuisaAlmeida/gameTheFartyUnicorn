package org.academiadecodigo.fartyunicorn;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Shots {

    private int backgroundWidth;
    private int initX;
    private int initY;
    private int shotSpeed;
    private Picture bullet;
    private Picture unicorn;
    private boolean strike = false;
    private boolean deleted = false;
    private Game game;

    public Shots(int backgroundWidth, int shotSpeed, Picture unicorn, Game game) {
        this.backgroundWidth = backgroundWidth;
        this.unicorn = unicorn;
        this.initX = unicorn.getMaxX();
        this.initY = (unicorn.getMaxY()-unicorn.getHeight()/2);
        this.shotSpeed = shotSpeed;
        this.game = game;

    }

    public void appear(int refactorX, int refactorY) {
        bullet = new Picture(initX, initY, "resources/bullet.png");
        bullet.draw();
        bullet.grow(refactorX,refactorY);
        bullet.translate(refactorX,refactorY);
    }

    public void moveShot() {
        bullet.translate(shotSpeed,0);
    }

    public void delete() {
        if (strike || bullet.getMaxX() >= backgroundWidth) {
            bullet.delete();
            deleted = true;
        }
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Picture getBullet() {
        return bullet;
    }
}
