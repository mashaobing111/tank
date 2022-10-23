package com.msb.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author: msb
 * @date: 2022/10/23 - 10 - 23 - 17:13
 * @description: com.msb.tank
 * @version: 1.0
 */
public class TankFrame extends Frame {
    int x = 200, y = 200;
    public TankFrame() throws HeadlessException {
        //设置窗口初始大小
        setSize(800,600);
        //窗口是否可调整大小
        setResizable(false);
        //窗口标题
        setTitle("tank war");
        //设置可见
        setVisible(true);

        //点击X关闭窗口的
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    //在窗口内画一个黑方块
    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        //坐标改为变量 每次调用就可移动
        g.fillRect(x,y,70,50);
        x += 10;
        y += 10;
    }
}
