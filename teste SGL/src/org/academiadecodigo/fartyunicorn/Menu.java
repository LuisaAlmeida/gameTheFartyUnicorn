package org.academiadecodigo.fartyunicorn;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements MouseHandler {

    private Game game;
    private Rectangle background;
    private Picture menuBackground;
    private Picture menuUnicorn;
    private Mouse mouse;
    private Mouse move;
    private Picture button1;
    private Picture button2;
    private Picture button3;
    private Picture button4;
    private Text text1;
    private Text text2;
    private Text text3;
    private Text text4;
    private boolean keyState;
    private boolean keyState2;


    public Menu(Game game) {
        this.game = game;
        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);


    }

    public void menu() {
        background = new Rectangle(10, 10, game.getWidth(), game.getHeight());
        background.setColor(Color.CYAN);
        background.fill();
        /*menuBackground = new Picture(0, 0, "resources/titulo.png");
        menuBackground.translate((game.getWidth() / 2) - (menuBackground.getWidth() / 2), 50);
        menuBackground.draw();*/
        menuUnicorn = new Picture(0, 0, "resources/background/mc.png");
        menuUnicorn.translate(180, 60);
        //menuUnicorn.grow(-200, -200);
        menuUnicorn.draw();
        text3 = new Text(80,570,"SPACE: JUMP     RIGHT ARROW: SHOOT (MODE 2 ONLY)");
        text3.setColor(Color.PINK);
        text3.grow(40,10);
        text3.draw();



        button1 = new Picture(600, 300, "resources/Button/button2.png");
        button1.draw();
        text1 = new Text(660,310,"MODE 1");
        text1.setColor(Color.PINK);
        text1.grow(40,10);
        text1.draw();
        button2 = new Picture(600, 300, "resources/Button/button1.png");


        button3 = new Picture(600, 350, "resources/Button/button2.png");
        button3.draw();
        text2 = new Text(660,360,"MODE 2");
        text2.setColor(Color.PINK);
        text2.grow(40,10);
        text2.draw();
        button4 = new Picture(600, 350, "resources/Button/button1.png");
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        // START GAME
        if (button1.getX() < mouseEvent.getX() && mouseEvent.getX() < button1.getMaxX() &&
                button1.getY() < mouseEvent.getY()-25 && mouseEvent.getY()-25 < button1.getMaxY()) {
            button1.delete();
            button2.draw();
            keyState=true;
        }


        if (button3.getX() < mouseEvent.getX() && mouseEvent.getX() < button3.getMaxX() &&
                button3.getY() < mouseEvent.getY()-25 && mouseEvent.getY()-25 < button3.getMaxY()) {
            button3.delete();
            button4.draw();
            keyState2=true;
        }






    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

        if (keyState) {
            button2.delete();
            button1.draw();

            keyState=false;
            game.setStartLevel1(true);
        }

        if (keyState2) {
            button4.delete();
            button3.draw();

            keyState2=false;
            game.setStartLevel2(true);
        }

    }

/*    While (!dead);
    level1==true
    level2*/


}
