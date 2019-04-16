import javax.swing.*;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.*;

public class FenetreSaisie extends JDialog implements ActionListener{
	JTextField angle =new JTextField();
	JButton validation = new JButton();
	JTextField taille=new JTextField();
	int[] nouvelElement;
	JOptionPane erreur = new JOptionPane();
	private boolean envoi =true;
	
	public FenetreSaisie(JFrame fenetre, String titre, boolean modal,int[] coordonnes){
		super(fenetre,titre,modal);
		setSize(150,150);
		setLocation(800,450);
		setLayout(null);
		setLayout(null);
		this.setTitle("Saisie definition");
		this.setResizable(false);
		
		
		
		nouvelElement=coordonnes;
		JPanel conteneur = new JPanel();
		conteneur.setLayout(null) ;
		conteneur.setBounds(0,0,150,180);
		
		validation.setBounds(35,100,100,20);
		validation.setText("Valider");
		validation.addActionListener(this);

		JLabel ang = new JLabel();
		ang.setText("Angle");
		ang.setBounds(55,5,40,20);
		
		JLabel ta = new JLabel();
		ta.setText("Taille");
		ta.setBounds(55,50,40,20);
		
		angle.setBounds(55,25,40,20);
		
		
		taille.setBounds(55,70,40,20);

		
		conteneur.add(ta);
		conteneur.add(ang);
		conteneur.add(angle);
		conteneur.add(validation);
		conteneur.add(taille);
		
		
		this.add(conteneur);
		this.setVisible(false);
		
		
	}
	
	
	public void actionPerformed (ActionEvent e){
		if (e.getSource()== validation){
			envoi=true;
			/*String chaine = posX.getText();
			nouvelElement[0] = Integer.parseInt(chaine);
			
			chaine = posY.getText();
			nouvelElement[1] = Integer.parseInt(chaine);*/
			
			String chaine = angle.getText();
			nouvelElement[2] = Integer.parseInt(chaine);
			
			chaine = taille.getText();
			nouvelElement[3] = Integer.parseInt(chaine);
			
					
			if(nouvelElement[3]==0){
				erreur.showMessageDialog(null, "La taille ne peut pas être nulle","erreur", JOptionPane.ERROR_MESSAGE);
				envoi =false;
			} else {
			envoi=true;} 
			
			if(envoi){
				angle.setText("");
				
				taille.setText("");
				
				setVisible(false);
			}
			
		}
	}
}
