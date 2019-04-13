import javax.swing.*;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.*;

public class FenetreSaisie extends JDialog implements ActionListener{
	JTextField angle =new JTextField();
	JTextField posX=new JTextField();
	JTextField posY=new JTextField();
	JButton validation = new JButton();
	JTextField taille=new JTextField();
	int[] nouvelElement;
	JOptionPane erreur = new JOptionPane();
	private boolean envoi =true;
	
	public FenetreSaisie(JFrame fenetre, String titre, boolean modal,int[] coordonnes){
		super(fenetre,titre,modal);
		setSize(150,180);
		setLocation(800,450);
		setLayout(null);
		setLayout(null);
		this.setTitle("création d'un nouveau rayon");
		this.setResizable(false);
		
		
		
		nouvelElement=coordonnes;
		JPanel conteneur = new JPanel();
		conteneur.setLayout(null) ;
		conteneur.setBounds(0,0,150,180);
		
		validation.setBounds(35,130,80,20);
		validation.setText("Valider");
		validation.addActionListener(this);

		angle.setBounds(55,10,40,20);
		angle.setText("angle");
		
		posX.setBounds(55,40,40,20);
		posX.setText("posX");
		
		
		posY.setBounds(55,70,40,20);
		posY.setText("posY");
		
		taille.setBounds(55,100,40,20);
		taille.setText("taille");
		
		conteneur.add(angle);
		conteneur.add(posY);
		conteneur.add(posX);
		conteneur.add(validation);
		conteneur.add(taille);
		
		
		this.add(conteneur);
		this.setVisible(false);
		
		
	}
	
	
	public void actionPerformed (ActionEvent e){
		if (e.getSource()== validation){
			envoi=true;
			String chaine = posX.getText();
			nouvelElement[0] = Integer.parseInt(chaine);
			
			chaine = posY.getText();
			nouvelElement[1] = Integer.parseInt(chaine);
			
			chaine = angle.getText();
			nouvelElement[2] = Integer.parseInt(chaine);
			
			chaine = taille.getText();
			nouvelElement[3] = Integer.parseInt(chaine);
			
			//Verification que la saisie est correcte
			if(nouvelElement[3]==0){
				erreur.showMessageDialog(null, "La taille ne peut pas être nulle","erreur", JOptionPane.ERROR_MESSAGE);
				envoi =false;
			}
			
			if((nouvelElement[0]-Math.cos(nouvelElement[2]*Math.PI/180)*nouvelElement[3]<50)||(nouvelElement[0]+Math.cos(nouvelElement[2]*Math.PI/180)*nouvelElement[3]>750)){
				erreur.showMessageDialog(null, "Position x trop grande ou trop petite","erreur", JOptionPane.ERROR_MESSAGE);
				envoi =false;
			}
			
			if((nouvelElement[1]-Math.sin(nouvelElement[2]*Math.PI/180)*nouvelElement[3]<20)||(nouvelElement[1]+Math.sin(nouvelElement[2]*Math.PI/180)*nouvelElement[3]>320)){
				erreur.showMessageDialog(null, "Position y trop grande ou trop petite","erreur", JOptionPane.ERROR_MESSAGE);
				envoi =false;
			}
			
			if(envoi){
				angle.setText("angle");
				posX.setText("posX");
				posY.setText("posY");
				taille.setText("taille");
				
				setVisible(false);
			}
			
		}
	}
}
