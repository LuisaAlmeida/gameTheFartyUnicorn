package org.academiadecodigo.fartyunicorn;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Messages{

    private Picture lose;
    private Picture win;
    public Messages(){
        lose = new Picture(180,60, "resources/messages/gameover.png");
        win = new Picture(180,60, "resources/messages/winner.png");
    }
    public void youLose(){
        lose.draw();
        new Sound("resources/audio/lose.wav");
    }
    public void youWin(){
        win.draw();
    }
    public void loseDelete(){
        lose.delete();

    }
}