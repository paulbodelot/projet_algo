import java.awt.Graphics ;
import java.awt.Color ;
import javax.swing.JFrame ;
public class LameMince extends ObjetOptique {
	int xmin;
	int ymin;
	int xmax;
	int ymax;
	double n = 1.5;
	
	double angle;
	int taille;
	
	public LameMince(int posX, int posY, int angleD, int taille){
		this.taille = taille;
		angle=angleD*Math.PI/180;
		
		
		this.xmin = (int)(posX+(Math.cos(angle)*(taille/2)));
		this.ymin = (int)(posY-(Math.sin(angle)*(taille/2)));
		this.xmax = (int)(posX-(Math.cos(angle)*(taille/2)));
		this.ymax = (int)(posY+(Math.sin(angle)*(taille/2)));
		
	}
	public Rayon creationRayon(Rayon rIncident, int xD, int yD){ //On crée un rayon réfléchi : son angle au miroir est l'opposé de celui du rayon incident
		Rayon nouveauRayon;
		double angleIncident = Math.PI/2;
		double deltaY;
		int xFin;
		int yFin;
		
		
		if(yD>rIncident.yDebut){
			angleIncident=-Math.PI/2;
		}
		
		if(xD-rIncident.xDebut!=0){
			angleIncident =Math.atan(((double)(yD)-(double)(rIncident.yDebut))/((double)(xD)-(double)(rIncident.xDebut)));
		}
		
		deltaY = (1-Math.sqrt((1-Math.pow(Math.sin(angleIncident),2))/((this.n*this.n)-Math.pow(Math.sin(angleIncident),2))));
		
		xFin= (int)(yD+Math.sin(angleIncident)*900); //La longueur d'un rayon qui ne rencontre pas d'obstacle est de 900 pixels par défaut.
		yFin=(int)(xD+Math.cos(angleIncident)*900);
		
		nouveauRayon = new Rayon (xD, (int)(yD-deltaY), xFin, yFin,rIncident.couleur,this);
		
		return nouveauRayon;
	}
	
	public void dessin(Graphics g){
		g.setColor(Color.black);
		g.drawLine(xmin,ymin,(xmax),(ymax));
	
		
			}
}
