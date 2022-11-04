package com.msb.tank;

import java.awt.*;

/**
 * @author: msb
 * @date: 2022/11/1 - 11 - 01 - 16:57
 * @description: com.msb.tank
 * @version: 1.0
 */
public abstract class GameObject {//创建一个游戏物体的父类抽象
    int x, y;
    public abstract void paint(Graphics g);
}
