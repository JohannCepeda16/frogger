package aplicacion;

import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import presentacion.Assets;

public class PlayerNormal extends Player{
	
	public PlayerNormal(int x, int y, int player, BufferedImage sprite) {
		super(x, y, player, sprite);
		isTrigger = true;
	}

	@Override
	public void Move() {
		//Check Limits
		if(x<0 || x>750 || y<=40 || y> 600) {
			Dead();
		}
		
		if(player == 1) {		
			if(EventosKeyboard.up && getY() > 50){
				OnCollisionExit();
				this.score +=10;
				this.y -= speedY;
				EventosKeyboard.up = false;
			}
			else if(EventosKeyboard.down && getY() < 450) {
				OnCollisionExit();
				this.y += speedY;
				EventosKeyboard.down = false;
			}
			else if(EventosKeyboard.left && getX() > 25) {
				OnCollisionExit();
				this.x -= speedX;
				EventosKeyboard.left = false;
			}
			else if(EventosKeyboard.rigth && getX() < 730) {
				OnCollisionExit();
				this.x += speedX;
				EventosKeyboard.rigth = false;
			}
		}
		else if(player == 2) {
			if(EventosKeyboard.upArrow && getY() > 50){
				OnCollisionExit();
				this.score +=10;
				this.y -= speedY;
				EventosKeyboard.upArrow = false;
			}
			else if(EventosKeyboard.downArrow && getY() < 450) {
				OnCollisionExit();
				this.y += speedY;
				EventosKeyboard.downArrow = false;
			}
			else if(EventosKeyboard.leftArrow && getX() > 25) {
				OnCollisionExit();
				this.x -= speedX;
				EventosKeyboard.leftArrow = false;
			}
			else if(EventosKeyboard.rigthArrow && getX() < 730) {
				OnCollisionExit();
				this.x += speedX;
				EventosKeyboard.rigthArrow = false;
			}
		}
		
		for(Collisionable i: FroggerManager.collisionables) {
			if(Collision(i.getCollider())) {
				OnCollisionEnter(i);
			}
		}
	}
	
	@Override
	public void OnCollisionEnter(Collisionable collision) {
		collision.ActivateTrigger(this);
	}
	
	@Override
	public void makePoint(int bonus) {
		super.score +=50 + bonus;
		FroggerManager.getInstance().CheckWin();
		resetPosition();
	}

	@Override
	public void Dead() {
		sprite = Assets.playerDead;
		isTrigger = false;
		lives--;
		score -= score-100>0 ? 100 : score;
		resetPosition();
	}

}
