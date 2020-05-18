package com.Lu.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Input implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener
{
	
	private static final int NUM_buttoms = 0;
	private GameContainer gc;
	private final int NUM_KEYS = 256;
	private boolean[] keys = new boolean[NUM_KEYS];
	private boolean[] keysLast = new boolean[NUM_KEYS];
	
	private final int NUM_BUTTON = 5;
	private boolean[] buttons = new boolean[NUM_KEYS];
	private boolean[] buttonsLast = new boolean[NUM_KEYS];
	
	private int mouseX, mouseY;
	private int scroll;
	
	public Input(GameContainer gc)
	{
		this.gc = gc;
		mouseX = 0;
		mouseY = 0;
		scroll = 0;
		
		gc.getWindow().getCanvas().addKeyListener(this);
		gc.getWindow().getCanvas().addMouseListener(this);
		gc.getWindow().getCanvas().addMouseMotionListener(this);
		gc.getWindow().getCanvas().addMouseWheelListener(this);
}
	
		// TODO Auto-generated constructor stub

	public void update()
	{
		for(int i = 0; i < NUM_KEYS; i++)
		keysLast[i] = keys[1];
		
		for(int i = 0; i < NUM_BUTTON; i++)
		buttonsLast[i] = buttons[1];
	}
	
	public boolean isKey(int keyCode)
	{
		return keys[keyCode]; 
	}
	
	public boolean iskeyUp(int keyCode)
	{
		return !keys[keyCode] && keysLast[keyCode];
	}
	public boolean iskeyDown(int keyCode)
	{
		return keys[keyCode] && !keysLast[keyCode];
	}
	
	
	public boolean isButton(int button)
	{
		return buttons[button]; 
	}
	
	public boolean isButtonUp(int button)
	{
		return !buttons[button] && buttonsLast[button];
	}
	public boolean isButtonDown(int button)
	{
		return buttons[button] && !buttonsLast[button];
	}
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		buttons[e.getButton()] = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		buttons[e.getButton()] = false;
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) 
	{
		scroll = e.getWheelRotation();
		
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{
		mouseX = (int) (e.getX() / gc.getScale());
		mouseY = (int) (e.getY() / gc.getScale());
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) 
	{
		mouseX = (int) (e.getX() / gc.getScale());
		mouseY = (int) (e.getY() / gc.getScale());
		
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		keys[e.getKeyCode()] = false;
		
	}
	/**
	 * @return the mouseX
	 */
	public int getMouseX() {
		return mouseX;
	}
	/**
	 * @return the mouseY
	 */
	public int getMouseY() {
		return mouseY;
	}
	/**
	 * @return the scroll
	 */
	public int getScroll() {
		return scroll;
	}
}
