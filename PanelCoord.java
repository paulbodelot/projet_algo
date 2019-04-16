import javax.swing.*;
import java.awt.*;
import java.util.*; 


public class PanelCoord extends JPanel{ 
	
	public ArrayList<Rayon> listeRayons;
	public ArrayList<Miroir> listeMiroirs;
	public ArrayList<SourceLum> listeSources;
	
	public void dessiner(ArrayList<Rayon> listeRayons, ArrayList<Miroir> listeMiroirs, ArrayList<SourceLum> listeSources){
		
		this.listeRayons=listeRayons;
		this.listeMiroirs=listeMiroirs;
		this.listeSources=listeSources;
		repaint();
	} 
	

	public void paint(Graphics g){
		g.setColor(Color.white); 
		g.fillRect(0,0,getWidth(),getHeight());
		 
		for(Rayon ray:listeRayons){
			
			g.setColor(ray.couleur);
			g.drawLine(ray.xDebut, ray.yDebut, ray.xFin, ray.yFin);
			
		}
		for(Miroir miroir:listeMiroirs){
			g.setColor(Color.black);
			g.drawLine(miroir.xmin,miroir.ymin,miroir.xmax,miroir.ymax);
		}
		
		for(SourceLum src:listeSources){
			g.setColor(src.couleur_rayon);
			g.fillRect(src.x-src.taille/2, src.y-src.taille/2, src.taille, src.taille);
		}
	} 
}
