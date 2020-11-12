package presentacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import aplicacion.EventosKeyboard;
import aplicacion.EventosKeyboard;
import aplicacion.FroggerManager;
import aplicacion.Player;

public class GameGUI extends JFrame{
	
	private FroggerManager manager;
	private Player player1;
	private JPanel background = new JPanel();
	

	public GameGUI() {
		manager = new FroggerManager(0, this);
		addKeyListener(new EventosKeyboard());
		windowSettings();
		setVisible(true);
	}
	
	
	private void preapreElementosGraficos(){		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(player1.getSprite(), player1.getX(), player1.getY(), 50, 50, null);
		Toolkit.getDefaultToolkit().sync();
		validate();
	}
	
	public void toDraw(Player player1) {
		this.player1 = player1; 
	} 
	
	private void windowSettings() {
		setTitle("Frogger Game");
		setSize(800,600);
		background.setBackground(Color.black);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(background);
		setResizable(false);
	}

}
