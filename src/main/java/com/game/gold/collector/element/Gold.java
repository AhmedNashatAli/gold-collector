package com.game.gold.collector.element;

import com.game.gold.collector.util.Random;
import java.awt.Point;

public class Gold extends Member {

    public Gold(char shape) {
        setShape(shape);
    }
    /**
     * Add Gold
     * @param screen
     * @param player 
     */
    public void placeGoldRandom(MapScreen screen, Player player) {
        Point p = Random.pointNotEqualsThePassedPoient(screen.getScreenHeight(), screen.getScreenWidth(), player.getPosition());
        this.setPosition(p);
        screen.setMemberOnScreen(this);
    }

}
