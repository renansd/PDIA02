package pdi26671.MODEL;

import java.awt.Color;

public class Matrix {
    private int h, w;
    private Color[][] pixels;
    
    public Matrix(int h, int w) {
		this.h = h;
		this.w = w;
		pixels = new Color[h][w];
		for(int i = 0; i < h; ++i) {
		    for(int j = 0; j < w; ++j) {
		    	pixels[i][j] = new Color(255, 255, 255);
		    }
		}
    }
    
    public Color getPixel(int x, int y) {
    	return this.pixels[x][y];
    }
    
    public void setPixel(int x, int y, Color color) {
		if(x >= 0 && x < this.h && y >= 0 && y < this.w) {
		    pixels[x][y] = color;
		}
    }
    
    public int getH()
    {
    	return h;
    }
    public int getW()
    {
    	return w;
    }
}
