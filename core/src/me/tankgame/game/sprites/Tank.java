package me.tankgame.game.sprites;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import me.tankgame.game.sprites.Bullet;

public class Tank 
{
	private Vector2 position;
	private Vector2 velocity;
	private Texture tank;
	private Sprite spriteTank;
	private int Speed = 60;
	private boolean lookDirection;
	private Rectangle bounds;
	
	static ArrayList<Bullet> bullets;
	
	public Tank(int x, int y)
	{
		position = new Vector2(x, y );
		velocity = new Vector2(0, 0 );
		
		lookDirection = true;
		tank = new Texture("tank_green.png");
		spriteTank = new Sprite(tank);
		spriteTank.setOriginCenter();
		spriteTank.flip(false, true);
		
		bullets = new ArrayList<Bullet>();
		
		bounds = new Rectangle(x,y, tank.getWidth(), tank.getHeight());
	}
	
	public void update(float dt)
	{
		handleInput();
		velocity.scl(dt);
		position.add(velocity.x, velocity.y);
		
		velocity.scl(1/dt);
		
		//update Bullets
		ArrayList<Bullet> bulletsToRemove = new ArrayList<Bullet>();
		for (Bullet bullet : bullets)
		{
			bullet.update(dt);
			if(bullet.remove == true )
			{
				bulletsToRemove.add(bullet);
			}
		}
		bullets.removeAll(bulletsToRemove);
		
		bounds.setPosition(position.x, position.y);
		
//		if(lookDirection == false)
//		{
//			spriteTank.flip(false, false);
//		}
//		else
//		{
//			spriteTank.flip(false, true);
//		}
	}
	
	protected void handleInput()
	{
		//shooting code 
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
		{
			bullets.add(new Bullet(position.x+15, position.y+30));
		}
		
		//Moving code
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
		{
			velocity.x = Speed; 
		}
		
		else if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
		{
			velocity.x = -Speed;
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.UP))
		{
			velocity.y = Speed;
			
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
		{
			velocity.y = -Speed;
			lookDirection = false;
		}
		else 
		{
			velocity.x =0;
			velocity.y =0;
		}
	}
	
	public Vector2 getPosition()
	{
		return position;
	}
	
	public Texture getTexture()
	{
		return tank;
	}
	
	public Sprite getSprite()
	{
		return spriteTank;
	}
	
	public static ArrayList<Bullet> getBullet()
	{
		return bullets;
	}
	
	public Rectangle getBounds()
	{
		return bounds;
	}
}
