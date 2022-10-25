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

    Tank myTank = new Tank(200,200,Dir.DOWN,this);
    Bullet b = new Bullet(300,300,Dir.DOWN);
    static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;//定义窗口大小

    public TankFrame() throws HeadlessException {
        //设置窗口初始大小
        setSize(GAME_WIDTH,GAME_HEIGHT);
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
    //双重缓存解决闪烁问题
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }

    //在窗口内创建一个坦克
    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
        b.paint(g);
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
                case KeyEvent.VK_SPACE:
                    myTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }
        //根据按键设置坦克的方向和移动
        private void setMainTankDir() {
            //判断是否在移动
            if(!bw && !bs && !ba && !bd){
                myTank.setMoving(false);
            }else {
                myTank.setMoving(true);

                if (bw) myTank.setDir(Dir.UP);
                if (bs) myTank.setDir(Dir.DOWN);
                if (ba) myTank.setDir(Dir.LEFT);
                if (bd) myTank.setDir(Dir.RIGHT);
            }
        }
    }
}
