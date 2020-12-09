package com.company;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {

    private Canvas canvas;

    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        canvas = new Canvas(graphics2D);
        canvas.paintAll();
    }
}
