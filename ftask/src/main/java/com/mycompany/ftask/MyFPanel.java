package com.mycompany.ftask;

import javax.swing.JPanel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import static java.lang.Thread.sleep;
import java.util.Vector;
import java.util.logging.*;
import javax.swing.JButton;

public class MyFPanel extends JPanel {

    int x, y, tempCount;
    boolean FillF, FillD;
    JButton Rect, Cir, Line, Erase, clearAll;
    JButton Red, Green, Blue, freeHand;
    Checkbox FillBox, dottedBox;
    public int x1, x2, y1, y2;
    Vector<Integer> v1; // for lines
    Vector<Integer> v2; // for x2, y2 of lines
    Vector<Color> vL;//lines color
    Vector<Color> vR;
    Vector<Color> vC;
    Vector<Integer> vE;
    Vector<Integer> lDT;//line type outer dash filled
    Vector<Integer> rDT;
    Vector<Integer> cDT;

    public int Rx1, Rx2, Ry1, Ry2, Rw, Rh;
    public int Cx1, Cx2, Cy1, Cy2, Cw, Ch;
    public int Ex1, Ex2, Ey1, Ey2, Ew, Eh;
    public  int fX1,fX2,fY1,fY2;
    Color currentColor = Color.BLACK;
    Vector<Integer> v3;
    Vector<Integer> v4;// fow w h of rect
    Vector<Integer> v5; // for cir
    Vector<Integer> v6;// fow  of cir
    Vector<Integer> vF1; // for free hand
    Vector<Integer> vF2; //for freehand
// الاول نضيف الزراير
// Dotted line

    public void drawDashedLine(Graphics g, int x1, int y1, int x2, int y2) {

        // Create a copy of the Graphics instance
        Graphics2D g2d = (Graphics2D) g.create();

        // Set the stroke of the copy, not the original 
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
                0, new float[]{9}, 0);
        g2d.setStroke(dashed);

        // Draw to the copy
        g2d.drawLine(x1, y1, x2, y2);

        // Get rid of the copy
        g2d.dispose();
    }
