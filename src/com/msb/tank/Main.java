package com.msb.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author: msb
 * @date: 2022/10/22 - 10 - 22 - 17:39
 * @description: com.msb.tank
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        TankFrame tf = new TankFrame();

        while(true){
            try {
                Thread.sleep(50);
                tf.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
