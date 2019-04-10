import java.awt.*;
import java.util.*;

public class Rayon
{
	//Coordonnées limites du rayon en pixels
	public int xDebut;
	public int yDebut;
	public int xFin;
	public int yFin;
	public Color couleur;
	public Equation eqDroite;
	
	
	public Rayon(int xD,int yD, int xF, int yF,Color laCouleur) //Crée un rayon entre deux points
	{
		this.xDebut = xD;
		this.yDebut = yD;
		this.xFin = xF;
		this.yFin = yF;
		
		this.couleur = laCouleur;
		
		//On crée le vecteur directeur du rayon et on calcule son ordonnée à l'origine pour avoir son équation de droite
		int[]dirRayon= new int[2];
		dirRayon[0] = xFin-xDebut;
		dirRayon[1] = yFin-yDebut;
		
		int y0 = yDebut-xDebut*dirRayon[1]/dirRayon[0];
		
		this.eqDroite = new Equation(dirRayon,y0);
		
	}
	
	public Rayon(int xD, int yD, int []dir,Color laCouleur) //Crée un rayon entre deux points dont les coordonnées sont rangées dans des tableaux
	{
		this.xDebut = xD;
		this.yDebut = xD;
		
		this.couleur = laCouleur;
		
		//On calcule l'ordonnée à l'origine pour avoir son équation de droite
		
		int y0 = yDebut-xDebut*dir[1]/dir[0];
		
		this.eqDroite = new Equation(dir,y0);
		
	}
	
	public Rayon chercheObstacle (ArrayList<Miroir> liste) {
		
		Rayon rayonRet = null;
		
		if(!liste.isEmpty()){
			System.out.println("Recherche d'un obstacle");
			for (Miroir mir : liste) {
			
				int [] tab = new int[2];
				int xSol = mir.eqDroite.resoudreSysteme(this.eqDroite)[0];
				int ySol = mir.eqDroite.resoudreSysteme(this.eqDroite)[1];
				tab[0] = xSol;
				tab[1] = ySol;
			
				if ((tab[0]!=-2048 && tab[1]!=-2048) && (tab[0]!=2048 && tab[1]!=2048)) {
					System.out.println("Obstacle trouvé !");
					xFin=tab[0];
					yFin=tab[1];
					rayonRet = mir.creationRayon(xFin, yFin, eqDroite);
					break;
				}
			
			}
		}
		if(rayonRet == null)
		{
			rayonRet = this;
		}
		return rayonRet;
		
		
	}
	
	
	
	public String toString()
	{
		String s = "Rayon allant du point (" + xDebut + ";" + yDebut + ") au point (" + xFin + ";" + yFin + ")";
		return s;
	}
	
	public void dessin (Graphics g) {
		
		g.setColor(couleur);
		g.drawLine(xDebut, yFin, xFin, yFin);
	
		
	}
}