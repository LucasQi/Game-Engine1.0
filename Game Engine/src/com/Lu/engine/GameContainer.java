package com.Lu.engine;

public class GameContainer implements Runnable
{
	private Thread thread;
	private Window window;
	
	private boolean running = false;
	private final  double UPDATE_CAP = 1.0/60.0;
	private int width = 320, height = 240;
	private float scale = 1f;
	private String title = "Game Engine v1.0";
	

	private double passTime;

	private int fps;

	private double firsTime;
	
	public GameContainer()
	{
		}
	public void start()
	{
		window = new Window(this);
		thread = new Thread(this);
		thread.run();
	}
	public void stop()
	{
	
	}
	public void run()
	{
			running = true;
		boolean render = false;
		double firstTime = 0;
		double lastTime = System.nanoTime() / 100000000.0;
		passTime = 0;
		double unprocessedTime = 0;
		
		double frameTime = 0;
		int frames = 0;
		fps = 0;
		

		while(running)
		{
			render = false;
			firsTime = System.nanoTime() / 1000000000.0;
			double passedTime = firstTime - lastTime;
			lastTime = firstTime;
			
			unprocessedTime += passedTime;
			frameTime += passedTime;
			
			while(unprocessedTime >= UPDATE_CAP)
			{
				unprocessedTime -= UPDATE_CAP;
				render = true;
				//TODO: Update game
						if(frameTime >= 1.0)
						{
								frameTime = 0;
								fps = frames;
								frames = 0;
								System.out.println("FPS: ");
						}
			}

			if(render)
			{
					//TODO: RENDER game
				window.update();
				frames++;
			}
			else
			{
				try
				{
					Thread.sleep(1);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
			dispose();
}
	private void dispose()
	{
			
	}

	public static void main(String args[])
	{
			GameContainer gc = new GameContainer();
			gc.start();
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * @return the scale
	 */
	public float getScale() {
		return scale;
	}
	/**
	 * @param scale the scale to set
	 */
	public void setScale(float scale) {
		this.scale = scale;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}
