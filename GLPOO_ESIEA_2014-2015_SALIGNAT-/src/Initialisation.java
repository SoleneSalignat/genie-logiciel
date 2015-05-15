import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

public class Initialisation extends JFrame{

	private JPanel menu = new JPanel();
	private JButton start = new JButton("Début du jeu");
	
	public Initialisation (){
		this.setSize(800, 800);
		this.setVisible(true);	
		this.setResizable(false);
	}

}
