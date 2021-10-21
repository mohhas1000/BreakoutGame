
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Time;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.Toolkit;

public class Boll_window extends JFrame {

	private static Mainpanel mainpanel;

	public Boll_window() {
		mainpanel = new Mainpanel(this);
		mainpanel.grabFocus(); // Ser till att alla tecken hamnar i det här fönstret
		this.addComponentListener(mainpanel);
		add(mainpanel);
		setSize(700, 520);
		setVisible(true); //// förmågan eller egenskap
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Breakout-game");
		mainpanel.setBackground(Color.BLACK);
		this.addKeyListener(mainpanel);

	}

}
