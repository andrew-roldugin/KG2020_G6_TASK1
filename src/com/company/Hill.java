package com.company;

import java.awt.*;

public class Hill implements Drawable {

    private int x, y,
            width, height;
    private Color color;

    public Hill(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        drawHills(g, x, y, height, width, color);
    }
    private void drawHills(Graphics2D g, int x, int y, int height, int width, Color color){
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
}
