package pdi26671.CONTROL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pdi26671.MODEL.Matrix;
import pdi26671.VIEW.ViewTela;



public class CtrlGeral {
	ViewTela view;
	Matrix m;
	
	public CtrlGeral()
	{
		
	}
	
	public void view(ViewTela v)
	{
		view = v;
	}
	
	public class drawM implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("hey oh");
			try {
				view.limpa();
			}
			catch(Exception e) {
			 System.out.println("Fail");
			}
			finally {
				view.desenhaM();
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
}
