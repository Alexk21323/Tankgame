package me.tankgame.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import me.tankgame.game.TankGame;
import me.tankgame.game.sprites.Bullet;
import me.tankgame.game.sprites.Tank;
import me.tankgame.game.sprites.Wall;

public class PlayState extends State 
{
	private Tank tank;
	private Texture bg;
	private Wall wall;
	
	private Array<Wall> walls;
	
	protected PlayState(GameStateManager gsm) 
	{
		super(gsm);
		tank = new Tank(50,100);
		wall = new Wall(100, 100);	
		bg = new Texture("background_mud.jpg");
		cam.setToOrtho(false, TankGame.WIDTH/2, TankGame.HEIGHT/2);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handleInput() 
	{
		// TODO Auto-generated method stub
	}
	
	@Override
	public void update(float dt)
	{
		// TODO Auto-generated method stub
		handleInput();
		tank.update(dt);
		cam.position.x = tank.getPosition().x +30;
		cam.position.y = tank.getPosition().y +80;
		cam.update();
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		// TODO Auto-generated method stub
		sb.setProjectionMatrix(cam.combined);
		sb.begin();
		sb.draw(bg, 0 ,0 );
		sb.draw(wall.getTexture(), wall.getPosition().x, wall.getPosition().y);
		sb.draw(tank.getSprite(), tank.getPosition().x, tank.getPosition().y);
		for (Bullet bullet: Tank.getBullet())
		{
			bullet.render(sb);
		}
		sb.end();
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
