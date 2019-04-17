abstract class ObjetOptique{
	int xmin;
	int ymin;
	int xmax;
	int ymax;
	
	double angle;
	int taille;
	
	public abstract Rayon creationRayon(Rayon rIncident, int xD, int yD);
	
}
