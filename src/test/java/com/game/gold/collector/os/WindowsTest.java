/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.gold.collector.os;

import com.game.gold.collector.os.*;

/**
 *
 * @author Ahmed Nashaat
 */
public class WindowsTest implements OSCommand {

    private String line = "5";
    private String out;
    private boolean isClosed;
    @Override
    public void preProssingCommands() {
    }

    @Override
    public void postProssingCommands() {

    }

    @Override
    public void clearScreen() {

    }

    @Override
    public String readLineFromConsole() {
        return line;
    }

    @Override
    public void writeToScreen(String out) {
        this.out = out;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getOut() {
        return out;
    }

    public boolean isIsClosed() {
        return isClosed;
    }

    @Override
    public void closeSystem() {
        isClosed=true;
    }

}
