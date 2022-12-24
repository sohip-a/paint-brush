
package com.mycompany.ftask;
import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Ftask {

    public static void main(String[] args) {
       
      JFrame myfram= new JFrame();
        myfram.setTitle("QA app with sohaib");
        myfram.setSize(500,500);
       
        
       MyFPanel ob =new MyFPanel();
        // insert mypanel in fram
        myfram.setContentPane(ob);
        myfram.setVisible(true);
        myfram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        try
        {
            BufferedImage image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = image.createGraphics();
            myfram.paint(graphics2D);
            ImageIO.write(image,"jpeg", new File("jmemPractice.jpeg"));
        }
        catch(Exception exception)
        {
            //code
        }
    }
}
