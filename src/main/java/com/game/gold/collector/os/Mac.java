/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.gold.collector.os;

import java.util.Scanner;

/**
 *
 * @author Ahmed Nashaat
 */
public class Mac implements OSCommand {

    Scanner scanner;

    @Override
    public void preProssingCommands() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void postProssingCommands() {

    }

    @Override
    public void clearScreen() {

    }

    @Override
    public String readLineFromConsole() {
        return scanner.nextLine();
    }

    @Override
    public void writeToScreen(String out) {
        System.out.print(out);
    }

}
