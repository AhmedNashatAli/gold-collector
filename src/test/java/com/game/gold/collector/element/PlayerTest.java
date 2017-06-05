/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.gold.collector.element;

import com.game.gold.collector.element.MapScreen;
import com.game.gold.collector.element.Player;
import com.game.gold.collector.util.Configuration;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Ahmed Nashaat
 */
public class PlayerTest {

    Configuration config = new Configuration();

    @Test
    public void testMovePlayer() {
        MapScreen mapScreen = new MapScreen(config);
        Player player = new Player('X', mapScreen, config);
        player.move(mapScreen, 1, 1);
        Assert.assertEquals('X', mapScreen.getObjectOnLocation(player.getPosition()));

    }

    @Test
    public void testMovePlayerLeft() {
        int x = 1, y = 1;
        MapScreen mapScreen = new MapScreen(config);
        Player player = new Player(config.getPlayerChar(), mapScreen, config);
        player.move(mapScreen, x, y);
        player.moveLeft(mapScreen);
        Assert.assertEquals(x, player.getPosition().x);
        Assert.assertEquals(y - 1, player.getPosition().y);

    }

    @Test
    public void testMovePlayerRight() {
        int x = 1, y = 1;
        MapScreen mapScreen = new MapScreen(config);
        Player player = new Player(config.getPlayerChar(), mapScreen, config);
        player.move(mapScreen, x, y);
        player.moveRight(mapScreen);
        Assert.assertEquals(x, player.getPosition().x);
        Assert.assertEquals(y + 1, player.getPosition().y);

    }

    @Test
    public void testMovePlayerUp() {
        int x = 1, y = 1;
        MapScreen mapScreen = new MapScreen(config);
        Player player = new Player(config.getPlayerChar(), mapScreen, config);
        player.move(mapScreen, x, y);
        player.moveUp(mapScreen);
        Assert.assertEquals(x - 1, player.getPosition().x);
        Assert.assertEquals(y, player.getPosition().y);

    }

    @Test
    public void testMovePlayerDown() {
        int x = 1, y = 1;
        MapScreen mapScreen = new MapScreen(config);
        Player player = new Player(config.getPlayerChar(), mapScreen, config);
        player.move(mapScreen, x, y);
        player.moveDown(mapScreen);
        Assert.assertEquals(x + 1, player.getPosition().x);
        Assert.assertEquals(y, player.getPosition().y);

    }
}
