package pdi26671.VIEW;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pdi26671.MODEL.Matrix;

public class MostraResultado extends JFrame {
	
	public MostraResultado(Matrix m) {
		this.setSize(680, 600);
		this.setTitle("26671 - Convolucao - Resultado");
		this.setContentPane(new DrawPanel(m));		
        this.setVisible(true); 
	}
}
