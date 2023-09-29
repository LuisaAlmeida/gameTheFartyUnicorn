package org.academiadecodigo.fartyunicorn;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Picture unicorn;
    private Controller controller;
    private Menu menu;
    private Level1 level1;
    private Level2 level2;
    private Collision collision;
    private Movements movements;
    private Columns columns;
    private ObjectFactory objectFactory;
    private Shots shots;
    private Messages messages;
    private int width = 800;
    private int height = 600;
    private int opening = 170;
    private boolean startLevel1;
    private boolean startLevel2;
    private int maxSpeedEnemies = 8; //placeholder value
    private int minSpeedEnemies = 4; //placeholder value
    private int enemyCount = 2; //placeholder value


    public Game() {
        controller = new Controller(this);
        menu = new Menu(this);
        level1 = new Level1(this);
        messages = new Messages();

        collision = new Collision(this);
        columns = new Columns(this);
        movements = new Movements(this);

        objectFactory = new ObjectFactory();
    }


    public void start() throws InterruptedException {


        menu();

    }

    public void menu() throws InterruptedException {
        //level1();
        menu.menu();
        while (true) {
            Thread.sleep(100);


            if (startLevel1) {
                startLevel1 = false;
                level1();

                messages.youLose();
                Thread.sleep(3000);
                messages.loseDelete();
                break;
            }
            if (startLevel2) {
                startLevel2 = false;
                level2 = new Level2(this, maxSpeedEnemies, minSpeedEnemies, enemyCount);
                level2();

                messages.youLose();
                Thread.sleep(3000);
                messages.loseDelete();

                break;
            }

        }
        menu();

    }

    public void difficulty() {
/*
        switch (enum){
            case easy:
                opening=200;
                minSpeedEnemies =
                maxSpeedEnemies =
                break;
            case medium:
                opening=180;
                minSpeedEnemies =
                maxSpeedEnemies =
                break;
            case hard:
                opening=160;
                minSpeedEnemies =
                maxSpeedEnemies =
                break;
        }*/


    }

    public void level1() throws InterruptedException {
        objectFactory.backgroundCreator(width, height);
        this.unicorn = objectFactory.unicornCreator();
        level1.init();


    }

    public void level2() throws InterruptedException {
        objectFactory.backgroundCreator(width, height);
        this.unicorn = objectFactory.unicornCreator();
        shots = new Shots(width, 10, unicorn, this);
        level2.init();

    }

    public void collision() {

    }

    public void moves() {
        movements.moves();

    }

    public int getOpening() {
        return opening;
    }

    public Picture getUnicorn() {
        return unicorn;
    }

    public void jump() {
        movements.setJump();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Columns getColumns() {
        return columns;
    }

    public Collision getCollision() {
        return collision;
    }

    public void setStartLevel1(boolean startLevel1) {
        this.startLevel1 = startLevel1;
    }

    public void setStartLevel2(boolean startLevel2) {
        this.startLevel2 = startLevel2;
    }

    public int getEnemyCount() {
        return enemyCount;
    }

    public Shots getShots() {
        return shots;
    }

    public Level2 getLevel2() {
        return level2;
    }

    public Controller getController() {
        return controller;
    }
}

