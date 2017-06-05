/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.gold.collector.menu;

import com.game.gold.collector.engine.GameEngine;
import com.game.gold.collector.os.OSCommand;
import com.game.gold.collector.util.Configuration;
import java.io.Serializable;

/**
 *
 * @author Ahmed Nashaat
 */
public class MainMenu implements Serializable{

    private GameEngine game;
    private Configuration config;
    private OSCommand osCommand;

    public MainMenu(Configuration config,  OSCommand osCommand) {
        this.config = config;
        this.osCommand = osCommand;
        showMenuAndWaitForAction();
    }

    public void showMenuAndWaitForAction() {
        osCommand.writeToScreen(config.getMainMenu());
        waitForAction();
    }

    private void waitForAction() {
        String line = osCommand.readLineFromConsole();
        int numb = getSelectedOption(line);
        switch (numb) {
            case 1:
                osCommand.clearScreen();
                createCharacter();
                osCommand.writeToScreen(config.getSaveSuccessMessage());
                showMenuAndWaitForAction();
                break;
            case 2:
                osCommand.clearScreen();
                game = new GameEngine(config, osCommand, this);
                break;
            case 3:
                osCommand.clearScreen();
                resumeGame();
                break;
            case 4:
                osCommand.writeToScreen(config.getHelpMenu());
                showMenuAndWaitForAction();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                osCommand.writeToScreen(config.getMenuFailure());
                waitForAction();
                break;
        }
    }
    public void createCharacter() {
        osCommand.writeToScreen(config.getCharacterMessage());
        boolean notCorrect = true;
        char shape = config.getPlayerChar();
        while (notCorrect) {
            String input = osCommand.readLineFromConsole();
            if (!input.isEmpty() && input.charAt(0) != config.getBorderChar() && input.charAt(0) != config.getGoldChar()) {
                shape = input.charAt(0);
                notCorrect = false;
            }
        }
        config.setPlayerChar(shape);
        
    }
    private int getSelectedOption(String line) {
        int numb = 0;
        if (!line.isEmpty()) {
            try {
                numb = Integer.parseInt("" + line.charAt(0));
            } catch (Exception e) {

                return numb;
            }
        }
        return numb;
    }

    private void resumeGame() {
        game = GameEngine.deserialize(config);
        if (game != null) {
            game.start(osCommand, this);
        } else {
            showMenuAndWaitForAction();
        }
    }

}
