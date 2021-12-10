package me.tankgame.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Wall {

	private Texture wall;
	private Vector2 position;
	
	
	public Wall(int x , int y)
	{
		wall = new Texture("barricadeWood.png");
		position = new Vector2(x,y);
	}
	
	public Texture getTexture()
	{
		return wall;
	}
	
	public Vector2 getPosition()
	{
		return position;
	}
}
