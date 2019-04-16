import java.util.ArrayList; 
public class MaClassePrincipale {

	public static void main (String[] args) {
		boolean fermetureDuProgramme = false;
		ArrayList<Miroir> miroirs=new ArrayList <Miroir>();
		ArrayList<Rayon> rayons=new ArrayList <Rayon>();
		ArrayList<SourceLum> sources = new ArrayList <SourceLum>();
		FenetrePrincipale maFenetre = new FenetrePrincipale(rayons, miroirs, sources);
		
	}
}	
