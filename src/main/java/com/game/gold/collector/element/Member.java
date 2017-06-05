package com.game.gold.collector.element;

import java.awt.Point;
import java.io.Serializable;

public class Member implements Serializable{

    private Point position;
    private char shape;

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public char getShape() {
        return shape;
    }

    public void setShape(char shape) {
        this.shape = shape;
    }

}
