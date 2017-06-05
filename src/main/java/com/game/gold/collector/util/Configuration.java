/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.gold.collector.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

/**
 *
 * @author Ahmed Nashaat
 */
public class Configuration implements Serializable {

    private String mainMenu;
    private String helpMenu;
    private String welcomeMessage;
    private String winnerMessage;
    private String loserMessage;
    private String serializeFileName;
    private String saveSuccessMessage;
    private String serializeFailureMessage;
    private String menuFailure;
    private String characterMessage;
    private int screenWidth;
    private int screenHeight;
    private int obstacles;
    private char screenDefaultChar;
    private char goldChar;
    private char playerChar;
    private char borderChar;

    public Configuration() {
        Properties prop = getPropertiesFile();
        if (prop == null) {
            System.out.print("Sorry, unable to load configuration.\r\n");
            System.exit(0);
        }
        mainMenu = prop.getProperty("menu.main");
        helpMenu = prop.getProperty("menu.help");
        welcomeMessage = prop.getProperty("message.welcome");
        winnerMessage = prop.getProperty("message.winner");
        loserMessage = prop.getProperty("message.loser");
        serializeFileName = prop.getProperty("serialize.file.name");
        serializeFailureMessage = prop.getProperty("serialize.failure.message");
        saveSuccessMessage = prop.getProperty("save.success.message");
        menuFailure = prop.getProperty("menu.failure");
        characterMessage = prop.getProperty("character.message");
        screenWidth = Integer.parseInt(prop.getProperty("screen.width"));
        screenHeight = Integer.parseInt(prop.getProperty("screen.height"));
        obstacles = Integer.parseInt(prop.getProperty("obstacles"));
        screenDefaultChar = prop.getProperty("screen.default.character").isEmpty() ? ' ' : prop.getProperty("screen.default.character").charAt(0);
        goldChar = prop.getProperty("gold").charAt(0);
        playerChar = prop.getProperty("player").charAt(0);
        borderChar = prop.getProperty("border").charAt(0);
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public char getScreenDefaultChar() {
        return screenDefaultChar;
    }

    public char getGoldChar() {
        return goldChar;
    }

    public char getPlayerChar() {
        return playerChar;
    }

    public char getBorderChar() {
        return borderChar;
    }

    private Properties getPropertiesFile() {
        Properties prop = new Properties();
        InputStream input = null;

        try {

            String filename = "config.properties";
            input = Configuration.class.getClassLoader().getResourceAsStream(filename);
            if (input == null) {
                System.out.print("\r\nSorry, unable to find " + filename + "\r\n");
                System.exit(0);
            }
            prop.load(input);
            return prop;

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String getWinnerMessage() {
        return winnerMessage;
    }

    public String getLoserMessage() {
        return loserMessage;
    }

    public String getMainMenu() {
        return mainMenu;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public String getSerializeFileName() {
        return serializeFileName;
    }

    public String getSaveSuccessMessage() {
        return saveSuccessMessage;
    }

    public String getSerializeFailureMessage() {
        return serializeFailureMessage;
    }

    public String getMenuFailure() {
        return menuFailure;
    }

    public String getHelpMenu() {
        return helpMenu;
    }

    public int getObstacles() {
        return obstacles;
    }

    public String getCharacterMessage() {
        return characterMessage;
    }

    public void setPlayerChar(char shape) {
        this.playerChar=shape;
    }

}
