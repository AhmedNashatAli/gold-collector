/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.gold.collector.os;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmed Nashaat
 */
public class Windows implements OSCommand {
    Scanner scanner;

    @Override
    public void preProssingCommands() {
      scanner=new Scanner(System.in);
    }

    @Override
    public void postProssingCommands() {

    }

    @Override
    public void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException ex) {
            Logger.getLogger(Windows.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String readLineFromConsole() {
       return scanner.nextLine();
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
