import java.awt.Point;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Interface {
	
	public Point size;
	public int s;
	public Piece pieces [][] ;
		
	
	public boolean win(){	
		
		//On verifie que toutes les cases du plateau sont pleines
		for(int i=0; i<size.x ; i++){
			for(int j=0; j<size.y ; j++){	
				if(pieces[i][j].motifs[0] == 0){	
					return false;
				}			
			}
		}
		
		//On verifie que toutes les bordures noirs sont bien au bord
		for(int i=0; i<size.x ; i++){				
				if(pieces[i][0].motifs[1] != 1 || pieces[i][size.y-1].motifs[3] != 1 ){	
					return false;
				}					
		}	
		for(int j=0; j<size.y ; j++){				
			if(pieces[0][j].motifs[0] != 1 || pieces[size.x-1][j].motifs[2] != 1){	
				return false;
			}			
		}	
		
		//On verifie que les faces voisines sont les memes
		for(int i=1; i<size.x-1 ; i++){
			for(int j=1; j<size.y-1 ; j++){	
				
				if(pieces[i][j].motifs[0] != pieces[i-1][j].motifs[2]){	
					return false;
				}	
				
				if(pieces[i][j].motifs[2] != pieces[i+1][j].motifs[0]){	
					return false;
				}
				
				if(pieces[i][j].motifs[1] != pieces[i][j-1].motifs[3]){	
					return false;
				}	
				
				if(pieces[i][j].motifs[3] != pieces[i][j+1].motifs[1]){	
					return false;
				}
				
			}
		}
		
		//C'est gagnŽ :)
		
		javax.swing.JOptionPane.showMessageDialog(null,"Bravo tu as gagné !!! :D"); 
		return true;
		
	}
	
	public void init(){		
		for(int i=0; i<size.x ; i++){
			for(int j=0; j<size.y ; j++){				
				pieces[i][j].setMotif(0,0,0,0);		 
			}
		}	
		update();
	}

	
	public Interface (int x, int y,int s){
				
		System.out.println("Creation du plateau size :" + x + ";" + y);
		size = new Point(x,y);
		pieces = new Piece[x][y];
		this.s = s;
		
		for(int i=0; i<x ; i++){
			for(int j=0; j<y ; j++){				
				pieces[i][j] = new Piece(s);		 
			}
		}			
		
	}
	
	private void melange_rnd(){
		for(int i=0; i<size.x ; i++){
			for(int j=0; j<size.y ; j++){					
				pieces[i][j].swap(pieces[rnd(0,4)][rnd(0,4)]);					
			}
		}
	}
	
	private void retourne_rnd(){
		for(int i=0; i<size.x ; i++){
			for(int j=0; j<size.y ; j++){					
				for(int r=0; r<rnd(0,4) ; r++){	
					pieces[i][j].tourner();
				}									
			}
		}		
	}
	
	public void read_csv() {	
	

		
		pieces[0][0].setMotif(1,1,2,4);
		pieces[1][0].setMotif(2,1,4,5);
		pieces[2][0].setMotif(4,1,4,2);
		pieces[3][0].setMotif(4,1,1,3);
		
		pieces[0][1].setMotif(1,4,2,5);
		pieces[1][1].setMotif(2,5,3,4);
		pieces[2][1].setMotif(3,2,4,2);
		pieces[3][1].setMotif(4,3,1,2);
		
		pieces[0][2].setMotif(1,5,2,4);
		pieces[1][2].setMotif(2,4,5,4);
		pieces[2][2].setMotif(5,2,3,2);
		pieces[3][2].setMotif(3,2,1,2);
		
		pieces[0][3].setMotif(1,4,5,1);
		pieces[1][3].setMotif(5,4,3,1);
		pieces[2][3].setMotif(3,2,5,1);
		pieces[3][3].setMotif(5,2,1,1);

		melange_rnd();
		
	
		retourne_rnd();
		
		
		/*LECTURE DU CSV*/
		
		File face = new File("faces_02.csv");	
		File piece = new File("pieces_02.csv");
		Scanner scanner;	
		try {	
			
			scanner = new Scanner (face);		
			System.out.println(scanner.nextLine());		
			Motif test[] = new Motif[5];	
			for(int i=0; i<5 ; i++){
				test[i] = new Motif(scanner.next().charAt(0),Integer.parseInt(scanner.next()),scanner.next());
			}
			
			scanner = new Scanner (piece);		
			System.out.println(scanner.nextLine());		
			for(int i=0; i<16 ; i++){
				
			}
			   
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		update();
	
	}
	
	
	public void update(){
		for(int i=0; i<size.x ; i++){
			for(int j=0; j<size.y ; j++){				
				pieces[i][j].update();	 
			}
		}
	}
	
	
	private int rnd(int min,int max){		
		return (int)(Math.random() * (max-min)) + min;
	}
	
	

}


