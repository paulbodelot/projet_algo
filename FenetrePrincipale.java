import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.awt.Font;
import java.util.ArrayList; 
import java.awt.Color;

//Version modifiée par Arthur le 09/04
// Creation de la fenetre

public class FenetrePrincipale extends JFrame implements ActionListener {
	
	private JButton boutonMiroir;
	private JButton boutonLentilleC;
	private JButton boutonLentilleD;
	private JButton boutonRayonRouge;
	private JButton boutonRayonBleu;
	private JButton boutonRayonVert;
	private JTextArea Affichage;
	
	public ArrayList<Rayon> listeRayons;
	public ArrayList<Miroir> listeMiroirs;
	public ArrayList<SourceLum> listeSources;
	
	public int nbObjetsPrecedent = 0;
	
	//SourceLum lum = new SourceLum (200, 250, 0, 50, Color.red);
	
	
	public FenetrePrincipale (ArrayList<Rayon> rayons, ArrayList<Miroir> miroirs, ArrayList<SourceLum> sources) {
		this.listeRayons=rayons;
		this.listeMiroirs=miroirs;
		this.listeSources=sources;
		
		this.setTitle("Banc optique virtuel");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font PoliceArial_16 = new Font("Arial",Font.BOLD,16);
		Font PoliceArial_14 = new Font("Arial",Font.BOLD,14);
		Font PoliceSymbole_14 = new Font("Symbole",Font.BOLD,14);
		
		JPanel Panneau1 = new JPanel();
		Panneau1.setBounds(20,20,0,0);
		Panneau1.setLayout(null);
		Panneau1.setBackground(new Color(58, 142, 186));
		Panneau1.setForeground(new Color(58, 142, 186));
		
		JPanel PanneauArriere = new JPanel();
		PanneauArriere.setBounds(45,15,710,310);
		PanneauArriere.setLayout(null);
		PanneauArriere.setBackground(Color.black);
		Panneau1.add(PanneauArriere);
		
		JPanel PanneauAffichage = new JPanel();
		PanneauAffichage.setBounds(5,5,700,300);
		PanneauAffichage.setLayout(null);
		PanneauAffichage.setBackground(Color.white);
		PanneauArriere.add(PanneauAffichage);
		
		JLabel objetOptique = new JLabel();
		objetOptique.setText("Objet optique :");
		objetOptique.setFont(PoliceArial_14);
		objetOptique.setForeground(Color.white);
		objetOptique.setBounds(30,375,200,100);
		Panneau1.add(objetOptique);
		
		JLabel choixCouleur = new JLabel();
		choixCouleur.setText("Choisir la couleur du rayon");
		choixCouleur.setForeground(Color.white);
		choixCouleur.setFont(PoliceArial_16);
		choixCouleur.setBounds(30,470,200,100);
		Panneau1.add(choixCouleur);
		
		boutonRayonRouge = new JButton("Rouge");
		boutonRayonRouge.setBounds(200,470,100,50);
		boutonRayonRouge.setBackground(Color.red);
		boutonRayonRouge.setForeground(Color.black);
		boutonRayonRouge.setFont(PoliceArial_16);
		Panneau1.add(boutonRayonRouge);
		boutonRayonRouge.addActionListener(this);
		
		boutonRayonBleu = new JButton("Bleu");
		boutonRayonBleu.setBounds(310,470,100,50);
		boutonRayonBleu.setBackground(Color.blue);
		boutonRayonBleu.setForeground(Color.black);
		boutonRayonBleu.setFont(PoliceArial_16);
		Panneau1.add(boutonRayonBleu);
		boutonRayonBleu.addActionListener(this);
		
		boutonRayonVert = new JButton("Vert");
		boutonRayonVert.setBounds(420,470,100,50);
		boutonRayonVert.setBackground(Color.green);
		boutonRayonVert.setForeground(Color.black);
		boutonRayonVert.setFont(PoliceArial_16);
		Panneau1.add(boutonRayonVert);
		boutonRayonVert.addActionListener(this);
		
		boutonMiroir = new JButton("Miroir");
		boutonMiroir.setBounds(200,400,100,50);
		boutonMiroir.setBackground(Color.black);
		boutonMiroir.setForeground(Color.white);
		boutonMiroir.setFont(PoliceArial_16);
		Panneau1.add(boutonMiroir);
		boutonMiroir.addActionListener(this); 
		
		boutonLentilleC = new JButton("Lentille C");
		boutonLentilleC.setFont(PoliceArial_14);
		boutonLentilleC.setBounds(310,400,100,50);
		boutonLentilleC.setBackground(Color.black);
		boutonLentilleC.setForeground(Color.white);
		Panneau1.add(boutonLentilleC);
		
		boutonLentilleD = new JButton("Lentille D");
		boutonLentilleD.setFont(PoliceArial_14);
		boutonLentilleD.setBounds(420,400,100,50);
		boutonLentilleD.setBackground(Color.black);
		boutonLentilleD.setForeground(Color.white);
		Panneau1.add(boutonLentilleD);
		
		this.add(Panneau1);
				
		this.setVisible(true);
	}

  // A ajouter une fois les objets optiques et le rayon créés
	public void actionPerformed (ActionEvent e){
		
		if (e.getSource()== boutonMiroir){
			System.out.println("Vous avez sélectionné le miroir");
			Miroir nouveauMiroir = new Miroir(280,1000,100,100);
			listeMiroirs.add(nouveauMiroir);
			
			System.out.println("nouveau miroir");
			//if(!listeRayons.isEmpty() && !listeMiroirs.isEmpty())
			
			for (int i = 0; i< listeRayons.size(); i++)
					{
						listeRayons.add(listeRayons.get(i).chercheObstacle(listeMiroirs));
					}
					repaint();
			
			
		}
		if (e.getSource()== boutonRayonRouge){
			System.out.println("Vous avez selectionne le rayon rouge");
			SourceLum lum = new SourceLum (200, 250, 0, 50, Color.red);
			listeSources.add(lum);
			System.out.println("nouvelle source");
			Rayon ray = lum.creationRayon();
			listeRayons.add(ray);
			System.out.println("nouveau rayon");
			
			//if(!listeRayons.isEmpty() && !listeMiroirs.isEmpty())
			{
				ray.chercheObstacle(listeMiroirs);
				repaint();
			}
		}
	}
		
		/*public boolean rayonAjoute()
		{
			
		}
		
		public boolean sourceAjoutee()
		{
			
		}*/
		
		public boolean objetAjoute()
		{
			if(nbObjetsPrecedent != listeMiroirs.size())
			{
				nbObjetsPrecedent = listeMiroirs.size();
				System.out.println("Objet ajouté");
				return true;
			}
			
			else return false;
		}
		
		/*
		public void actualiseRayons()
		{
			if(objetAjoute())
			{
		
				{
					for (Rayon ray : listeRayons)
					{
						ray.chercheObstacle(listeMiroirs);
					}
				}
			}
		}*/
		
	
	public void paint(Graphics g){
		for(Miroir miroir:listeMiroirs){
			miroir.dessin(g);
		}
		
		for(SourceLum src:listeSources){
			src.dessin(g);
		}
		
		for(Rayon ray:listeRayons){
			ray.dessin(g);
		}

	}
		


	
}
	
