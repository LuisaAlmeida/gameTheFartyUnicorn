package org.academiadecodigo.fartyunicorn;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ObjectFactory {

    private int unicornXpos = 200;
    private int unicornYpos = 50;
    private Picture unicorn;
    private Picture menuBackground;
    private Picture menuUnicorn;

    public void backgroundCreator(int width, int height) {
        Rectangle background = new Rectangle(10, 10, width, height);
        background.setColor(Color.CYAN);
        background.fill();
        Picture background2 = new Picture(10, 10, "resources/backg.png");
        background2.draw();
    }

    public Picture unicornCreator() {
        unicorn = new Picture(unicornXpos, unicornYpos, "resources/unicorn/uni.png");
        unicorn.grow(-(unicorn.getWidth() / 4), -(unicorn.getHeight() / 4));
        unicorn.draw();
        return unicorn;
    }

    public void backgroundMenu(int width, int height) {

    }


    public Picture getUnicorn() {
        return unicorn;
    }
}
