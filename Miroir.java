import java.awt.Graphics ;
import java.awt.Color ;
import javax.swing.JFrame ;
public class Miroir extends ObjetOptique {
	
	
	public Miroir(int posX, int posY, int angleD, int taille){
		this.taille = taille;
		angle=angleD*Math.PI/180;
		
		
		this.xmin = (int)(posX+(Math.cos(angle)*(taille/2)));
		this.ymin = (int)(posY-(Math.sin(angle)*(taille/2)));
		this.xmax = (int)(posX-(Math.cos(angle)*(taille/2)));
		this.ymax = (int)(posY+(Math.sin(angle)*(taille/2)));
		
	}
	public Rayon creationRayon(Rayon rIncident, int xD, int yD){ //On crée un rayon réfléchi : son angle au miroir est l'opposé de celui du rayon incident
		double angleIncident = Math.PI/2;
		if(yD>rIncident.yDebut){
			angleIncident=-Math.PI/2;
		}
		Rayon nouveauRayon;
		if(xD-rIncident.xDebut!=0){
			angleIncident =-Math.atan(((double)(yD)-(double)(rIncident.yDebut))/((double)(xD)-(double)(rIncident.xDebut)));
		}
		
		double deltaAngle=Math.abs(angleIncident-this.angle);
		double angleReflexion = 0;
		int xFin=0;
		int yFin=0;
		
		angleReflexion=this.angle+deltaAngle;
		
		
		angleReflexion=2*this.angle-angleIncident;
		
		if(xD>=rIncident.xDebut){
			yFin= (int)(yD-Math.sin(angleReflexion)*900);
			xFin=(int)(xD+Math.cos(angleReflexion)*900);
		}
		if(xD<rIncident.xDebut){
			yFin= (int)(yD+Math.sin(angleReflexion)*900);
			xFin=(int)(xD-Math.cos(angleReflexion)*900);
		}
			
		
		
		
		
		nouveauRayon = new Rayon (xD, yD, xFin, yFin,rIncident.couleur,this);
		
		return nouveauRayon;
	}
	
	public void dessin(Graphics g){
		g.setColor(Color.black);
		g.drawLine(xmin,ymin,(xmax),(ymax));
	
		
			}
}

