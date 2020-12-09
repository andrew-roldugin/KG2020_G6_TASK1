package com.company;

import java.awt.*;

public class Sun implements Drawable{

    private int x, y,
            r, R,
            n;
    private Color color;

    public Sun(int x, int y, int r, int R, int n, Color color) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.R = R;
        this.n = n;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        drawSun(g, x, y, r, R, n, color);
    }
    private void drawSun(Graphics2D g, int x, int y, int r, int R, int n, Color c){
        g.setColor(c);
        g.fillOval(x - r, y - r, 2 * r, 2 * r);
        double da = 2 * Math.PI / n;
        for (int i = 0; i < n; i++) {
            double dx1 = r * Math.cos(da * i);
            double dy1 = r * Math.sin(da * i);
            double dx2 = R * Math.cos(da * i);
            double dy2 = R * Math.sin(da * i);
            g.setStroke(new BasicStroke(3));
            g.drawLine(x + (int) dx1, y + (int) dy1,
                    x + (int) dx2, y + (int) dy2);
        }
    }
}
