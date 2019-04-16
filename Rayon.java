import java.awt.*;
import java.util.*;
import javax.swing.*;


public class Rayon
{
	//Coordonnées limites du rayon en pixels
	public int xDebut;
	public int yDebut;
	public int xFin;
	public int yFin;
	public Color couleur;
	public ObjetOptique createur;
	

	
	public Rayon(int xD,int yD, int xF, int yF,Color laCouleur, ObjetOptique createur) //Crée un rayon entre deux points
	{
		this.xDebut = xD;
		this.yDebut = yD;
		this.xFin = xF;
		this.yFin = yF;
		
		this.couleur = laCouleur;
		
		//On crée le vecteur directeur du rayon et on calcule son ordonnée à l'origine pour avoir son équation de droite
		
		
		
		this.createur = createur;
		
		
	}
	
	
	public Rayon chercheObstacle (ArrayList<Miroir> liste) {
		
		Rayon rayonRet = null;
		
		if(!liste.isEmpty()){
			System.out.println("Recherche d'un obstacle");
			for (Miroir mir : liste) {
			
				if (mir!=createur) {
					int[] tab = chercheIntersection(xDebut,yDebut,xFin,yFin,mir.xmin,mir.ymin, mir.xmax,mir.ymax);

					if ((tab[0]!=-2048 && tab[1]!=-2048) && (tab[0]!=2048 && tab[1]!=2048)) {
						System.out.println("Obstacle trouvé !");
						xFin=tab[0];
						yFin=tab[1];
						rayonRet=mir.creationRayon(this,xFin, yFin);
	
					}
				}
			
			}
		}
		
		return rayonRet;
		
		
	}
	
	
	
	public String toString()
	{
		String s = "Rayon allant du point (" + xDebut + ";" + yDebut + ") au point (" + xFin + ";" + yFin + ")";
		return s;
	}
	
	
	public void dessin(Graphics g) {
		
		g.setColor(couleur);
		g.drawLine(xDebut, yDebut, xFin, yFin);
	
		
	}
	
	
		public int[] chercheIntersection(double xA,double yA, double xB, double yB,double xC,double yC, double xD, double yD) {
		int[] sol ={-2048,-2048};
		
		double ix=xB-xA;
		double iy=yB-yA;
			
		double jx=xD-xC;
		double jy=yD-yC;
		
		double m=0;
		double k=0;
		
		if((ix*jy-iy*jx) != 0){
			m = (ix*yA-ix*yC-iy*xA+iy*xC)/(ix*jy-iy*jx);
			k = (-xA*jy+xC*jy+jx*yA-jx*yC)/(ix*jy-iy*jx);
		}
			
		if((ix*jy-iy*jx != 0)&&(m>0)&&(m<1)&&(k>0)&&(k<1)){
			sol[0]=(int)(xA+k*ix);
			sol[1]=(int)(yA+k*iy);
			 
		}
		
		return sol;
		
	}
}
