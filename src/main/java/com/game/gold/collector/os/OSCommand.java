/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.gold.collector.os;

import java.io.Serializable;

/**
 *
 * @author Ahmed Nashaat
 */
public interface OSCommand extends Serializable{
    void preProssingCommands();
    void postProssingCommands();
    String readLineFromConsole();
    void clearScreen();
    void writeToScreen(String out);
    void closeSystem();
}
