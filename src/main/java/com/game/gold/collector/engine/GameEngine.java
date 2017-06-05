/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.gold.collector.engine;

import com.game.gold.collector.element.Border;
import com.game.gold.collector.element.Gold;
import com.game.gold.collector.element.MapScreen;
import com.game.gold.collector.element.Player;
import com.game.gold.collector.menu.MainMenu;
import com.game.gold.collector.os.OSCommand;
import com.game.gold.collector.util.Configuration;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmed Nashaat
 */
public class GameEngine implements Serializable {

    private MapScreen screen;
    private Border border;
    private Player player;
    private Gold gold;
    private Configuration config;
    /**
     * 
     * @param config
     * @param osCommand
     * @param mainMenu 
     */
    public GameEngine(Configuration config, OSCommand osCommand, MainMenu mainMenu) {
        this.config=config;
        screen = new MapScreen(config);
        screen.InitScreen(config.getScreenDefaultChar());
        border = new Border(config.getBorderChar(), screen,osCommand,config.getObstacles());
        player = new Player(config.getPlayerChar(), screen, config);
        gold = new Gold(config.getGoldChar());
        gold.placeGoldRandom(screen, player);
        start(osCommand, mainMenu);
    }
    /**
     * 
     * @param osCommand
     * @param mainMenu 
     */
    public void start(OSCommand osCommand, MainMenu mainMenu) {
        waitForPlayingAction(osCommand);
        mainMenu.showMenuAndWaitForAction();
    }
    /**
     * 
     * @param osCommand 
     */
    private void waitForPlayingAction(OSCommand osCommand) {
        boolean notFinished = true;
        while (notFinished) {
            osCommand.clearScreen();
            screen.PrintScreen();
            String input = osCommand.readLineFromConsole();
            notFinished = applyAction(input, notFinished);

        }
    }
    /**
     * 
     * @param input
     * @param notFinished
     * @return 
     */
    private boolean applyAction(String input, boolean notFinished) {
        if (!input.isEmpty()) {
            switch (input.charAt(0)) {
                case 'a':
                    notFinished = player.moveLeft(screen);
                    screen.PrintScreen();
                    break;
                case 'd':
                    notFinished = player.moveRight(screen);
                    screen.PrintScreen();
                    break;
                case 'w':
                    notFinished = player.moveUp(screen);
                    screen.PrintScreen();
                    break;
                case 's':
                    notFinished = player.moveDown(screen);
                    screen.PrintScreen();
                    break;
                case 'p':
                    serializeMe();
                    notFinished = false;
                    break;
                case 'b':
                    notFinished = false;
                    break;
                default:
                    break;
            }
        }
        return notFinished;
    }

    private void serializeMe() {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try {
            fout = new FileOutputStream(config.getSerializeFileName());
            oos = new ObjectOutputStream(fout);
            oos.writeObject(this);

            System.out.print(config.getSaveSuccessMessage());

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    /**
     * 
     * @param config
     * @return 
     */
    public static GameEngine deserialize(Configuration config)  {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(config.getSerializeFileName());
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            GameEngine gameEngine = (GameEngine) ois.readObject();
            ois.close();
            File f = new File(config.getSerializeFileName());
            f.delete();
            return gameEngine;
        } catch (IOException |ClassNotFoundException ex) {           
            System.out.print("Sorry could not open saved game.\r\n");           
            return null;
        }  finally {
            try {
               if(fis!=null) fis.close();
            } catch (IOException ex) {
                Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
