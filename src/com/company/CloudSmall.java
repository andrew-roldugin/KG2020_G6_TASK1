package com.company;

import java.awt.*;

public class CloudSmall extends Cloud{
    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillOval(867, 25, 150, 150);
        g.fillOval(810, 35, 110, 110);
        g.fillOval(980, 90, 72, 75);
        g.fillOval(830, 95, 90, 85);
    }
}
