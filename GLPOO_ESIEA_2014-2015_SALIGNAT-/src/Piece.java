import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import javax.swing.JComponent;


public class Piece extends JComponent {

	public int motifs[] = new int[4];	
	private int rotation;	
	private Point taille;	
	
// Piece vide
	
	public Piece(int t)
	{
		System.out.println("Piece vide");		
		motifs[0] = 0;
		motifs[1] = 0;
		motifs[2] = 0;
		motifs[3] = 0;
		rotation = 0;		
		taille = new Point(t,t);
		repaint();		
	}
		
	//Piece complete 
	
	public Piece(int t,int motif_ouest, int motif_nord, int motif_est, int motif_sud)
		{
		System.out.println("Piece complete");		
		motifs[0] = motif_ouest;
		motifs[1] = motif_nord;
		motifs[2] = motif_est;
		motifs[3] = motif_sud;		
		taille = new Point(t,t);
		repaint();		
	}
		
	
	// appel de fonction set
	
	public void setMotif(int motif_ouest, int motif_nord, int motif_est, int motif_sud){
		motifs[0] = motif_ouest;
		motifs[1] = motif_nord;
		motifs[2] = motif_est;
		motifs[3] = motif_sud;
	}
	
	// appel de fonction get
	
	public int getMotif(int var)
	{
		return motifs[var];
	}
	
	// fonction tourner
	
	public void tourner (){
		int tmp = motifs[0];
		motifs[0]= motifs[1];
		motifs[1]= motifs[2];
		motifs[2]= motifs[3];
		motifs[3]= tmp;
		rotation = (rotation + 1)%4;
	}	
	
	// fonction retourner 
	
	public void retourner(){
		int temp = motifs[0];
		motifs[0]= motifs[3];
		motifs[3]= motifs[2];
		motifs[2]= motifs[1];
		motifs[1]=temp;
		rotation = (rotation - 1)%4;
	}
	
	
	// Creation de la fonction swap
	
	
	public void swap(Piece piece_2)	{
		Piece piece_3 = new Piece(taille.x, piece_2.motifs[0], piece_2.motifs[1], piece_2.motifs[2], piece_2.motifs[3]);
		piece_2.motifs[0]=this.motifs[0];
		piece_2.motifs[1]=this.motifs[1];
		piece_2.motifs[2]=this.motifs[2];
		piece_2.motifs[3]=this.motifs[3];

		this.motifs[0]= piece_3.motifs[0];
		this.motifs[1]= piece_3.motifs[1];
		this.motifs[2]= piece_3.motifs[2];
		this.motifs[3]= piece_3.motifs[3];
	}
	
	
	public void update() 
	{
		repaint();		    
	}
	

	public void paintComponent(Graphics d)
	{
	       make(d);	    
	}
	
	private void setColorMotif(int motif, Graphics d){
		 switch (motif) {
	         case 0: 
	        	 	d.setColor(Color.white);
	                break;
	         case 1:  
	        	 	d.setColor(Color.black);
	         		break;
	         case 2:  
	        	 	d.setColor(Color.green);
	         		break;
	         case 3:  
	        	 	d.setColor(Color.red);
	         		break;
	         case 4:  
	        	 	d.setColor(Color.yellow);
	         		break;
	         case 5: 
	        	 	d.setColor(Color.orange);
	         		break;
	         default:
	        	 	d.setColor(Color.black);
	         		break;
		 }	 
	
	}
	
	private void make(Graphics d){
		
		setColorMotif(motifs[1], d);
		Polygon a = new Polygon();
		a.addPoint(0,0);
		a.addPoint(taille.x,0);
		a.addPoint(taille.x/2,taille.y/2);        
		((Graphics2D) d).fill(a);
		
	    
		setColorMotif(motifs[0], d);
	    Polygon b = new Polygon();
        b.addPoint(0,0);
        b.addPoint(0,taille.y);
        b.addPoint(taille.x/2,taille.y/2);       
	    ((Graphics2D) d).fill(b);
	    
		setColorMotif(motifs[2], d);
	    Polygon c = new Polygon();
        c.addPoint(taille.x,0);
        c.addPoint(taille.x,taille.y);
        c.addPoint(taille.x/2,taille.y/2);        
	    ((Graphics2D) d).fill(c);
	    
		setColorMotif(motifs[3], d);
	    Polygon e = new Polygon();
        e.addPoint(taille.x,taille.y);
        e.addPoint(0,taille.y);
        e.addPoint(taille.x/2, taille.y/2);       
	    ((Graphics2D) d).fill(e);
	}
	

	
	
	
	
}


