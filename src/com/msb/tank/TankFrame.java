package com.msb.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

        //添加键盘监听
        this.addKeyListener(new MyKeyListener());
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
        g.fillRect(x,y,50,50);

        x += 10;
        //y += 10;

    }
    //创建内部类   ：如果只有TankFrame类使用  就创建内部类即可
    //键盘监听器
    class MyKeyListener extends KeyAdapter{
        //按下键盘任意按键 调用
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("key pressed");
            //x += 10;
            //repaint();
        }

        //松开键盘任意按键调用
        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");
        }
    }
}
