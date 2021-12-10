package me.tankgame.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet 
{	
	public static final int Speed = 500;
	private static Texture bullet;
	
	float x, y;

	public boolean remove = false;
	
	public Bullet(float x, float y)
	{
		this.x = x;
		this.y = y;
		
		bullet = new Texture("bulletGreen2_outline.png");
	}
	
	public void update(float dt)
	{
		y += Speed * dt;
		if(y > Gdx.graphics.getHeight())
			remove = true;
	}
	
	public void render (SpriteBatch batch)
	{
		batch.draw(bullet, x, y);
	}
}
