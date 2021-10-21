
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;

public class Mainpanel extends JPanel implements ActionListener, ComponentListener, KeyListener {
	private Boll minBoll;
	private drawrect minBat;
	private int oldX = -1;
	private int oldY = -1;
	private JFrame myFrame;
	private Brick[][] bricks = new Brick[20][20];
	private JLabel scoreBoard;
	private JLabel scoreBoard1;
	int score;
	int life = 3;
	int antalbrickor = 64;
	Timer t;

	public Mainpanel(JFrame parentC) {

		t = new Timer(10, this);
		minBoll = new Boll(350, 400, 15, 15, Color.BLUE);
		minBat = new drawrect(320, 430, 75, 10, Color.BLUE);
		myFrame = parentC;
		this.requestFocusInWindow();
		this.setFocusable(true);
		this.grabFocus(); // Ser till att alla tecken hamnar i det här fönstret
		scoreBoard = new JLabel("Score: " + score);
		scoreBoard1 = new JLabel("Life: " + life);
		scoreBoard.setForeground(Color.BLACK);
		scoreBoard1.setForeground(Color.BLACK);
		scoreBoard.setHorizontalAlignment(JLabel.LEFT);
		scoreBoard1.setHorizontalAlignment(JLabel.LEFT);
		myFrame.add(scoreBoard, BorderLayout.SOUTH);
		myFrame.add(scoreBoard1, BorderLayout.NORTH);
		this.addKeyListener(this);

		int k = 1;
		int z = 1;
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 8; i++) {
				if (i < 1) {
					Brick brick = new Brick(14 * k + 10, 54 * z - 20, 45, 9, Color.cyan);
					bricks[j][i] = brick;
				} else if (1 <= i && i < 2) {
					Brick brick = new Brick(16 * k + 10, 54 * z - 20, 45, 9, Color.orange);
					bricks[j][i] = brick;
				} else if (2 <= i && i < 3) {
					Brick brick = new Brick(16 * k + 10, 54 * z - 20, 45, 9, Color.YELLOW);
					bricks[j][i] = brick;
				} else if (3 <= i && i < 4) {
					Brick brick = new Brick(16 * k + 10, 54 * z - 20, 45, 9, Color.RED);
					bricks[j][i] = brick;
				} else if (4 <= i && i < 5) {
					Brick brick = new Brick(17 * k + 10, 54 * z - 20, 45, 9, Color.orange);
					bricks[j][i] = brick;
				} else if (5 <= i && i < 6) {
					Brick brick = new Brick(17 * k + 10, 54 * z - 20, 45, 9, Color.YELLOW);
					bricks[j][i] = brick;
				} else if (6 <= i && i < 7) {
					Brick brick = new Brick(17 * k + 10, 54 * z - 20, 45, 9, Color.GREEN);
					bricks[j][i] = brick;
				} else if (7 <= i && i < 8) {
					Brick brick = new Brick(17 * k + 10, 54 * z - 20, 45, 9, Color.CYAN);
					bricks[j][i] = brick;
				}
				k += 5;
			}
			k = 1;
			z += 1;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		minBoll.paintComponent(g);
		minBat.paintComponent(g);
		scoreBoard.paintComponents(g);
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 8; i++) {
				bricks[j][i].paintComponent(g);

			}

		}
		if (life == 0) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Courier New", Font.BOLD, 50));
			g.drawString("Game over!", 200, 200);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Courier New", Font.BOLD, 20));
			g.drawString("Score: " + score, 300, 230);

		} else if (antalbrickor == 0) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Courier New", Font.BOLD, 50));
			g.drawString("Congratulation!", 120, 200);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Courier New", Font.BOLD, 20));
			g.drawString("Score: " + score, 300, 230);

		} else {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Courier New", Font.BOLD, 40));

		}

	}

	private void checkWalls() {
		if (minBoll.getX() < 0 || (minBoll.getX() + minBoll.getWidth()) > this.getWidth())
			minBoll.setXspeed(-1 * minBoll.getXspeed());
		if (minBoll.getY() < 0 /* (minBoll.getY() + minBoll.getHeight()) > this.getHeight() */)
			minBoll.setYspeed(-1 * minBoll.getYspeed());

		if ((minBoll.getY() + minBoll.getHeight()) > this.getHeight() + 25) {
			remove(minBoll);
			antalliv();
		}
	}

	private void remove(Boll minBoll2) {
		minBoll = new Boll(350, 400, 15, 15, Color.BLUE);
		minBat = new drawrect(320, 430, 75, 10, Color.BLUE);
		t.stop();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		minBoll.move();
		checkCollision();
		minBat.move();
		checkWalls();
		if (oldX == -1)
			oldX = myFrame.getX();
		if (oldY == -1)
			oldY = myFrame.getY();
		minBoll.setX(minBoll.getX() - (myFrame.getX() - oldX));
		minBoll.setY(minBoll.getY() - (myFrame.getY() - oldY));
		oldX = myFrame.getX();
		oldY = myFrame.getY();
		this.repaint();
		removeBricks();
		removeBall();
		removePaddle();

	}

	public void checkCollision() {
		Rectangle ballRect = minBoll.getRect(); // Skapar en rektangel som är på bollen
		Rectangle paddleRect = minBat.getRect(); // Skapar en rektangel som är på Slagträet

		if (ballRect.getBounds2D().intersects(paddleRect.getBounds2D())) { // Om bollen i rektangelformen kolliderar med
																			// slagträet.
			minBoll.setYspeed(-minBoll.getYspeed()); // Sätt -hastighet på bollen.
			minBoll.setY(minBoll.getY() - 5);
		}
		for (int j = 1; j < 4; j++) {
			for (int i = 0; i < 8; i++) {
				Rectangle brickRect = bricks[j][i].getRect();

				if (ballRect.intersects(brickRect)) {
					bricks[j][i].tabort(500, 500);
					minBoll.setYspeed(-minBoll.getYspeed());
					minBoll.setY(minBoll.getY() - 5);
					antalpoeng();
				}
			}
		}

		for (int j = 0; j < 1; j++) {
			for (int i = 0; i < 8; i++) {
				Rectangle brickRect = bricks[j][i].getRect();

				if (ballRect.intersects(brickRect) && (bricks[j][i].getColor() != Color.PINK)) {
					bricks[j][i].setColor(Color.PINK);
					minBoll.setYspeed(-minBoll.getYspeed());
					minBoll.setY(minBoll.getY() + 6);
				} else if (ballRect.intersects(brickRect) && (bricks[j][i].getColor() == Color.PINK)) {
					bricks[j][i].tabort(500, 500);
					minBoll.setYspeed(-minBoll.getYspeed());
					minBoll.setY(minBoll.getY() - 5);
					antalpoeng1();
				}
			}
		}
	}

	private void antalpoeng1() {
		score = score + 5;
		scoreBoard.setText("Score: " + score);
		scoreBoard.repaint();
		antalbrickor = antalbrickor - 5;

	}

	public void antalliv() {
		if (life > 0) {
			life = life - 1;
			scoreBoard1.setText("Life: " + life);
			scoreBoard1.repaint();
		} else {
			t.stop();
			removeBricks();
			removeBall();
			removePaddle();
		}

	}

	private void removePaddle() {
		if (life == 0) {
			minBoll.tabort(5000, 5000);
			minBat.tabort(5000, 5000);
		}

	}

	private void removeBall() {
		if (antalbrickor == 0) {
			minBat.tabort(5000, 5000);
			minBoll.tabort(5000, 5000);
		}

	}

	private void removeBricks() {
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 8; i++) {

				if (life == 0) {

					bricks[j][i].tabort(500, 500);

				}

			}
		}

	}

	public void antalpoeng() {
		score = score + 1;
		scoreBoard.setText("Score: " + score);
		scoreBoard.repaint();
		antalbrickor = antalbrickor - 1;

	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		if (key == KeyEvent.VK_SPACE) {
			t.start();

		} else {

		}

		int key1 = e.getKeyCode();

		if (key1 == KeyEvent.VK_LEFT) {

			minBat.setXspeed(-5);
		}

		if (key1 == KeyEvent.VK_RIGHT) {
			minBat.setXspeed(5);

		}

	}

	@Override

	public void keyReleased(KeyEvent e) {

		int key2 = e.getKeyCode();

		if (key2 == KeyEvent.VK_LEFT) {
			minBat.setXspeed(0);
		}

		if (key2 == KeyEvent.VK_RIGHT) {
			minBat.setXspeed(0);
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
