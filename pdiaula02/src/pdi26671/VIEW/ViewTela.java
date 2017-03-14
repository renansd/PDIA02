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
import pdi26671.MODEL.Matrix;

public class ViewTela{
	private JFrame janela;
	private JFrame janelaRtd;
	private CtrlGeral ctrl;
	JPanel matriz = new JPanel();
	JPanel template = new JPanel();
    JPanel botoesM = new JPanel();
    JPanel botoesP = new JPanel();
    JPanel botao = new JPanel();
    JPanel Rtd = new JPanel();
    JSlider sliderMX = new JSlider(JSlider.HORIZONTAL, 0, 18, 0);
    JSlider sliderMY = new JSlider(JSlider.HORIZONTAL, 0, 18, 0);
    JSlider sliderPX = new JSlider(JSlider.HORIZONTAL, 0, 18, 0);
    JSlider sliderPY = new JSlider(JSlider.HORIZONTAL, 0, 18, 0);
    JButton setM = new JButton("Gerar Matiz");
    JButton setP = new JButton("Gerar Template");
    JButton setCM = new JButton("Cor Matriz");
    JButton setCP = new JButton("Cor Template");
    JButton conMP = new JButton("Convolucao");
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
			ctrl.pinta(posx-1, posy-1,corM, 1);
			
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
	
	MouseListener mlOpcoes2 = new MouseListener(){ 
		public void mouseClicked(MouseEvent e)
		{
			int x = e.getX()-10;
			int y = e.getY()-10;
			int posx = (int) ((x+32)/32.0);
			int posy = (int) ((y+32)/32.0);
			System.out.println("Linha: " + posy + " Coluna: " + posx);
			ctrl.pinta(posx-1, posy-1,corP, 2);
			
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
	    janela.add(botao);
	    matriz.setSize(new Dimension(680,600));
	    template.setSize(new Dimension(680,600));	
	    botoesM.setSize(new Dimension(683,68)); 
	    botoesP.setSize(new Dimension(683,68));
	    botao.setSize(new Dimension(1366,100));
	    //botoesM.setLayout(new GridLayout(4,4));
	    //botoesP.setLayout(new GridLayout(4,4));
	    matriz.setLocation(0, 0);
	    template.setLocation(686, 0);
	    botoesM.setLocation(0, 600);
	    botoesP.setLocation(683, 600);
	    botao.setLocation(0, 668);
	    botoesM.add(sliderMX);
	    botoesM.add(sliderMY);
	    botoesM.add(setM);
	    botoesM.add(setCM);
	    botoesP.add(sliderPX);
	    botoesP.add(sliderPY);
	    botoesP.add(setP);
	    botoesP.add(setCP);
	    botao.add(conMP);
	    setM.addActionListener(ctrl.new drawM());
	    setP.addActionListener(ctrl.new drawP());
	    setCM.addActionListener(ctrl.new corM());
	    setCP.addActionListener(ctrl.new corP());
	    conMP.addActionListener(ctrl.new conMP());
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
	    template.addMouseListener(mlOpcoes2);
	    janela.setVisible(true);
    }
    
    public void limpa(int i)
    {
    	Graphics g;
    	if(i==1) 
		{
    		g = matriz.getGraphics();
    		g.setColor(new Color(200,200,255));
		}
    	else 
    	{
    		g = template.getGraphics();
    		g.setColor(new Color(200,255,200));
    	}    	
    	g.fillRect(0,0, 680, 600);
    }
    
    public void sctCor(int i) {
		if(i==1)this.corM = JColorChooser.showDialog(new JFrame(), "Selecione a cor", corM);
		else this.corP = JColorChooser.showDialog(new JFrame(), "Selecione a cor", corP);
    }
    
    public void desenhaM(Matrix m, int c)
    {
    	Graphics g;
    	if (c==1) g = matriz.getGraphics();
    	else if(c==2) g = template.getGraphics();  
    	else g = Rtd.getGraphics(); 
    	Graphics2D g2 = (Graphics2D) g;
    	g2.setStroke(new BasicStroke(2));
    	int x = m.getH();
    	int y = m.getW();
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
    
    public void desenhaRect(Matrix m, int x)
    {
    	int h = m.getH();
    	int w = m.getW();
    	Graphics g;
    	if(x==1)g = matriz.getGraphics();    	
    	else if(x==2) g = template.getGraphics();
    	else g = Rtd.getGraphics();
    	for(int i=0; i<h; i++)
    	{
    		for(int j=0; j<w; j++)
    		{
    			System.out.println(m.getPixel(i, j).getRed() + " " + m.getPixel(i, j).getGreen() + " " + m.getPixel(i, j).getBlue());
    			g.setColor(m.getPixel(i, j));
    			g.fillRect((10+(i*32)), (10+(j*32)), 32, 32);
    		}
    	}
    	
    	desenhaM(m,x);    	
    }
    
    public void desenhaRtd(Matrix m)
    {
    	System.out.println("desenhaRtf");
    	janelaRtd = new JFrame("26671 - Convolucao - Resultado");	    
	    janelaRtd.setSize(680, 600);
    	janelaRtd.setLayout(null);
    	janelaRtd.add(Rtd);
    	Rtd.setBackground(new Color(255,200,200));
    	Rtd.setSize(new Dimension(680,600));
    	janelaRtd.setVisible(true); 
    	desenhaRect(m,3);
    }
    
    public int getSMX()
    {
    	return sliderMX.getValue();
    }
    public int getSMY()
    {
    	return sliderMY.getValue();
    }
    public int getSPX()
    {
    	return sliderPX.getValue();
    }
    public int getSPY()
    {
    	return sliderPY.getValue();
    }

}
