/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.gold.collector.element;

import com.game.gold.collector.util.Configuration;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Ahmed Nashaat
 */
public class GoldTest {
    Configuration config = new Configuration();

    @Test
    public void testPlaceGoldToScreen() {
        MapScreen mapScreen = new MapScreen(config);
        Player player = new Player('X', mapScreen, config);
        player.move(mapScreen, 1, 1);
        Gold gold=new Gold(config.getGoldChar());
        gold.placeGoldRandom(mapScreen, player);
         Assert.assertEquals(gold.getShape(), mapScreen.getObjectOnLocation(gold.getPosition()));

    }
    @Test
    public void testPlaceGoldRandom() {
        MapScreen mapScreen = new MapScreen(config);
        Player player = new Player('X', mapScreen, config);
        player.move(mapScreen, 1, 1);
        Gold gold=new Gold(config.getGoldChar());
        gold.placeGoldRandom(mapScreen, player);
        Assert.assertNotEquals(player.getPosition().x, gold.getPosition().x);
        Assert.assertNotEquals(player.getPosition().y, gold.getPosition().y);

    }
}
