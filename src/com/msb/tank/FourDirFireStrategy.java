package com.msb.tank;

/**
 * @author: msb
 * @date: 2022/10/30 - 10 - 30 - 15:40
 * @description: com.msb.tank
 * @version: 1.0
 */
public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bx = t.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = t.getY() + Tank.HEIGHT /2 - Bullet.HEIGHT / 2;

        Dir[] dirs = Dir.values();
        for (Dir dir:dirs){
            new Bullet(bx, by, dir ,t.getGroup(), t.gm);
        }

    }
}
