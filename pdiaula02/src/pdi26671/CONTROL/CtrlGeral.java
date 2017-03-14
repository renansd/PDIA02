package pdi26671.CONTROL;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pdi26671.MODEL.Matrix;
import pdi26671.VIEW.MostraResultado;
import pdi26671.VIEW.ViewTela;



public class CtrlGeral {
	ViewTela view;
	Matrix m;
	Matrix p;
	Matrix c;
	CtrlMatriz cm;
	MostraResultado mr;
	
	public CtrlGeral()
	{
		cm = new CtrlMatriz();
	}
	
	public void view(ViewTela v)
	{
		view = v;
	}
	
	public void pinta(int x, int y, Color c, int i)
	{
		if(i==1)
		{
			m.setPixel(x, y, c);
			view.desenhaRect(m,i);
		}
		else 
		{
			p.setPixel(x, y, c);
			view.desenhaRect(p,i);
		}
		
	}
	
	public class drawM implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			try {
				view.limpa(1);
			}
			catch(Exception e) {
			 System.out.println("Fail");
			}
			finally {
				m = new Matrix(view.getSMX(), view.getSMY());
				view.desenhaRect(m,1);
			}			
		}
	}
	public class drawP implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			try {
				view.limpa(2);
			}
			catch(Exception e) {
			 System.out.println("Fail");
			}
			finally {				
				p = new Matrix(view.getSPX(), view.getSPY());
				view.desenhaRect(p,2);
			}			
		}
	}
	public class corM implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			view.sctCor(1);
		}
	}
	public class corP implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			view.sctCor(2);	
		}
	}
	
	public class conMP implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			c = cm.convolucao(m, p);
			view.desenhaRtd(c);		
		}
	}
}
