package com.company;

import java.awt.*;

public class Tree implements Drawable {
    private int x, y;
    private Color color;

    private final int  TREE_HEIGHT = 100,
            CRONE_BIG_HEIGHT = 100, CRONE_BIG_WEIGHT = 150,
            CRONE_SMALL_WEIGHT = 35,
            k = 5;
    public Tree(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode("#514e4a"));
        g.fillPolygon(
                new int[]{x + 2, x + 2, x - 50 , x - 50 },
                new int[]{y - TREE_HEIGHT / 2, y - TREE_HEIGHT / 2 - 5, y - TREE_HEIGHT / 2 - 30, y - TREE_HEIGHT / 2 - 25},
                4);

        g.fillPolygon(
                new int[]{x - k, x - k, x + k, x + k},
                new int[]{y - TREE_HEIGHT, y + 10, y + 10, y - TREE_HEIGHT},
                4);
        g.setColor(color);
        g.fillOval(x - 50 - 15, y - TREE_HEIGHT / 2 - 45, CRONE_SMALL_WEIGHT, CRONE_SMALL_WEIGHT);
        g.fillOval(x - CRONE_BIG_HEIGHT  / 2, y -  TREE_HEIGHT - CRONE_BIG_WEIGHT, CRONE_BIG_HEIGHT, CRONE_BIG_WEIGHT);
    }
}
