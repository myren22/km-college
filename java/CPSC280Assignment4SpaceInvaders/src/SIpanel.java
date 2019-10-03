import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import java.awt.event.KeyListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import java.util.ArrayList;

//Kyle Myren and Nick Kirschke
import javax.swing.Timer;

//inherits from JPanel, actionlistenr, and keylistener

//takes from... Timer, SImissile, SIbase, SIinvader(which takes SImystery, SItop, SImiddle, SIbottom)

public class SIpanel extends JPanel {
	private JPanel panel;
	private Timer timer;
	private SIbase base;
	private SItop top0, top1, top2, top3, top4, top5, top6, top7, top8, top9;
	private SImiddle mid00, mid01, mid02, mid03, mid04, mid05, mid06, mid07,
			mid08, mid09, mid10, mid11, mid12, mid13, mid14, mid15, mid16,
			mid17, mid18, mid19;
	private SIbottom bot00, bot01, bot02, bot03, bot04, bot05, bot06, bot07,
			bot08, bot09, bot10, bot11, bot12, bot13, bot14, bot15, bot16,
			bot17, bot18, bot19;

	private int pulse, scorePoints;
	private boolean rightWards, gameOver;
	// 4 missiles. 1 player, 3 invader
	private SImissile baseMissile, inv1miss, inv2miss, inv3miss;
	private Font font;

	// 50 invaders in a block + 1 mystery ship
	private SImystery mysteryShip;
	private SIinvader[][] invaderBlock;
	

