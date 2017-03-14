package pdi26671.VIEW;
 
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import pdi26671.MODEL.Matrix;
 
class DrawPanel extends JPanel{
    Matrix c;
	
	public DrawPanel(Matrix m)
    {
    	this.c = m;
    	this.setBackground(new Color(255,200,200));
    }
	
	//Override do componente de pintura do JPanel para aparesentação do resultado da convolução
	public void paintComponent(Graphics g){
		int h = c.getH();
    	int w = c.getW();    	  	
    	for(int i=0; i<h; i++)
    	{
    		for(int j=0; j<w; j++)
    		{
    			g.setColor(c.getPixel(i, j));
    			g.fillRect((10+(i*32)), (10+(j*32)), 32, 32);
    		}
    	}
    	Graphics2D g2 = (Graphics2D) g;
    	g2.setStroke(new BasicStroke(2));
    	g2.setColor(Color.BLACK);
    	int x = c.getH();
    	int y = c.getW();    	
    	int px=10;
    	int py=10;
    	int tamx = x*32;
    	int tamy = y*32;    	
    	
    	for(int i = 0; i<x+1; i++)
    	{
    		g2.drawLine(px,py, px, tamy+py);  
    		px+=32;
    	}
    	px=10;
    	py=10;
    	for(int i = 0; i<y+1; i++)
    	{
    		g2.drawLine(px,py, tamx+px, py);  
    		py+=32;
    	}
     }
 }