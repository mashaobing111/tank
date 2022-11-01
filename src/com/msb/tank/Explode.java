package com.msb.tank;

import java.awt.*;

/**
 * @author: msb
 * @date: 2022/10/24 - 10 - 24 - 17:57
 * @description: com.msb.tank
 * @version: 1.0
 */
public class Explode {
    private int x, y;//爆炸位置

    public static int WIDTH = ResourceMgr.explodes[0].getWidth(), HEIGHT = ResourceMgr.explodes[0].getHeight();//爆炸大小

    private  int step = 0;
    GameModel gm = null;
    public Explode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
//        new Audio("D:\\IDEA_workspace\\tank\\src\\audio/explode.wav").run();
    }
    public void paint(Graphics g){
        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if(step >= ResourceMgr.explodes.length){
           gm.explodes.remove(this);
        }

    }


}



