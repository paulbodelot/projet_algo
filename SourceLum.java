import java.awt.*;

public class SourceLum {

	int x;
	int y;
	int taille;
	int angle;
	Color couleur_rayon;

	public SourceLum (int x, int y, int angle, int taille, Color coul) {
	
		this.x = x;
		this.y = y;
		this.taille = taille;
		this.angle = angle;
		couleur_rayon=coul;

	}
	
	public Rayon creationRayon () {
		
		Rayon ray = new Rayon (this.x, this.y, 700-this.x, this.y, couleur_rayon); 
		//Les limites de la zone de travail sont 700 et 400, d'ou les calculs
		System.out.println("Le rayon cree commence en x = "+x+" et en y = "+y+"\n puis termine en x = "+(700-this.x)+" et en y = "+this.y);
		return ray;
		
	}
	
	public void dessin (Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x-taille/2, y-taille/2, taille, taille);
	
		
	}
}
