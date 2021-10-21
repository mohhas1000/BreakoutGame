
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Brick {

	private int z, v;
	private int width, height;
	private Color col;
	int key = 5;

	public Brick(int z, int v, int k, int l, Color white) {
		this.z = z;
		this.v = v;
		this.width = k;
		this.height = l;
		col = white;
	}

	public Color getColor() {
		return col;
	}

	public void setColor(Color a) {
		col = a;
	}

	public void paintComponent(Graphics g) {
		Color tmpColor = g.getColor();
		g.setColor(col);
		g.fillRect(z, v, width, height);
		g.setColor(tmpColor);

	}

	public Rectangle getRect() { // Skapar en metod av typen rektangel
		return new Rectangle(z, v, width, height); // new rektangel
	}

	public Rectangle getRect1() { // Skapar en metod av typen rektangel
		return new Rectangle(z, v, width, height); // new rektangel
	}

	public void tabort(int i, int j) {
		z = i;
		v = j;
	}

}
