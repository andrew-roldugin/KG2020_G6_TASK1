package com.company;

import java.awt.*;
import java.util.Arrays;

public class Canvas {

    private Graphics2D graphics2D;

    private Sun sun = new Sun(100, 120, 50, 100, 23, Color.YELLOW);
    private Tree[] trees = {
            new Tree(240, 650, Color.decode("#00af81")),
            new Tree(430, 730, Color.decode("#00af81")),
            new Tree(750, 680, Color.decode("#00af81"))
    };
    private Hill[] hills = {
            new Hill(-200, 650, 700, 400, Color.decode("#008462")),
            new Hill(300, 650, 1500, 500, Color.decode("#0D6E56"))
    };
    private Cloud cloudB = new CloudBig();
    private Cloud cloudS = new CloudSmall();
    private Sky sky = new Sky();
    private House house = new House(1150, 500, 310, 270, "15");
    private Fir fir = new Fir(1000, 750);
    private Tree tree = new Tree(110, 800, Color.decode("#ffc524"));

    public Canvas(Graphics2D gr) {
        this.graphics2D = gr;
    }

    public void paintAll() {
        sky.draw(graphics2D);
        sun.draw(graphics2D);
        Arrays.stream(trees).forEach(x -> x.draw(graphics2D));
        Arrays.stream(hills).forEach(hill -> hill.draw(graphics2D));
        cloudB.draw(graphics2D);
        cloudS.draw(graphics2D);
        house.draw(graphics2D);
        fir.draw(graphics2D);
        tree.draw(graphics2D);
    }
}
