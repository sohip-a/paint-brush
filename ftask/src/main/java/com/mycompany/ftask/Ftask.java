/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ftask;

import javax.swing.JFrame;

/**
 *
 * @author sohip
 */
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
    }
}
