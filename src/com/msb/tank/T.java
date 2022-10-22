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
public class T {
    public static void main(String[] args) {
        //创建一个窗口对象
        Frame f = new Frame();
        //设置窗口初始大小
        f.setSize(800,600);
        //窗口是否可调整大小
        f.setResizable(false);
        //窗口标题
        f.setTitle("tank war");
        //设置可见
        f.setVisible(true);

        //点击X关闭窗口的
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                System.out.println();
            }
        });

    }
}
