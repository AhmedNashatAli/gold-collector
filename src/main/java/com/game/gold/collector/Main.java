/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.gold.collector;

import com.game.gold.collector.os.OSCommand;
import com.game.gold.collector.os.OSCommandFactory;
import com.game.gold.collector.menu.MainMenu;
import com.game.gold.collector.util.Configuration;

/**
 *
 * @author Ahmed Nashaat
 */
public class Main {

    private Configuration config;
    private OSCommand osCommand;
    private MainMenu mainMenu;

    public static void main(String st[]) {
        Main main = new Main();
        main.init();
    }

    public void init() {
        config = new Configuration();
        osCommand = OSCommandFactory.loadOS();
        osCommand.preProssingCommands();
        osCommand.clearScreen();
        osCommand.writeToScreen(config.getWelcomeMessage());
        osCommand.writeToScreen(config.getHelpMenu());
        mainMenu = new MainMenu(config, osCommand);

    }

}
