package com.msb.tank.abstractfactory;

import com.msb.tank.ResourceMgr;
import com.msb.tank.TankFrame;

import java.awt.*;

/**
 * @author: msb
 * @date: 2022/10/31 - 10 - 31 - 17:35
 * @description: com.msb.tank.abstractfactory
 * @version: 1.0
 */
public class RectExplode extends BaseExplode {
    private int x, y;//爆炸位置

    public static int WIDTH = ResourceMgr.explodes[0].getWidth(), HEIGHT = ResourceMgr.explodes[0].getHeight();//爆炸大小

    private  int step = 0;
    TankFrame tf = null;
    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
//        new Audio("D:\\IDEA_workspace\\tank\\src\\audio/explode.wav").run();
    }
    @Override
    public void paint(Graphics g){
//        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        Color c = g.getColor();
        g.setColor(Color.red);
        step++;
        g.fillRect(x, y, 10*step, 10*step);

        if(step >= 5){
            tf.explodes.remove(this);
        }
        g.setColor(c);
    }
}
