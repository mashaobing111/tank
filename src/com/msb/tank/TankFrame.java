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
    //没类初始方向
    Dir dir=Dir.UP;
    //定义坦克速度
    final int SPEED = 10;
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

        g.fillRect(x,y,50,50);
        //根据坦克的方向移动
        switch (dir){
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }



        //x += 10;
        //y += 10;

    }
    //创建内部类   ：如果只有TankFrame类使用  就创建内部类即可
    //键盘监听器
    class MyKeyListener extends KeyAdapter{
        boolean bw = false;
        boolean bs = false;
        boolean ba = false;
        boolean bd = false;
        //按下键盘任意按键 调用
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_W:
                    bw = true;
                    break;
                case KeyEvent.VK_S:
                    bs = true;
                    break;
                case KeyEvent.VK_A:
                    ba = true;
                    break;
                case KeyEvent.VK_D:
                    bd = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }


        //松开键盘任意按键调用
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_W:
                    bw = false;
                    break;
                case KeyEvent.VK_S:
                    bs = false;
                    break;
                case KeyEvent.VK_A:
                    ba = false;
                    break;
                case KeyEvent.VK_D:
                    bd = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }
        //根据按键设置坦克的方向
        private void setMainTankDir() {
         if (bw) dir = Dir.UP;
         if (bs) dir = Dir.DOWN;
         if (ba) dir = Dir.LEFT;
         if (bd) dir = Dir.RIGHT;
        }
    }
}
