package com.msb.tank;

/**
 * @author: msb
 * @date: 2022/10/30 - 10 - 30 - 15:25
 * @description: com.msb.tank
 * @version: 1.0
 */
public class DefaultFireStrategy implements FireStrategy {

    @Override
    public void fire(Tank t) {
        int bx = t.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = t.getY() + Tank.HEIGHT /2 - Bullet.HEIGHT / 2;
       new Bullet(bx, by, t.getDir(),t.getGroup(), t.tf);
    }
}
