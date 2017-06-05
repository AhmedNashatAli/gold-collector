/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.gold.collector.menu;

import com.game.gold.collector.os.WindowsTest;
import com.game.gold.collector.menu.MainMenu;
import com.game.gold.collector.util.Configuration;
import org.junit.Assert;
import org.junit.Test;

public class MainMenuTest {

    WindowsTest windowsTest = new WindowsTest();
    Configuration config = new Configuration();

    @Test
    public void testExitOption() {
        windowsTest.setLine("5");
        MainMenu mainMenu = new MainMenu(config, windowsTest);
        Assert.assertTrue(windowsTest.isIsClosed());

    }

    @Test
    public void testShowMenuAndWaitForAction() {
        MainMenu mainMenu = new MainMenu(config, windowsTest);
        Assert.assertEquals(config.getMainMenu(), windowsTest.getOut());

    }

    @Test
    public void testCreateCharacter() {
        MainMenu mainMenu = new MainMenu(config, windowsTest);
        windowsTest.setLine("T");
        mainMenu.createCharacter();
        Assert.assertEquals('T', config.getPlayerChar());

    }

    @Test
    public void testEnterInvalidMenuOption() {
        MainMenu mainMenu = new MainMenu(config, windowsTest);
        Assert.assertEquals(0, mainMenu.getSelectedOption("yyyy"));
        Assert.assertEquals(0, mainMenu.getSelectedOption("$"));

    }

    @Test
    public void testValidOption() {
        MainMenu mainMenu = new MainMenu(config, windowsTest);
        Assert.assertEquals(1, mainMenu.getSelectedOption("1"));
        Assert.assertEquals(2, mainMenu.getSelectedOption("2"));

    }

}
