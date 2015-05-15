import java.awt.Graphics;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class JeuEternity extends JFrame implements KeyListener,ActionListener,MouseListener{
	
	
	private int size = 4;
	
	// Creation des objets 
	
	private JPanel panel;
	private JFrame frame;
	private JButton rejouer;
	private JButton rotation;
	private JButton[][] PieceSmall;
	
	Interface Small;
	
	public JeuEternity() {
		
		//Nouvelle partie
		
		System.out.println("Nouvelle partie");	
		renderGame();
		
		
	    creat_dec(size,size);
      
      //Autorisation de l'affichage
	    
	    frame.setTitle("Jeu Eternity II");
        frame.setSize(600, 650);
		frame.setVisible(true);	
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
	}
	
	
	private void renderGame(){	
		
		//Creation de la fenetre
		
		System.out.println("Fenetre");	
		frame = new JFrame("Jeu Eternity II");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	    
	    panel = (JPanel)frame.getContentPane();  
	    panel.setLayout(null);
	    
	    //Creation des objets
	    
	    System.out.println("Objets");	
	    
	    
		// Creation du bouton Rejouer
	    
	    rejouer = new JButton("Rejouer");	 
        rejouer.addActionListener(this);
        rejouer.setBounds(230,570,150,30);
     
	
      
      // Creation du outon rotation
        
      rotation = new JButton("Rotate");       
      rotation.addActionListener(this);
      rotation.setBounds(440, 155, 215,30);
      
      // Ajout du bouton
      panel.add(rejouer);
             
    
	}
	
		
	
	private void creat_dec(int x, int y){
		
		PieceSmall = new JButton[size][size];
		Small = new Interface(size,size,120);		
		Small.read_csv();
		
		//Creation des boutons des pieces
		
	    for(int i=0; i<x ; i++){
			for(int j=0; j<y ; j++){		
				
				// tableau bouton
				PieceSmall[i][j] = new JButton();			
				PieceSmall[i][j].addActionListener(this); 
			    PieceSmall[i][j].addMouseListener(this); 			    
			    PieceSmall[i][j].setBounds(50+2*i+120*i, 50+2*j+120*j, 120,120); 
			    PieceSmall[i][j].setContentAreaFilled(false);	
			    panel.add(PieceSmall[i][j]);
			    
			    // tableau image 		   
			    Small.pieces[i][j].setBounds(50+2*i+120*i, 50+2*j+120*j, 120,120);	
			    panel.add(Small.pieces[i][j]);
			    frame.setLocationRelativeTo(null);
			}
		}	 
   }
	


	private Piece last = null;
	
	public void actionPerformed(ActionEvent e) {			
		
		
		// Pour chaque piece du plateau
		
		for(int i=0; i<4 ; i++){
			for(int j=0; j<4 ; j++){	
				if(e.getSource() == PieceSmall[i][j]){
					Small.pieces[i][j].tourner();
					Small.win();
					last = Small.pieces[i][j];
				}				
			}
		}	
				
		// Quand on presse le bouton Rejouer
		
		if(e.getSource() == rejouer){
			System.out.println("On recommence au début");				
			Small.init();			
			Small.read_csv();
		;
		} 
		
	
	
	} 
	
	// Ajouter du texte sur la fenetre
	
	/*public void paintComponent(Graphics g) {
		g.drawString("Bienvenue", 700,500);
	
	}*/
	
	public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();	
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

		public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub		
	}



		
	private Piece start = null;
	
	public void mousePressed(MouseEvent e) {
		
		//Fonction pour les pieces du dec
		
		for(int i=0; i<4 ; i++){
			for(int j=0; j<4 ; j++){	
				if(e.getSource() == PieceSmall[i][j]){
					start = Small.pieces[i][j];
				}				
			}
		}
		
		
		if (start != null){
			System.out.println("Bouton préssé");	
	
		}
		
	}
	
	
		
	private Piece stop = null;
	
	public void mouseEntered(MouseEvent e) 
	{
	
	
				for(int i=0; i<4 ; i++)
				{
					for(int j=0; j<4 ; j++)
					{	
						if(e.getSource() == PieceSmall[i][j]){
							stop = Small.pieces[i][j];
						}				
					}
				}
						
	}
	
	public void mouseReleased(MouseEvent e) {
				
		if (stop != null && start != null)
		{
			System.out.println("Boutoon relaché !!");
			stop.swap(start);
			stop.update();
			start.update(); 
			last = stop;
			Small.win();
		}
		
		stop = null;
		start = null;	
	}

}



