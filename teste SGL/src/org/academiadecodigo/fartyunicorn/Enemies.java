package org.academiadecodigo.fartyunicorn;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemies {

    private int moveInX;
    private int moveInY;
    private int initX;
    private int initY;
    private Picture image;
    private int backgroundHeight;
    private int width;
    public final double appearLimit = 0.15;
    private int maxSpeed;
    private int minSpeed;
    private boolean deadEnemy = false;


    public Enemies(int height, int width, int maxSpeed, int minSpeed) {
        this.backgroundHeight = height;
        this.width = width;
        this.maxSpeed = maxSpeed;
        this.minSpeed = minSpeed;
    }

    public void moveEnemy() {
        bounce();
        image.translate(moveInX,moveInY);
    }

    public void appear() {
        randomizeInitPos();
        randomMoveCount();
        double randomNumber = Math.random();
        if (randomNumber < 0.333) {
            this.image = new Picture(initX, initY, "resources/enemies/dance.png");
        } else if (randomNumber >= 0.333 && randomNumber < 0.666) {
            this.image = new Picture(initX, initY, "resources/enemies/homework.png");
        } else {
            this.image = new Picture(initX, initY, "resources/enemies/summarizer.png");
        }
        image.grow(-(image.getWidth()/4),-(image.getHeight()/4));
        image.draw();
    }

    public void die(){
        image.delete();
        new Sound("resources/audio/hit.wav");
    }

    private void randomizeInitPos () {
        this.initX = width - 200 + 200/4 + Columns.padding;
        this.initY = Columns.padding + (int) Math.floor(Math.random() * (backgroundHeight - 144 + 144/4));
    }

    private void randomMoveCount () {

        moveInX = ((int) Math.ceil(Math.random()*(maxSpeed)))*-1;
        if(moveInX > minSpeed*-1){
            moveInX = minSpeed*-1;
        }

        double randomNumber = Math.random();
        if (randomNumber < 0.5) {
            moveInY = ((int) Math.ceil(Math.random()*(maxSpeed)))*-1;
            if(moveInY > minSpeed*-1){
                moveInY = minSpeed*-1;
            }
        } else {
            moveInY = ((int) Math.ceil(Math.random()*(maxSpeed)));
            if(moveInY < minSpeed){
                moveInY = minSpeed;
            }
        }
    }

    private void bounce() {

        if (image.getY() <= 10) {
            moveInY = moveInY*-1;
        }
        if (image.getY() >= backgroundHeight - image.getHeight()) {
            moveInY = moveInY*-1;
        }
    }

    public Picture getImage() {
        return image;
    }

    public boolean isDeadEnemy() {
        return deadEnemy;
    }

    public void setDeadEnemy(boolean deadEnemy) {
        this.deadEnemy = deadEnemy;
    }
}
