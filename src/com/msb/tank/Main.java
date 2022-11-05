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
    public static void main(String[] args) throws InterruptedException {
        //创建窗口对象
        TankFrame tf = new TankFrame();




        while (true){
            //睡眠50ms
            Thread.sleep(50);
            //重新调用paint方法
            tf.repaint();}
    }
}
