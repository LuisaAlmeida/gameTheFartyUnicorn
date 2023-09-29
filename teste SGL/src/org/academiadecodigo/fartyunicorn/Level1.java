package org.academiadecodigo.fartyunicorn;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Level1 {


    private Game game;
    private boolean dead = false;
    private int opening = 185;
    private int columNum = 2;
    private int score=0;
    private Text highscore;


    public Level1(Game game) {
        //highscore=new Text(700,550,"SCORE : " + score);
        this.game = game;

    }

    public void init() throws InterruptedException {
        score=0;
        highscore=new Text(700,550,"SCORE : " + score);
        highscore.draw();


        Thread.sleep(2000);

        //Movements movements = new Movements(unicorn);
        game.getColumns().newColumns();


        while (!dead) {



            Thread.sleep(20);
            game.moves();

            game.getColumns().getInf().translate(-6, 0);
            game.getColumns().getSup().translate(-6, 0);
            dead = game.getCollision().collisionColumns();

            if (game.getColumns().getInf().getX() <= 0) {
                game.getColumns().collumDelete();
                /*if (setColumNum()){
                    break;
                }*/
                game.getColumns().newColumns();

            }
            if(game.getUnicorn().getMaxX()>=game.getColumns().getInf().getX()+game.getColumns().getInf().getWidth() && !game.getColumns().isSound()){
                new Sound("resources/audio/pass.wav");
                game.getColumns().setSound(true);
                highscore.delete();
                score++;
                highscore= new Text(700,550,"SCORE : " + score);
                highscore.draw();

            }

        }
        dead =false;
    }

    private boolean setColumNum() {
        columNum--;
        if (columNum == 0) {

            //alterar var
            dead = true;
            return true;
        }
        return false;

    }

    public boolean isDead() {
        return dead;
    }

    public int getScore() {
        return score;
    }
}
