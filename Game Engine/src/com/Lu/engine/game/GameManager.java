package com.Lu.engine.game;

import java.awt.event.KeyEvent;

import com.Lu.engine.AbstractGame;
import com.Lu.engine.GameContainer;
import com.Lu.engine.Renderer;
import com.Lu.engine.audio.SoundClip;
import com.Lu.engine.gfx.Image;
import com.Lu.engine.gfx.ImageTile;

public class GameManager extends AbstractGame
{
	
	private Image image;
	private SoundClip clip;
	public GameManager()
	{
		image = new ImageTile("/text.png", 16, 16);
		clip = new SoundClip ("/Audio/Recording.m4a");
		
	}
	
	@Override
	public void update(GameContainer gc, float dt) 
	{
		if(gc.getInput().iskeyDown(KeyEvent.VK_0))
		{
			clip.play();
		}
		
		temp += dt;
		
		if(temp > 3)
		{
			temp = 0;
		}
	}
		
	float temp = 0;

	@Override
	public void render(GameContainer gc, Renderer r) 
	{
		r.drawFillRect(gc.getInput().getMouseX() -100, gc.getInput().getMouseY() -100, 400, 400, 0xffffccff);
		
		
	}
	public static void main(String args[])
	{
		GameContainer gc = new GameContainer(new GameManager()); 
		gc.setWidth(320);
		gc.setHeight(240);
		gc.setScale(3f);
		gc.start(); 
		
	} 
	

}
