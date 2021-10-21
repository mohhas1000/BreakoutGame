
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Boll {

	private int x, y;
	private int xspeed, yspeed;
	private int width, height;
	private Color color;

	public Boll(int x, int y, int w, int h, Color col) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		color = col;
		xspeed = -3;
		yspeed = -3;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getXspeed() {
		return xspeed;
	}

	public int getYspeed() {
		return yspeed;
	}

	public void setXspeed(int x) {
		xspeed = x;
	}

	public void setYspeed(int y) {
		yspeed = y;
	}

	public void move() {
		x = x + xspeed;
		y = y + yspeed;
	}

	public void paintComponent(Graphics g) {
		Color tmpColor = g.getColor();
		g.setColor(color);
		g.fillOval(x, y, width, height);
		g.setColor(tmpColor);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Rectangle getRect() { // Skapar en metod av typen rektangel
		return new Rectangle(x, y, width, height); // new rektangel
	}

	public void tabort(int i, int j) {
		x = i;
		y = j;

	}

}
