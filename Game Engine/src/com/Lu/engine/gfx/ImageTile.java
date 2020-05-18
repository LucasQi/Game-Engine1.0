package com.Lu.engine.gfx;

public class ImageTile extends Image
{
	private int tileW, tileH;
	
	public ImageTile(String path, int tileW, int tileH)
	{
		super(path);
		this.tileW = tileW;
		this.tileH = tileH;
	}
 
	/**
	 * @return the tileW
	 */
	public int getTileW() {
		return tileW;
	}

	/**
	 * @param tileW the tileW to set
	 */
	public void setTileW(int tileW) {
		this.tileW = tileW;
	}
 
	/**
	 * @return the tileH
	 */
	public int getTileH() {
		return tileH;
	}

	/**
	 * @param tileH the tileH to set
	 */
	public void setTileH(int tileH) {
		this.tileH = tileH;
	}
}
