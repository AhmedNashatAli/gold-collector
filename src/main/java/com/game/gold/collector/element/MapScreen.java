package com.game.gold.collector.element;

import com.game.gold.collector.util.Configuration;
import java.awt.Point;
import java.io.Serializable;

public class MapScreen implements Serializable{

    private int width, height;
    private char shape;
    private char[][] screenMatrix;
    private Configuration config;
    /**
     * 
     * @param config 
     */
    public MapScreen(Configuration config) {
        this.config = config;
        this.width = config.getScreenWidth();
        this.height = config.getScreenHeight();
        this.screenMatrix = new char[this.height][this.width];
    }
    /**
     * 
     * @param shape 
     */
    public void InitScreen(char shape) {
        this.shape = shape;
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.screenMatrix[i][j] = shape;
            }
        }
    }
    /**
     * 
     */
    public void PrintScreen() {
         System.out.print("\r\n");
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print(this.screenMatrix[i][j]);
            }
            System.out.print("\r\n");
        }
    }
    /**
     * 
     * @param x
     * @param y 
     */
    public void ClearScreenLocation(int x, int y) {
        this.screenMatrix[x][y] = shape;
    }

    public int getScreenWidth() {
        return this.width;
    }

    public int getScreenHeight() {
        return this.height;
    }

    
    public char getObjectOnLocation(Point p) {
        return this.screenMatrix[p.x][p.y];
    }
    /**
     * 
     * @param member 
     */
    public void setMemberOnScreen(Member member) {
        this.screenMatrix[member.getPosition().x][member.getPosition().y] = member.getShape();
    }
    
}
