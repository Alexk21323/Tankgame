package me.tankgame.game.States;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.tankgame.game.TankGame;

public class MenuState extends State 
{
	private Texture background;
	private Texture playBtn;
	
	public MenuState(GameStateManager gsm)
	{
		super(gsm);
		background = new Texture("background.jpg");
		playBtn = new Texture("PlayButton.jpg");
		// TODO Auto-generated constructor stub
	}


	@Override
	public void handleInput() 
	{
		// TODO Auto-generated method stub
		if(Gdx.input.justTouched())
		{
			gsm.set(new PlayState(gsm));
			dispose();
		}
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		handleInput();
		
	}

	@Override
	public void render(SpriteBatch sb)
	{
		// TODO Auto-generated method stub
		sb.begin();
		sb.draw(background, 0,0, TankGame.WIDTH, TankGame.HEIGHT);
		sb.draw(playBtn, (TankGame.WIDTH/2) - (playBtn.getWidth()/2), TankGame.HEIGHT/2 -40);
		sb.end();
	}

	@Override
	public void dispose() 
	{
		// TODO Auto-generated method stub
		background.dispose();
		playBtn.dispose();
	}
	
}
