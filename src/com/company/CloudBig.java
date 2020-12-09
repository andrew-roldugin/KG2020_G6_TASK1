package com.company;

import java.awt.*;

public class CloudBig extends Cloud{
    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillOval(273, 150, 130, 100);
        g.fillOval(320, 60, 250, 225);
        g.fillOval(530, 140, 120, 120);
        g.fillOval(480, 105, 120, 170);
    }
}
