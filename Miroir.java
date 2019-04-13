import java.awt.Graphics ;
import java.awt.Color ;
import javax.swing.JFrame ;
//Version modifiée par Arthur le 09/04
public class Miroir extends ObjetOptique {
	int xmin;
	int ymin;
	int xmax;
	int ymax;
	
	double angle;
	int taille;
	
	public Miroir(int posX, int posY, int angleD, int taille){
		this.taille = taille;
		angle=angleD*Math.PI/180;
		
		
		this.xmin = (int)(posX-(Math.cos(angle)*(taille/2)));
		this.ymin = (int)(posY-(Math.sin(angle)*(taille/2)));
		this.xmax = (int)(posX+(Math.cos(angle)*(taille/2)));
		this.ymax = (int)(posY+(Math.sin(angle)*(taille/2)));
		
		
		int [] posMiroir = {posX,posY};
		int [] dirMiroir = new int[2];
		
	}
	public Rayon creationRayon(Rayon rIncident, int xD, int yD){ //On crée un rayon réfléchi : son angle au miroir est l'opposé de celui du rayon incident
		double angleIncident = Math.PI;
		if(rIncident.xDebut-rIncident.xFin!=0){
			angleIncident =Math.atan((rIncident.yFin-rIncident.yDebut)/(rIncident.xDebut-rIncident.xFin));
		}
		double angleReflexion = 2*this.angle-angleIncident;
		if (rIncident.xDebut > xD){
			angleReflexion=-angleIncident;
		}
		
		System.out.println(xD+Math.cos(angleReflexion));
		Rayon nouveauRayon = new Rayon (xD, yD, (int)(xD+Math.cos(angleReflexion)*900), (int)(yD+Math.sin(angleReflexion)*900),Color.red,this);
		return nouveauRayon;
	}
	
	public void dessin(Graphics g){
		g.setColor(Color.black);
		g.drawLine(xmin,ymin,(xmax),(ymax));
	
		
			}
}

