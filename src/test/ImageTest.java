package test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * @author: msb
 * @date: 2022/10/26 - 10 - 26 - 17:00
 * @description: com.msb.test
 * @version: 1.0
 */
class ImageTest {

    @Test
    void test(){
        try {
            //获取本地的图片
            /*BufferedImage image = ImageIO.read(new File("C:/Users/马少兵/Pictures/Saved Pictures/群邮件.jpg"));
            Assertions.assertNotNull(image);*/
            BufferedImage images = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            Assertions.assertNotNull(images);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
