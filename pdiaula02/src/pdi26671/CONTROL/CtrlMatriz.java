package pdi26671.CONTROL;

import java.awt.Color;

import pdi26671.MODEL.Matrix;

public class CtrlMatriz {
	
	public Matrix convolucao(Matrix m, Matrix p)
	{
		System.out.println("CtrlMatriz");
		Matrix rtd = new Matrix(m.getH(), m.getW());
		int mh = m.getH();
		int mw = m.getW();
		int ph = p.getH();
		int pw = p.getW();
		int dif = (mh-1)/2;
		int posx;
		int posy;
		int posax;
		int posay;		
		int[][] r = new int[m.getH()][m.getW()];
		int[][] g = new int[m.getH()][m.getW()];
		int[][] b = new int[m.getH()][m.getW()];
		
		for(int i=0; i<mh; i++)
		{
			for(int j=0; j<mw; j++)
			{
				posy=0-dif;				
				for(int k=0; k<ph; k++)
				{
					posx=0-dif;
					for(int l=0; l<pw; l++)
					{
						posax = i+posx;
						posay = j+posy;
						if(posax >= 0 && posay >= 0 && posax<mh && posay<mw)
						{
							r[i][j] += m.getPixel(posax, posay).getRed() * p.getPixel(k, l).getRed();
							g[i][j] += m.getPixel(posax, posay).getGreen() * p.getPixel(k, l).getGreen();
							b[i][j] += m.getPixel(posax, posay).getBlue() * p.getPixel(k, l).getBlue();							
						}
						posx++;
					}
					posy++;
				}
			}
		}
		
		r = normaliza(r);
		g = normaliza(g);
		b = normaliza(b);
		
		for(int i = 0; i < rtd.getH(); ++i) {
		    for(int j = 0; j < rtd.getW(); ++j) {
		    	rtd.setPixel(i, j, new Color(r[i][j], g[i][j], b[i][j]));
		    }
		}
		return rtd;		
	}
	
	private int[][] normaliza(int m[][])
	{
		int max = m[0][0], min = m[0][0];
		for(int i = 0; i < m.length; ++i) {
		    for(int j = 0; j < m[i].length; ++j) {
				max = Math.max(max, m[i][j]);
				min = Math.min(min, m[i][j]);
		    }
		}
		for(int i = 0; i < m.length; ++i) {
		    for(int j = 0; j < m[i].length; ++j) {
		    	m[i][j] = (int)Math.round((255.0 * (m[i][j] - min)) / (max - min));
		    }
		}
		return m;			
	}
}
