package com.company;

import java.awt.*;
import java.awt.geom.QuadCurve2D;
import java.util.Arrays;

public class House implements Drawable {
    private int x, y,
            width, height;

    private String text;
    public House(int x, int y, int width, int height, String text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }

    private Brick b = new Brick();
    private final int GAP = 1;

     private Window window = new Window(1320, 550, 100, 100);
     private Door door = new Door( 100, 180, Color.decode("#c69c6a"));
     private Pipe pipe = new Pipe();
     private Roof roof = new Roof(Color.decode("#887d74"));
     private Plate plate = new Plate(Color.decode("#2106bc"));


    @Override
    public void draw(Graphics2D g) {
        drawHouse(g);
    }

    private void drawHouse(Graphics2D g) {

        int a1 = width / b.WIDTH,
                a2 = height / b.HEIGHT,
                w = a1 * (b.WIDTH + GAP),
                h = a2 * (b.HEIGHT + GAP);
        g.fillRect(x, y, w, h);


        for (int i = 0; i < a2; i++) {
            for (int j = 0; ; j++) {
                int w1 = i % 2 == 1 && (j == 0 || j == a1)
                        ? b.WIDTH / 2
                        : b.WIDTH;
                int x1 = x + j * (b.WIDTH + GAP) - (i % 2 == 1 && j > 0 ? b.WIDTH / 2 : 0);
                if (x1 >= x + w)
                    break;
                b.drawBrick(g, x1, y + i * (b.HEIGHT + GAP), Color.decode("#d9b37b"), w1);
            }
        }

        window.draw(g);
        door.draw(g);
        pipe.draw(g);
        roof.setHeight(h);
        roof.setWidth(w);
        roof.draw(g);
        plate.draw(g);

        g.setColor(Color.decode("#916234"));
        g.fillOval(x + 110, y + height - 100, 10, 10);
    }

    private class Brick {
        private final int HEIGHT = 20, WIDTH = 50;

        public void drawBrick(Graphics2D g, int x, int y, Color color, int width) {
            g.setColor(color);
            g.fillRect(x, y, width, HEIGHT);
        }
    }

    private class Roof implements Drawable{

        private int height;
        private int width;
        private Color c;

        public Roof(Color c) {
            this.c = c;
        }

        private final int k = 25;

        private void drawRoof(Graphics2D g, int x, int y, Color color, int w, int h) {

            g.setColor(color);
            g.fillPolygon(
                    new int[]{x - k, x + w / 2, x + w + k},
                    new int[]{y + k, y - h / 2, y + k},
                    3
            );
        }

        @Override
        public void draw(Graphics2D g) {
            drawRoof(g, House.this.x, House.this.y, c, width, height);
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public void setWidth(int width) {
            this.width = width;
        }
    }

    private class Window implements Drawable {
        private int x;
        private int y;
        private int height;
        private int width;

        private final int k = 10;

        public Window(int x, int y, int height, int width) {
            this.x = x;
            this.y = y;
            this.height = height;
            this.width = width;
        }

        @Override
        public void draw(Graphics2D g) {
            drawWindow(g);
        }

        private void drawWindow(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(x, y, width, height);
            g.setColor(Color.decode("#00a1d2"));
            g.fillRect(x + k, y + k, width / 2 - 2 * k, height - 2 * k);
            g.fillRect(x + width / 2, y + k, width / 2 - k, height - 2 * k);
        }
    }

    private class Door implements Drawable {
        private int height;
        private int width;
        private Color c;

        public Door(int width, int height, Color c) {
            this.height = height;
            this.width = width;
            this.c = c;
        }

        @Override
        public void draw(Graphics2D g) {
            drawDoor(g);
        }

        private void drawDoor(Graphics g) {
            g.setColor(c);
            g.fillRect(House.this.x + 30, House.this.y + House.this.height - 180, width, height);
        }
    }
    private class Pipe implements Drawable{

        @Override
        public void draw(Graphics2D g) {
            drawPipe(g, Color.decode("#9c493d"));
        }
        private void drawPipe(Graphics g, Color c) {
            g.setColor(c);
            g.fillPolygon(
                    new int[]{x + 3 * width / 4, x + 3 * width / 4, x + 3 * width / 4 + 30, x + 3 * width / 4 + 30},
                    new int[]{y - height / 8, y - height / 8 - 60, y - height / 8 - 60, y - height / 8},
                    4
            );
        }
    }
    private class Plate implements Drawable{
        private Color color;

        public Plate(Color color ) {
            this.color = color;
        }

        @Override
        public void draw(Graphics2D g) {
            drawPlate(g, color);
        }
        private void drawPlate(Graphics g, Color c) {

            Font font = new Font(Font.SERIF, Font.ITALIC, 20);
            int w = 25 * text.length() / 2, h;
            g.setColor(c);
            g.fillRoundRect(x + 15, y + 30, w, 30, 15, 15);
            g.setColor(Color.white);
            g.setFont(font);
            g.drawString(text, x + 15, y + 52);
        }
    }
}