	public SIpanel(Timer timer) {

		panel = new JPanel();
		setBackground(Color.BLACK);
		setFocusable(true);
		gameOver = true;
		
		this.timer = timer;

		// initialize base
		base = new SIbase();
		rightWards = true;
		scorePoints = 0;
		// positioning. top row is 80 pixels down. each row after is 25 more.
		// horizontal spacing 35 pixels. 247 center
		// initialize individual invaders
		// top 10.
		top0 = new SItop(72, 80);
		top1 = new SItop(107, 80);
		top2 = new SItop(142, 80);
		top3 = new SItop(177, 80);
		top4 = new SItop(212, 80);
		top5 = new SItop(247, 80);
		top6 = new SItop(282, 80);
		top7 = new SItop(317, 80);
		top8 = new SItop(352, 80);
		top9 = new SItop(387, 80);
		// middle 20
		mid00 = new SImiddle(72, 105);
		mid01 = new SImiddle(107, 105);
		mid02 = new SImiddle(142, 105);
		mid03 = new SImiddle(177, 105);
		mid04 = new SImiddle(212, 105);
		mid05 = new SImiddle(247, 105);
		mid06 = new SImiddle(282, 105);
		mid07 = new SImiddle(317, 105);
		mid08 = new SImiddle(352, 105);
		mid09 = new SImiddle(387, 105);
		mid10 = new SImiddle(72, 130);
		mid11 = new SImiddle(107, 130);
		mid12 = new SImiddle(142, 130);
		mid13 = new SImiddle(177, 130);
		mid14 = new SImiddle(212, 130);
		mid15 = new SImiddle(247, 130);
		mid16 = new SImiddle(282, 130);
		mid17 = new SImiddle(317, 130);
		mid18 = new SImiddle(352, 130);
		mid19 = new SImiddle(387, 130);
		// bottom 20
		bot00 = new SIbottom(72, 155);
		bot01 = new SIbottom(107, 155);
		bot02 = new SIbottom(142, 155);
		bot03 = new SIbottom(177, 155);
		bot04 = new SIbottom(212, 155);
		bot05 = new SIbottom(247, 155);
		bot06 = new SIbottom(282, 155);
		bot07 = new SIbottom(317, 155);
		bot08 = new SIbottom(352, 155);
		bot09 = new SIbottom(387, 155);
		bot10 = new SIbottom(72, 180);
		bot11 = new SIbottom(107, 180);
		bot12 = new SIbottom(142, 180);
		bot13 = new SIbottom(177, 180);
		bot14 = new SIbottom(212, 180);
		bot15 = new SIbottom(247, 180);
		bot16 = new SIbottom(282, 180);
		bot17 = new SIbottom(317, 180);
		bot18 = new SIbottom(352, 180);
		bot19 = new SIbottom(387, 180);

		mysteryShip = new SImystery(50, 50);
		// initialize Invaders block. height 5, width 10.
		invaderBlock = new SIinvader[][] {
				{ top0, top1, top2, top3, top4, top5, top6, top7, top8, top9 },
				{ mid00, mid01, mid02, mid03, mid04, mid05, mid06, mid07,
						mid08, mid09 },
				{ mid10, mid11, mid12, mid13, mid14, mid15, mid16, mid17,
						mid18, mid19 },
				{ bot00, bot01, bot02, bot03, bot04, bot05, bot06, bot07,
						bot08, bot09 },
				{ bot10, bot11, bot12, bot13, bot14, bot15, bot16, bot17,
						bot18, bot19 } };

		// initialize missiles
		baseMissile = new SImissile(600, 600, true);
		inv1miss = new SImissile(600, 600, false);
		inv1miss.setActive(false);
		inv2miss = new SImissile(600, 600, false);
		inv2miss.setActive(false);
		inv3miss = new SImissile(600, 600, false);
		inv3miss.setActive(false);

		// There is a problem with the timer probably, one thing I don't
		// understand that well
		int pulse = 1;
		// timer = new Timer(10, new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// // TODO Auto-generated method stub
		// updateGame();
		//
		// }
		// });
		// timer.start();

		// keyboard listeners
		addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				// cases for space bar, left arrow, and right arrow
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					// move base left
					if (base.getX() <= 4) {
						break;
					}
					base.setX(base.getX() - 5);
					break;
				case KeyEvent.VK_RIGHT:
					// move base right
					if (base.getX() >= 465) {// actual panel width is 494. minus
												// 26 = 468.
						break;
					}
					base.setX(base.getX() + 5);
					break;
				case KeyEvent.VK_SPACE:
					// Fire a missile. only 1 missile can be fired at a time.
					// check here or somewhere
					if (baseMissile.isActive() == false) {
						base.missileShot();
						baseMissile.launch(base.getX() + 12, base.getY() - 11,
								true);
						gameOver = false;
					}
					break;
				}

			}

			public void keyReleased(KeyEvent e) {
				// Not needed
			}

			public void keyTyped(KeyEvent e) {
				repaint();
			}
		});

		font = new Font("Arial", Font.BOLD, 13);

	}

	public void updateGame() {
		if(!gameOver){
			
		
			pulse++;
	
			
	
			if (mysteryShip.isActive()) {
				if (mysteryShip.contains(baseMissile.getX(), baseMissile.getY())) {
					mysteryShip.setHit(true);
					baseMissile.reset();
				}
			}
			// invaders hit by player
			for (int row = 0; row < 5; row++) {
				for (int col = 0; col < 10; col++) {
					if (invaderBlock[row][col].isActive()) {
						boolean hit = invaderBlock[row][col].contains(
								baseMissile.getX(), baseMissile.getY());
	
						if (hit) {
							// update score
							// call destroyed method
							// set invader to inactive
							System.out.println("was hit");
							invaderBlock[row][col].setHit(true);
							invaderBlock[row][col].playDestroyed();
							scorePoints = scorePoints + invaderBlock[row][col].getPoints();
							scorePoints = scorePoints
									+ invaderBlock[row][col].getPoints();
	
							baseMissile.reset();
						}
					}
				}
			}
			// player hit by invaders
	
			if (inv1miss.isActive()) {
				boolean hit = base.contains(inv1miss.getX(), inv1miss.getY());
				if (hit) {
					System.out.println("base was hit");
					base.setHit(true);
				}
			}
			if(inv2miss.isActive()){
				boolean hit = base.contains(inv2miss.getX(), inv2miss.getY());
				if(hit){
					System.out.println("base was hit");
					base.setHit(true);
				}
			}
			if(inv3miss.isActive()){
				boolean hit = base.contains(inv3miss.getX(), inv3miss.getY());
				if(hit){
					System.out.println("base was hit");
					base.playDestroyed();
					base.setHit(true);
				}
			}
			// check collisions(ships or out of screen)
			// explode ships
			// remove missile
			// increment points
	
			// missiles:
			// shoot invader missiles
	
			if (!(inv1miss.isActive() && inv2miss.isActive() && inv3miss.isActive())) {
	
				
				if(Math.random()<.8){
					//cycle through lowest
	
				boolean shoots = false;
				if (Math.random() > .997) {
					// cycle through lowest
	
					ArrayList<SIinvader> botShooters = new ArrayList<SIinvader>();
					for (int col = 0; col < 10; col++) {
						for (int row = 4; row >= 0; row--) {
							if (invaderBlock[row][col].isActive()) {
								botShooters.add(invaderBlock[row][col]);
								break;
							}
						}
					}
	
					int chosenShooter = (int) (Math.random()*botShooters.size());
					if(!inv1miss.isActive()){
						inv1miss.launch(botShooters.get(chosenShooter).getX()+15, 
								botShooters.get(chosenShooter).getY()+26,
								false);
					} else if(!inv2miss.isActive()){
						inv2miss.launch(botShooters.get(chosenShooter).getX()+15, 
								botShooters.get(chosenShooter).getY()+26,
								false);
					}else if((!inv3miss.isActive())){
						inv3miss.launch(botShooters.get(chosenShooter).getX()+15, 
								botShooters.get(chosenShooter).getY()+26,
								false);
					}
					
	
				}
			}
	
	//		if(inv1miss.isActive()){
	//			System.out.println("is active");
	//		}
	
			if (inv1miss.isActive()) {
				System.out.println("is active");
			}
	
			// base missiles move every pulse
			// invader every other pulse
			baseMissile.update();
			if(pulse%2==0){
				inv1miss.update();
				inv2miss.update();
				inv3miss.update();
			}
			
	
			// check whether invaders can move
			// invaders check movement, move left or right
			if (rightWards) {
				for (int c = 9; c >= 0; c--) {
					for (int r = 0; r < 5; r++) {
						if (invaderBlock[r][c].isActive()) {
							if (invaderBlock[r][c].getX()
									+ invaderBlock[r][c].getWidth() + 5 >= 494) {
								for (int row = 0; row < 5; row++) {
									for (int col = 0; col < 10; col++) {
										invaderBlock[row][col].edgeCollision();
									}
								}
								rightWards = false;
								break;
	
							}
						}
					}
					if (rightWards == false) {
						break;
					}
				}
			} else {
				for (int c = 0; c < 10; c++) {
					for (int r = 0; r < 5; r++) {
						if (invaderBlock[r][c].isActive()) {
							if (invaderBlock[r][c].getX() - 5 <= 0) {
								for (int row = 0; row < 5; row++) {
									for (int col = 0; col < 10; col++) {
										invaderBlock[row][col].edgeCollision();
									}
								}
								rightWards = true;
								break;
							}
						}
					}
					if (rightWards == true) {
						break;
					}
				}
			}
			// invaders flip graphic every pulse
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 10; c++) {
					invaderBlock[r][c].updatePosition();
				}
			}
	
			// do invaders shoot missiles from new or past position?
			// do mystery ships affect the edge speed altering count?
	
			// move base
			repaint();
				
			}
		}
		
		
	}

	private int getStringPixelWidth(String s) {
		AffineTransform at = new AffineTransform();
		FontRenderContext frc = new FontRenderContext(at, true, true);
		return (int) (font.getStringBounds(s, frc).getWidth());
	}

	public void startGame() {
		gameOver = false;

		inv1miss.reset();
		inv2miss.reset();
		inv3miss.reset();
		base.reset();
		scorePoints = 0;
		

		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 10; col++) {
				invaderBlock[row][col].setX(col * 35 + 72);
				invaderBlock[row][col].setY(row * 25 + 80);

				invaderBlock[row][col].setActive(true);
				invaderBlock[row][col].setHit(false);
			}
		}
		// timer.start();
	}

	public void endGame() {
		gameOver = true;
//		timer.stop();

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform oldXForm = g2d.getTransform();
		
		if(mysteryShip.isActive() && mysteryShip.isHit()) {
			mysteryShip.drawDestroyed(g);
			mysteryShip.setActive(false);
			} else if (!mysteryShip.isActive()){
			} else {
			mysteryShip.draw(g);
			}
		
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 10; c++) {
				if (invaderBlock[r][c].isHit() && invaderBlock[r][c].isActive()) {
					invaderBlock[r][c].drawDestroyed(g);
					invaderBlock[r][c].setActive(false);
				} else if (!invaderBlock[r][c].isActive()) {

				} else {
					invaderBlock[r][c].draw(g);
				}

			}
		}
		if(base.isHit()){
			base.drawDestroyed(g);
			endGame();
		}
		else{
			base.draw(g);
		}

		g2d.setColor(Color.GREEN);
		g2d.scale(3, 3);
		g2d.setFont(font);
		if (gameOver) {
			g2d.drawString("Game Over", 52, 90);
		}
		g2d.setTransform(oldXForm);

		// get int to string.
		// poistion at: 494 -- (((int to string)+(":Score: " ) to character
		// pixel distance)

		String scoreString = "score:";
		int width = getStringPixelWidth(scoreString + scorePoints);
		g2d.drawString(scoreString + scorePoints, 494 - width, 12);
		baseMissile.draw(g);
		inv1miss.draw(g);
		inv2miss.draw(g);
		inv3miss.draw(g);
		// for key test
	}

	// set score to 0

	// initialize laser base and a wave of invaders

	// create a timer - that generates ActionEvents ever 10ms
	// the "pulse" of the game, invoke actionPerfomed that checks whether...
	// any ships should or have been hit, have missiles been fired or gone
	// outside screen
	//
	//
}
