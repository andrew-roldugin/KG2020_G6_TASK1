package com.company;

import java.awt.*;

public class Fir implements Drawable{
    private int x;
    private int y;

    public Fir(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics2D g) {
        drawFir(g);
    }
    private void drawFir(Graphics2D g){
        int startY = y - 200;
        g.fillPolygon(
                new int[] {x + 15,x + 15, x - 15, x - 15},
                new int[] {y + 30, y, y, y + 30},
                4);
        g.setColor(Color.GREEN);
        g.fillPolygon(
                new int[]{x, x + 40, x + 15, x + 80, x + 15, x + 110, x - 110, x - 15, x - 80, x - 15, x - 40},
                new int[]{startY, startY + 60, startY + 60, startY + 120, startY + 120, startY + 200, startY + 200, startY + 120,  startY + 120,  startY + 60, startY + 60 },
                11
        );
    }
}
