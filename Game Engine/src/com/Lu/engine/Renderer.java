package com.Lu.engine;

import java.awt.image.DataBufferInt;

import com.Lu.engine.gfx.Image;
import com.Lu.engine.gfx.ImageTile;

public class Renderer
{
	private int pW;
	private int pH;
	private int[] p;
	private int newHeight;
	
	public Renderer (GameContainer gc)
	{
		pW = gc.getWidth();
		pH = gc.getHeight();
		p = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
		
	}
	
	public void clear()
	{
		for(int i = 0; i < p.length; i++)
		{
			p[i] = 0;
		}
	}
	public void setPixel(int x, int y, int value)
	{
		if((x < 0 || x >= pW || y < 0 || y >= pH) || ((value >> 24) & 0xff) == 0)
		{
			return;
		}
		
		p[x + y * pW] = value;
	}
	public void drawImage(Image image, int offX, int offY)
	{
		//Don't Render code
		if(offX < -image.getW()) return;
		if(offY < -image.getH()) return;
		if(offX >= pW) return;
		if(offY>= pH) return;
		
		int newX = 0;
		int newY = 0;
		int newWidth = image.getW();
		int newHeight = image.getH();
		
		//Clipping code
		if(offX < 0) {newX -= offX;}
		if(offY < 0) {newY -= offY;}
		if(newWidth + offX >= pW) {newWidth -= newWidth + offX - pW;}
		if(newHeight + offY>= pH) {newHeight -= newHeight + offY - pH;}
		
		for(int y = 0; y < image.getH(); y++)
		{
			for(int x= 0; x < image.getW(); x++)
			{
				setPixel(x + offX, y + offY, image.getP()[x + y * image.getW()]);
			}
		}
	}

	public void drawImageTile(ImageTile image, int offX, int offY, int tileX, int tileY)
	{
		//Don't Render code
				if(offX < -image.getTileW()) return;
				if(offY < -image.getTileH()) return;
				if(offX >= pW) return;
				if(offY>= pH) return;
				
				int newX = 0;
				int newY = 0;
				int newWidth = image.getTileW();
				int newHeight = image.getTileH();
				
				//Clipping code
				if(offX < 0) {newX -= offX;}
				if(offY < 0) {newY -= offY;}
				if(newWidth + offX >= pW) {newWidth -= newWidth + offX - pW;}
				if(newHeight + offY>= pH) {newHeight -= newHeight + offY - pH;}
				
				for(int y = 0; y < image.getH(); y++)
				{
					for(int x= 0; x < image.getW(); x++)
					{
						setPixel(x + offX, y + offY, image.getP()[(x + tileX * image.getTileW()) + (y + tileX * image.getTileH()) * image.getW()]);
					}
				}
			}
			public void drawRect(int offX, int offY, int width, int height, int color)
			{
				for(int y = 0; y <= width; y++)
				{
				setPixel(offX, y + offY, color);
					setPixel(offX + width, y + offY, color);
				}
				for(int x = 0; x <= width; x++)
				{
					setPixel(x + offX, offY, color);
					setPixel(x + offX, offY + height, color);
				}
			
			}
			
			private int height() {
				// TODO Auto-generated method stub
				return 0;
			}

			private int width() {
				// TODO Auto-generated method stub
				return 0;
			}

			public void drawFillRect(int offX, int offY, int width, int height, int color)
			{
				//Don't Render code
				if(offX < -width()) return;
				if(offY < -height()) return;
				if(offX >= pW) return;
				if(offY>= pH) return;
				
				int newX = 0;
				int newY = 0;
				int newWidth = width;
				int newHeight = height;
				
				//Clipping code
				if(offX < 0) {newX -= offX;}
				if(offY < 0) {newY -= offY;}
				if(newWidth + offX >= pW) {newWidth -= newWidth + offX - pW;}
				if(newHeight + offY>= pH) {newHeight -= newHeight + offY - pH;}
				
				for(int y = newY; y <= newHeight; y++)
				{
					for(int x = newX; x <= newWidth; x++)
					{
						setPixel(x + offX, y + offY, color);
					}
		}
			
				 
	} 
}

			
				
			

	
	