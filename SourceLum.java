import java.awt.*;

public class SourceLum {

	int x;
	int y;
	int taille;
	int angle;
	Color couleur_rayon;
	int nbreRayons;
	double ouverture;

	public SourceLum (int x, int y, int angle, int taille, Color coul, int nbreRayons, int ouverture) {
	
		this.x = x;
		this.y = y;
		this.taille = taille;
		this.angle = angle;
		couleur_rayon=coul;
		this.nbreRayons = nbreRayons;
		this.ouverture = ouverture*Math.PI/180;

	}
	
	
	public Rayon creationRayon (int i) {
		
		double angleRa=angle*Math.PI/180+(i*ouverture/nbreRayons);
		int xmin = x;
		int ymin = y;
		int xmax = (int)(x+(Math.cos(angleRa)*1000));
		int ymax = (int)(y-(Math.sin(angleRa)*1000));
		
		Rayon ray = new Rayon (xmin, ymin, xmax, ymax, couleur_rayon,null); 
		return ray;
		
	}
	
	public void dessin (Graphics g) {
		g.setColor(couleur_rayon);
		g.fillRect(x-taille/2, y-taille/2, taille, taille);
	
		
	}
}
