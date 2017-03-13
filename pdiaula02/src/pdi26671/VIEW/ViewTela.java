package pdi26671.VIEW;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

import pdi26671.CONTROL.CtrlGeral;

public class ViewTela{
	private JFrame janela;
	private CtrlGeral ctrl;
	JPanel matriz = new JPanel();
	JPanel template = new JPanel();
    JPanel botoesM = new JPanel();
    JPanel botoesP = new JPanel();    
    JSlider sliderMX = new JSlider(JSlider.HORIZONTAL, 0, 18, 0);
    JSlider sliderMY = new JSlider(JSlider.HORIZONTAL, 0, 18, 0);
    JSlider sliderPX = new JSlider(JSlider.HORIZONTAL, 0, 18, 0);
    JSlider sliderPY = new JSlider(JSlider.HORIZONTAL, 0, 18, 0);
    JButton setM = new JButton("Gerar Matiz");
    JButton setP = new JButton("Gerar Template");
    JButton setCM = new JButton("Cor Matriz");
    JButton setCP = new JButton("Cor Template");
    Color corM = new Color(0,0,0);
    Color corP = new Color(0,0,0);
    
    MouseListener mlOpcoes = new MouseListener(){ 
		public void mouseClicked(MouseEvent e)
		{
			int x = e.getX()-10;
			int y = e.getY()-10;
			int posx = (int) ((x+32)/32.0);
			int posy = (int) ((y+32)/32.0);
			System.out.println("Linha: " + posy + " Coluna: " + posx);
			desenhaRect(posx, posy);
			
		}
		public void mousePressed(MouseEvent e) 
		{
			
			
		}
		public void mouseReleased(MouseEvent e) 
		{
			
			
		}
		public void mouseEntered(MouseEvent e) 
		{
			
			
		}
		public void mouseExited(MouseEvent e) 
		{
			
			
		}		
	};
    
    public ViewTela(CtrlGeral c)
    {
    	ctrl = c;
    	janela = new JFrame("26671 - Convolucao");
	    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.mostraJanela();
    }
    
    public void mostraJanela()
    {
    	janela.setSize(1366, 768);
    	janela.setLayout(null);	    
	    matriz.setBackground(new Color(200,200,255));
	    template.setBackground(new Color(200,255,200));	    
	    janela.add(matriz);
	    janela.add(template);
	    janela.add(botoesM);
	    janela.add(botoesP);
	    matriz.setSize(new Dimension(680,600));
	    template.setSize(new Dimension(680,600));	
	    botoesM.setSize(new Dimension(683,168)); 
	    botoesP.setSize(new Dimension(683,168)); 
	    //botoesM.setLayout(new GridLayout(4,4));
	    //botoesP.setLayout(new GridLayout(4,4));
	    matriz.setLocation(0, 0);
	    template.setLocation(686, 0);
	    botoesM.setLocation(0, 600);
	    botoesP.setLocation(683, 600);
	    botoesM.add(sliderMX);
	    botoesM.add(sliderMY);
	    botoesM.add(setM);
	    botoesM.add(setCM);
	    botoesP.add(sliderPX);
	    botoesP.add(sliderPY);
	    botoesP.add(setP);
	    botoesP.add(setCP);
	    setM.addActionListener(ctrl.new drawM());
	    setCM.addActionListener(ctrl.new corM());
	    setCP.addActionListener(ctrl.new corP());
	    sliderMX.setMinorTickSpacing(1);
	    sliderMX.setMajorTickSpacing(5);
	    sliderMX.setPaintTicks(true);
	    sliderMX.setPaintLabels(true);
	    sliderMY.setMinorTickSpacing(1);
	    sliderMY.setMajorTickSpacing(5);
	    sliderMY.setPaintTicks(true);
	    sliderMY.setPaintLabels(true);
	    sliderPX.setMinorTickSpacing(1);
	    sliderPX.setMajorTickSpacing(5);
	    sliderPX.setPaintTicks(true);
	    sliderPX.setPaintLabels(true);
	    sliderPY.setMinorTickSpacing(1);
	    sliderPY.setMajorTickSpacing(5);
	    sliderPY.setPaintTicks(true);
	    sliderPY.setPaintLabels(true);
	    matriz.addMouseListener(mlOpcoes);
	    janela.setVisible(true);
    }
    
    public void limpa()
    {
    	Graphics g = matriz.getGraphics();
    	g.setColor(new Color(200,200,255));
    	g.fillRect(0,0, 680, 600);
    }
    
    public void sctCor(int i) {
		if(i==1)this.corM = JColorChooser.showDialog(new JFrame(), "Selecione a cor", corM);
		else this.corP = JColorChooser.showDialog(new JFrame(), "Selecione a cor", corP);
    }
    
    public void desenhaM()
    {
    	Graphics g = matriz.getGraphics();    	
    	Graphics2D g2 = (Graphics2D) g;
    	g2.setStroke(new BasicStroke(2));
    	int x = sliderMX.getValue();
    	int y = sliderMY.getValue();
    	System.out.println(x + " " + y);
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
    
    public void desenhaRect(int x, int y)
    {
    	if(x<=sliderMX.getValue() && y<=sliderMY.getValue())
    	{     	
	    	int px=10;
	    	int py=10;
	    	System.out.println(x + " " + y);
	    	int posx = 10+((x-1)*32);
	    	int posy = 10+((y-1)*32);
	    	Graphics g = matriz.getGraphics();
	    	System.out.println("Oi\n" + corM + " " + posx + " " + posy);
	    	g.setColor(corM);
	    	g.fillRect(posx, posy, 32, 32);
	    	desenhaM();
    	}
    }

}
