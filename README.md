# Tankgame
Configuration:

The folder “TankgGame” is a Gradle folder. To implement it, has has to use -> import -> Existing Gradle project -> TankGame -> finish. 









Before launched user must change the asset directory. TankGame-desktop -> src -> me.tankgame.game.desktop -> DesktopLauncher.java and chose run configuration. Go to Argument-> working directory-> working directory -> workplace -> Tankgame-desktop/assets.
(May need to download itch.io to edit the map.  https://www.mapeditor.org/)





The game can be launched by running TankGame-desktop -> src -> me.tankgame.game.desktop -> DesktopLauncher.java Run as Java Application. 







User Control: 
The game with start with a user menu, user can click the start button and it will take the user to the play screen. Player controls the “green tank” and Enemies are the “red tanks”. Player can move with “arrow key” and fire cannon with “space bar”.  The game is end when Player’s HP reach 0 or when player destroy enemy base.  User can restart the game by “clicking on the game over screen”. The game is made with a little difficulty, user can press “x” to gain 999 HP and double the movement speed to finish the game. 

Program design and implementation:
---------------------------------------------------------------------------------------------------------------------
The games has 3 main category of classes. 
Sprites Package: (Objects that exist on the map)

Base class: Enemy base that exist on the other side of the map, if collides with player’s bullet, the game will end.

Bullet class: Player Bullet that will load into the map when player attack. It will destroy Enemies if collides. It will destroy it self when collide with wall.  

Bullet2 class: Enemy Bullet that does the same thing as bullet but damage player instead.

Enemy Tank class: Enemy tank  Are there to protect their base. If they detect the player 
they will shoot and them and chase the player around. When they bump into a wall or
with each other they will change direction. 

Player Tank class: Controlled by player into. Press space the generate bullet and move around with arrow keys. Has a HP label on top of it. It will die when HP reach 0 and the game will end.

Wall class: Static bodies that act as a terrain when interact with player and enemy tank. It will destroy bullets when bullets collide. 

States (Or can be understand as screens) : 
GameState manager class: It use a stack to manage the game states. And it will render at the top states in stack.

EndState class: It display a game over background at the position of camera. Click on it to restart the game.

Menu State class: It display a background and a play button. Click the play Button to render play state.

PlayState class: This states render all the Sprites class and generate collision bodies for each of them. Will updates them during runtime.

State class: A abstract class that to implement the default function of all other state class. 

World ContactListener class: Implemented in a World object. It will return the bodies that have contact. Call function to those bodies accordingly. 

TankGame class: Engine class to render the screen. 
---------------------------------------------------------------------------------------------------------------------

Line Count: 1240 ish lines. 

---------------------------------------------------------------------------------------------------------------------
Bugs:

So far haven't find any runtime error, but there are logical error. Because I set the enemy bullets slower to make the game playable but it time to time it will collide with its tank body and they will move slower. Enemy tanks know how to react to walls but not when they have detected player. They will want to move to the player’s direction despite the  wall. 

Unimplemented features: Not multiple levels only one level. Only one type of weapon, no drops to upgrade.  
