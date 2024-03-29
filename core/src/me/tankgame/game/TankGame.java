package me.tankgame.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.tankgame.game.States.GameStateManager;
import me.tankgame.game.States.MenuState;

public class TankGame extends ApplicationAdapter
{
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;
	public static final String TITLE = "Tank Game";   
	
	private GameStateManager gsm;
	private SpriteBatch batch;
	
	float x;
	float y;
	
	@Override
	public void create () 
	{
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () 
	{
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.end();
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
}
