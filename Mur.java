import java.awt.Graphics ;
import java.awt.Color ;
import javax.swing.JFrame ;
public class Mur extends ObjetOptique {
	
	public Mur(int posX, int posY, int angleD, int taille){
		this.taille = taille;
		angle=angleD*Math.PI/180;
		
		
		this.xmin = (int)(posX+(Math.cos(angle)*(taille/2)));
		this.ymin = (int)(posY-(Math.sin(angle)*(taille/2)));
		this.xmax = (int)(posX-(Math.cos(angle)*(taille/2)));
		this.ymax = (int)(posY+(Math.sin(angle)*(taille/2)));
		
	}
	public Rayon creationRayon(Rayon rIncident, int xD, int yD){ //On crée un rayon réfléchi : son angle au miroir est l'opposé de celui du rayon incident
		
		return null;
	}
	
}
