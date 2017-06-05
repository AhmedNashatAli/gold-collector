package com.game.gold.collector.element;

import com.game.gold.collector.util.Configuration;
import com.game.gold.collector.util.Random;

public class Player extends Member {

    private Configuration config;
    /**
     * 
     * @param shape
     * @param screen
     * @param config 
     */
    public Player(char shape, MapScreen screen, Configuration config) {
        setShape(shape);
        placePlayerRandom(screen);
        this.config = config;
    }

    public boolean moveLeft(MapScreen screen) {
        return move(screen, this.getPosition().x, this.getPosition().y - 1);
    }

    public boolean moveRight(MapScreen screen) {
        return move(screen, this.getPosition().x, this.getPosition().y + 1);
    }

    public boolean moveUp(MapScreen screen) {
        return move(screen, this.getPosition().x - 1, this.getPosition().y);
    }

    public boolean moveDown(MapScreen screen) {
        return move(screen, this.getPosition().x + 1, this.getPosition().y);
    }
    /**
     * 
     * @param screen
     * @param x
     * @param y
     * @return 
     */
    public boolean move(MapScreen screen, int x, int y) {
        screen.ClearScreenLocation(this.getPosition().x, this.getPosition().y);
        this.getPosition().x = x;
        this.getPosition().y = y;
        char prevChar = screen.getObjectOnLocation(this.getPosition());
        screen.setMemberOnScreen(this);
        return willContinue(prevChar);
    }
    /**
     * 
     * @param prevChar
     * @return 
     */
    public boolean willContinue(char prevChar) {
        if (prevChar == config.getBorderChar()) {
            System.out.print("\r\n"+config.getLoserMessage()+"\r\n");
            return false;
        } else if (prevChar == config.getGoldChar()) {
            System.out.print("\r\n"+config.getWinnerMessage()+"\r\n");
            return false;
        } else {
            return true;
        }
    }
    /**
     * 
     * @param screen 
     */
    public void placePlayerRandom(MapScreen screen) {
        this.setPosition(Random.point(screen.getScreenHeight(), screen.getScreenWidth()));
        screen.setMemberOnScreen(this);
    }
}
