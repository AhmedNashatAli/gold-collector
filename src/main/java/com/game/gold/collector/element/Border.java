package com.game.gold.collector.element;

import com.game.gold.collector.os.OSCommand;
import com.game.gold.collector.util.Random;
import java.awt.Point;

public class Border extends Member {
    /**
     * Draw border
     * @param shape
     * @param screen
     * @param osCommand
     * @param Obstacles 
     */
    public Border(char shape, MapScreen screen,OSCommand osCommand,int Obstacles) {
        setShape(shape);
        osCommand.writeToScreen("\r\n");
        placeRows(screen, 0);
        placeRows(screen, screen.getScreenHeight() - 1);

        placeColumns(screen, 0);
        placeColumns(screen, screen.getScreenWidth() - 1);
        
        placeRandomObstacles(screen, Obstacles);
    }
    /**
     * Draw Rows
     * @param screen
     * @param rowNumber 
     */
    public void placeRows(MapScreen screen, int rowNumber) {
        Point position = new Point();
        for (int i = 0; i < screen.getScreenWidth(); i++) {
            position.x = rowNumber;
            position.y = i;
            setPosition(position);
            screen.setMemberOnScreen(this);
        }
    }
    /**
     * Draw Columns
     * @param screen
     * @param columnNumber 
     */
    public void placeColumns(MapScreen screen, int columnNumber) {
        Point position = new Point();
        for (int i = 0; i < screen.getScreenHeight(); i++) {
            position.x = i;
            position.y = columnNumber;
            setPosition(position);
            screen.setMemberOnScreen(this);
        }
    }
    /**
     * Add Obstacles
     * @param screen
     * @param count 
     */
    public void placeRandomObstacles(MapScreen screen, int count) {
        Point position = new Point();
        for (int i = 0; i < count; i++) {            
            setPosition(Random.point(screen.getScreenHeight(), screen.getScreenWidth()));
            screen.setMemberOnScreen(this);
        }
    }
}
