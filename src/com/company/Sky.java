package com.company;

import java.awt.*;

public class Sky implements Drawable {
    @Override
    public void draw(Graphics2D g) {
        drawSky(g);
    }

    private void drawSky(Graphics2D g) {
        LinearGradientPaint lp = new LinearGradientPaint(540,
                0,
                540,
                1080,
                new float[]{0.0f, 0.23f, 1.0f},
                new Color[]{Color.decode("#066595"), Color.decode("#62bbd1"), Color.decode("#9ac8c6")}
        );
        g.setPaint(lp);
        g.fillRect(0, 0, 1920, 1080);
    }
}
