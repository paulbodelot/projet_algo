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
	Equation eqDroite;
	
	public Miroir(int posX, int posY, int angleD, int taille){
		this.xmin = (int)(posX+(Math.cos(angle)*(taille/2)));
		this.ymin = (int)(posY+(Math.sin(angle)*(taille/2)));
		this.xmax = (int)(posX-(Math.cos(angle)*(taille/2)));
		this.ymax = (int)(posY-(Math.sin(angle)*(taille/2)));
		
		this.taille = taille;
		angle=angleD*Math.PI/180;
		int [] posMiroir = {posX,posY};
		int [] dirMiroir = new int[2];
		
		if(angle>Math.PI/2 && angle<Math.PI*3/2)
		{
			dirMiroir[0] = -100;
			dirMiroir[1] = -(int)(100*Math.tan(angle));
		}
		
		else
		{
			dirMiroir[0] = 100;
			dirMiroir[1] = (int)(100*Math.tan(angle));
		}
		
		this.eqDroite = new Equation(dirMiroir,posMiroir);
	}
	public Rayon creationRayon(int posX, int posY,Equation eq){ //On crée un rayon réfléchi : son angle au miroir est l'opposé de celui du rayon incident
		
		int[]nouvelleDir = new int[2];
		double angleInit = Math.atan2(eq.vDir[1],eq.vDir[0]);
		double angleFinal = 2*this.angle-angleInit;
		
		if(angleFinal>Math.PI/2 && angleFinal<Math.PI*3/2)
		{
			nouvelleDir[0] = -100;
			nouvelleDir[1] = -(int)(100*Math.tan(angleFinal));
		}
		
		else
		{
			nouvelleDir[0] = 100;
			nouvelleDir[1] = (int)(100*Math.tan(angleFinal));
		}
		
		System.out.println("Nouveau rayon réfléchi");
		
		Rayon nouveauRayon = new Rayon(posX,posY,nouvelleDir,Color.red, this);
		return nouveauRayon;
	}
	
	public void dessin(Graphics g){
		g.setColor(Color.black);
		g.drawLine(xmin,ymin,(xmax),(ymax));
	
		
			}
}

