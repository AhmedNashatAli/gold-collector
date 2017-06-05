/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.gold.collector.util;

import java.awt.Point;

/**
 *
 * @author Ahmed Nashaat
 */
public class Random {

    public static Point point(int maxX, int maxY) {
        int x = (int) (Math.random() * (maxX - 2))+1;
        int y = (int) (Math.random() * (maxY - 2))+1;
        return new Point(x, y);
    }

    public static Point pointNotEqualsThePassedPoient(int maxX, int maxY, Point p) {
        Point newPoint = point(maxX, maxY);
        while (p.x == newPoint.x && p.y == newPoint.y) {
            newPoint = point(maxX, maxY);
        }
        return newPoint;
    }
}
