/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.gold.collector.os;

import java.io.Console;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmed Nashaat
 */
public class Linux implements OSCommand {

    Console console;

    @Override
    public void preProssingCommands() {
        console = System.console();
        try {
            String[] cmd = {"/bin/sh", "-c", "stty raw </dev/tty"};
            Runtime.getRuntime().exec(cmd).waitFor();
        } catch (InterruptedException | IOException ex) {
            Logger.getLogger(Linux.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void postProssingCommands() {
        try {
            String cmd[] = new String[]{"/bin/sh", "-c", "stty sane </dev/tty"};
            Runtime.getRuntime().exec(cmd).waitFor();
        } catch (InterruptedException | IOException ex) {
            Logger.getLogger(Linux.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void clearScreen() {
        try {
            Runtime.getRuntime().exec("clear");
        } catch (IOException ex) {
            Logger.getLogger(Linux.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String readLineFromConsole() {
        return console.readLine();
    }

    @Override
    public void writeToScreen(String out) {
        System.out.print(out);
    }

    @Override
    public void closeSystem() {
        System.exit(0);
    }
}
