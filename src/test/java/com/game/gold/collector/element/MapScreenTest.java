/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.gold.collector.element;

import com.game.gold.collector.util.Configuration;
import java.awt.Point;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Ahmed Nashaat
 */
public class MapScreenTest {
     Configuration config = new Configuration();

    @Test
    public void testScreenWidth() {
        MapScreen mapScreen = new MapScreen(config);
        Assert.assertEquals(mapScreen.getScreenWidth(), config.getScreenWidth());
    }
    @Test
    public void testScreenHeight() {
        MapScreen mapScreen = new MapScreen(config);
        Assert.assertEquals(mapScreen.getScreenHeight(), config.getScreenHeight());
    }
    
    @Test
    public void testSetMemberOnScreen() {
        MapScreen mapScreen = new MapScreen(config);
         Player player = new Player('X', mapScreen, config);
        mapScreen.setMemberOnScreen(player);
        Assert.assertEquals(player.getShape(), mapScreen.getObjectOnLocation(player.getPosition()));
    }
}
