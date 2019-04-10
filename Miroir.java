import java.awt.Graphics ;
import java.awt.Color ;
import javax.swing.JFrame ;
//Version modifiée par Arthur le 09/04
public class Miroir extends ObjetOptique {
	int x;
	int y;
	double angle;
	int taille;
	Equation eqDroite;
	
	public Miroir(int posX, int posY, int angleDeg, int taille){
		this.x = posX;
		this.y = posY;
		this.angle = (angleDeg)*Math.PI/180;
		this.taille = taille;
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
		
		Rayon nouveauRayon = new Rayon(posX,posY,nouvelleDir,Color.red);
		return nouveauRayon;
	}
	
	public void dessin(Graphics g){
		g.setColor(Color.black);
		g.drawLine( (int)(x+(Math.cos(angle)*taille/2)),(int)(x+(Math.sin(angle)*(taille/2))),  (int)(x-(Math.cos(angle)*(taille/2))),  (int)(x-(Math.sin(angle)*(taille/2))));
	
		
			}
}

