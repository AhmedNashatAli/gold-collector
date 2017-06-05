/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.gold.collector.os;

/**
 *
 * @author Ahmed Nashaat
 */
public class OSCommandFactory {

    public static OSCommand loadOS() {
        String osName = System.getProperty("os.name");
        OSCommand oSCommand;
        if (osName.toLowerCase().contains("win")) {
            oSCommand = new Windows();
        } else if (osName.toLowerCase().contains("nix") || osName.toLowerCase().contains("nux")
                || osName.contains("aix")) {
            oSCommand = new Linux();
        } else {
            oSCommand = new Mac();
        }
        return oSCommand;
    }
}