//dotted rect

    public void drawDashedRect(Graphics g, int x1, int y1, int w, int h) {

        // Create a copy of the Graphics instance
        Graphics2D g2d = (Graphics2D) g.create();

        // Set the stroke of the copy, not the original 
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
                0, new float[]{9}, 0);
        g2d.setStroke(dashed);

        // Draw to the copy
        g2d.drawRect(x1, y1, w, h);

        // Get rid of the copy
        g2d.dispose();
    }

    // dotted circle
    public void drawDashedOval(Graphics g, int x1, int y1, int w, int h) {

        // Create a copy of the Graphics instance
        Graphics2D g2d = (Graphics2D) g.create();

        // Set the stroke of the copy, not the original 
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
                0, new float[]{9}, 0);
        g2d.setStroke(dashed);

        // Draw to the copy
        g2d.drawOval(x1, y1, w, h);

        // Get rid of the copy
        g2d.dispose();
    }

    private void createLineButton(){
        Line = new JButton("Line");
        Line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = 1;
                updateUI();
            }
        });
        this.add(Line);
    }
    private void createRectangleButton(){
        Rect = new JButton("Rectangular");
        Rect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = 2;
                updateUI();
            }
        });
        this.add(Rect);
    }
    private void createCircleButton(){
        Cir = new JButton("Cirlses");
        Cir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = 3;
                updateUI();
            }
        });
        this.add(Cir);
    }
    private void createEraseButton(){
        Erase = new JButton("Erase");
        Erase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = 4;
            }
        });
        this.add(Erase);
    }
    private void createClearButton(){
        clearAll = new JButton("clearAll");
        clearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v1.clear();
                v2.clear();
                v3.clear();
                v4.clear();
                v5.clear();
                v6.clear();
                vL.clear();
                vR.clear();
                vC.clear();
                // v.clear();
                updateUI();
            }
        });
        this.add(clearAll);
    }
    private void createFreeHandButton(){
        freeHand = new JButton("freeHand");
        freeHand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = 5;
            }
        });
        this.add(freeHand);
    }
    private void createRedButton(){
        Red = new JButton("Red");
        Red.setBackground(Color.RED);
        Red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.RED;
                updateUI();
            }
        });
        this.add(Red);
    }
    private void createGreenButton(){
        Green = new JButton("Green");
        Green.setBackground(Color.GREEN);
        Green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.GREEN;
                updateUI();
            }
        });
        this.add(Green);
    }
    private void createBlueButton(){
        Blue = new JButton("Blue");
        Blue.setBackground(Color.BLUE);
        Blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.BLUE;
                updateUI();
            }
        });
        this.add(Blue);
    }
    private void  createFillCheckBox(){
        FillBox = new Checkbox("Fill");
        FillBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ev) {
                FillF = !FillF;
            }
        });
        add(FillBox);
    }
    private void createDotCheckBox(){
        dottedBox = new Checkbox("dottedBox");
        dottedBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ev) {
                FillD = !FillD;
            }
        });
        add(dottedBox);
    }
    private void paintLine(Graphics g){
        if (FillD) {
            lDT.add(2);
            drawDashedLine(g, x1, y1, x2, y2);
        } else {
            lDT.add(3);
            g.drawLine(x1, y1, x2, y2);
        }
    }
    private void paintFreeHand(Graphics g){
        for(int i=0;i<vF1.size();i+=2){
            g.drawLine(vF1.get(i),vF1.get(i+1),vF2.get(i),vF2.get(i+1));
        }

    }
    private void paintRectangle(Graphics g){
        if (FillF) {
            rDT.add(1);
            g.fillRect(Rx1, Ry1, Rw, Rh);
        } else if (FillD) {
            rDT.add(2);
            drawDashedRect(g, Rx1, Ry1, Rw, Rh);
        } else {
            rDT.add(3);
            g.drawRect(Rx1, Ry1, Rw, Rh);
        }
    }
    private void paintCircle(Graphics g){
        if (FillF) {
            cDT.add(1);
            g.fillOval(Cx1, Cy1, Cw, Ch);
        } else if (FillD) {
            cDT.add(2);
            drawDashedOval(g, Cx1, Cy1, Cw, Ch);
        } else {
            cDT.add(3);
            g.drawOval(Cx1, Cy1, Cw, Ch);
        }
    }
    private void erase(Graphics g){
        tempCount = 0;
        for (int i = 0; i < vE.size(); i += 2) {
            g.setColor(Color.BLACK);
            g.fillRect(vE.get(i), vE.get(i + 1), 10, 10);
        }
    }
    private void drawOldLines(Graphics g){
        tempCount = 0;
        for (int i = 0; i < v1.size(); i += 2) {

//            if (lDT.get(tempCount) == 2) {
//                drawDashedLine(g, v1.get(i), v1.get(i + 1), v2.get(i), v2.get(i + 1));
//            } else {
            g.drawLine(v1.get(i), v1.get(i + 1), v2.get(i), v2.get(i + 1));
//            }
//            System.out.println("qqqqqqqqqqqqqqqqqqqqt()"+tempCount);
            g.setColor(vL.get(tempCount));
            tempCount++;
            System.out.println("fffffffffffffffffffffffffffffffff"+v1.size());
        }
    }
    private void drawOldCircles(Graphics g){
        tempCount = 0;
        for (int i = 0; i < v5.size(); i += 2) {
            g.drawOval(v5.get(i), v5.get(i + 1), v6.get(i), v6.get(i + 1));
            g.setColor(vC.get(tempCount++));
        }
    }
    private void drawOldRectangles(Graphics g){
        tempCount = 0;
        for (int i = 0; i < v3.size(); i += 2) {
            g.drawRect(v3.get(i), v3.get(i + 1), v4.get(i), v4.get(i + 1));
            g.setColor(vR.get(tempCount++));
        }
    }
    private void drawOldFreeHand(Graphics g){}
    public MyFPanel() {
        v1 = new Vector<Integer>();
        v2 = new Vector<Integer>();
        v3 = new Vector<Integer>();
        v4 = new Vector<Integer>();
        v5 = new Vector<Integer>();
        v6 = new Vector<Integer>();
        vF1=new Vector<Integer>();
        vF2=new Vector<Integer>();
        vL = new Vector<Color>();
        vR = new Vector<Color>();
        vC = new Vector<Color>();
        cDT = new Vector<Integer>();
        lDT = new Vector<Integer>();
        rDT = new Vector<Integer>();
        vE = new Vector<Integer>();
        FillF = false;
        FillD = false;

        this.setBackground(Color.LIGHT_GRAY);

        x = 0;
        // هنا نعمل زر للخطوط
        createLineButton();

        // هنا نعمل زر للمستطيل
        createRectangleButton();

        // هنا نعمل زر دواير
        createCircleButton();

        // هنا نعمل زر للمسح
        createEraseButton();

        // هنا نعمل زر مسح الكل
        createClearButton();

        // هنا نعمل زر freehand
        createFreeHandButton();

        // هنضيف زراير  الوان 
        createRedButton();
        createGreenButton();
        createBlueButton();

        // هنا نعمل الملىء والداش لاين
        createFillCheckBox();
        createDotCheckBox();


    }
