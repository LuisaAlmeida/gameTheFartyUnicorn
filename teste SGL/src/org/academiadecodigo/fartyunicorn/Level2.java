package org.academiadecodigo.fartyunicorn;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.ArrayList;

public class Level2 {

    private Game game;
    private boolean dead = false;
    private Enemies[] enemies;
    private int maxSpeed;
    private int minSpeed;
    private int enemyCount;
    private int enemyAmount = 0;
    private ArrayList<Shots> shots = new ArrayList<>();
    private ArrayList<Integer> deletedShots = new ArrayList<Integer>();
    private int score=0;
    private Text highscore;


    public Level2(Game game, int maxSpeed, int minSpeed, int enemyCount)  {
        this.game = game;
        this.maxSpeed = maxSpeed;
        this.minSpeed = minSpeed;
        this.enemyCount = enemyCount;
        fillEnemies();

    }

    public void init() throws InterruptedException {
        score=0;
        highscore=new Text(700,550,"SCORE : " + score);
        highscore.draw();

        //refillEnemies();

        Thread.sleep(2000);

        //Movements movements = new Movements(unicorn);


        while (!dead) {
            //Canvas.getInstance().repaint();
            Thread.sleep(20);
            game.moves();


            if (enemyAmount<enemyCount) {
                for (int i=0; i<enemies.length; i++){
                    enemies[i].appear();
                    enemyAmount++;
                }
            }
            generateShot();

            for (Shots s: shots) {
                s.moveShot();
                s.delete();
            }


            generateNewEnemy();

            for (int i=0; i<enemies.length; i++) {
                enemies[i].moveEnemy();
            }

            for (int i=0; i<enemies.length; i++) {
                dead = game.getCollision().collisionEnemies(game.getUnicorn(), enemies[i]);
                if (dead){
                    //System.out.println("enemy crash");
                    break;
                }
            }

            for (Shots s : shots) {
                for (int i = 0; i<enemies.length; i++) {
                    boolean deadEnemy = game.getCollision().collisionShot(s.getBullet(), enemies[i]);
                    if(deadEnemy) {
                        highscore.delete();
                        score++;
                        highscore=new Text(700,550,"SCORE : " + score);
                        highscore.draw();
                        enemies[i].setDeadEnemy(true);
                        enemies[i].die();
                        generateNewEnemy();
                        break;
                    }
                }
            }

        }
        //System.out.println(dead);
        refillEnemies();
        dead=false;
        //System.out.println(dead);
    }

    private void generateNewEnemy() {
        for (int i = 0; i<enemies.length; i++) {
            if (enemies[i].isDeadEnemy() || enemies[i].getImage().getMaxX() <= 0 || dead) {
                enemies[i].die();
                enemies[i] = new Enemies(game.getHeight(), game.getWidth(), maxSpeed, minSpeed);
                enemies[i].appear();
            }
        }
    }

    private void fillEnemies(){
        enemies = new Enemies[game.getEnemyCount()];
        for (int i=0; i<enemies.length; i++){
            enemies[i] = new Enemies(game.getHeight(), game.getWidth(), maxSpeed, minSpeed);
        }
    }

    private void refillEnemies(){
        for (int i=0; i<enemies.length; i++){
            enemies[i].die();
            enemies[i] = new Enemies(game.getHeight(), game.getWidth(), maxSpeed, minSpeed);
        }
    }



    public void generateShot() {

        if (game.getController().isTest()) {
            shots.add(new Shots(game.getWidth(), 10, game.getUnicorn(), game));
            int index = shots.size()-1 ;
            shots.get(index).appear(-10,-4);
            game.getController().setTest(false);
        }


    }

    public ArrayList<Shots> getShots() {
        return shots;
    }
}
