
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class drawrect {
	private int a, b;
	private int width, height;
	private Color colo;
	private int xspeed;

	public drawrect(int a, int b, int k, int l, Color orange) {
		this.a = a;
		this.b = b;
		this.width = k;
		this.height = l;
		colo = orange;
		xspeed = 0;
	}

	public int getXspeed() {
		return xspeed;
	}

	public void setXspeed(int a) {
		xspeed = a;
	}

	public void paintComponent(Graphics g) {
		Color tmpColor = g.getColor();
		g.setColor(colo);
		g.fillRect(a, b, width, height);
		g.setColor(tmpColor);

	}

	public void move() {

		a += xspeed;

		if (a <= 0) {
			a = 0;
		}

		if (a >= 608) {
			a = 608;
		}
	}

	public Rectangle getRect() { // Skapar en metod av typen rektangel
		return new Rectangle(a, b, width, height); //
	}

	public void tabort(int i, int j) {
		a = i;
		b = j;

	}

}