// 
    //
    //رسم
    //رسم
    //رسم
    //

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //   g.drawString("your in mode nu " + x, 50, 100);
        // اوجه الزرار لشكل معين ياخد ابعاده من خلال الماوس
        this.setFocusable(true);
        g.setColor(currentColor);


        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(x==1)
                {
                    x1 = e.getX();
                    y1 = e.getY();
                }
                else if(x==2){
                    Rx1 = e.getX();
                    Ry1 = e.getY();
                    System.out.println("-----------------------X in rect-----------------------"+x1);
                }
                else if (x==3){
                    Cx1 = e.getX();
                    Cy1 = e.getY();
                }
                else if (x==4){
                    Ex1 = e.getX();
                    Ey1 = e.getY();
                    vE.add(Ex1);
                    vE.add(Ey1);
                    updateUI();
                }
                else if(x==5){
                    fX1=e.getX();
                    fY1=e.getY();
                    vF1.add(fX1);
                    vF1.add(fY1);
                    updateUI();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(x==1)
                {
                    x2 = e.getX();
                    y2 = e.getY();
//                    if (x == 1) {
                        v1.add(x1);
                        v1.add(y1);
                        v2.add(x2);
                        v2.add(y2);
                        vL.add(currentColor);
//                    }

                }
                else if(x==2){
                    Rx2 = e.getX();
                    Ry2 = e.getY();
                    Rw = Rx2 - Rx1;
                    Rh = Ry2 - Ry1;
                    v3.add(Rx1);
                    v3.add(Ry1);
                    v4.add(Rw);
                    v4.add(Rh);
                    vR.add(currentColor);

                }
                else if (x==3){
                    Cx2 = e.getX();
                    Cy2 = e.getY();
                    v5.add(Cx1);
                    v5.add(Cy1);
                    Cw = Cx2 - Cx1;
                    Ch = Cy2 - Cy1;
                    v6.add(Cw);
                    v6.add(Ch);
                    vC.add(currentColor);


                }
                else if (x==5){
                    fX2=e.getX();
                    fY2=e.getY();
                    vF2.add(fX2);
                    vF2.add(fY2);
                }
                updateUI();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                      throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (x==1)
                {
                    x2 = e.getX();
                    y2 = e.getY();

                    repaint();
                }
                else if (x==2){
                    Rx2 = e.getX();
                    Ry2 = e.getY();
                    Rw = Rx2 - Rx1;
                    Rh = Ry2 - Ry1;
                    //repaint();
                    updateUI();
                }
                else if (x==3){
                    Cx2 = e.getX();
                    Cy2 = e.getY();
                    Cw = Cx2 - Cx1;
                    Ch = Cy2 - Cy1;
                    repaint();
                }
                else if (x==5){
                    fX2=e.getX();
                    fY2=e.getY();
                    vF2.add(fX2);
                    vF2.add(fY2);
                    repaint();
                    vF1.add(fX2);
                    vF1.add(fY2);
                }

            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });


        
         if (x == 1) {
            paintLine(g);

        }
         else if (x == 2) {
            paintRectangle(g);

        } //end f2 draw
        //        f3 draw ovels
        else if (x == 3) {
            paintCircle(g);
        }//endf3 draw ovels
        
        //f4 draw 
        else if (x == 4) {          
            erase(g);
        }
        else if (x==5){
             System.out.println("here -------------------------------"+x);
            paintFreeHand(g);
         }
       
        drawOldLines(g);
        drawOldCircles(g);
        drawOldRectangles(g);

    }//if
    
}
