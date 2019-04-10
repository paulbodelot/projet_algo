import javax.swing.*;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class FenetreSaisie extends JFrame {
	JTextField angle = new JTextField("angle");
	JTextField posX = new JTextField("position X");
	JTextField posY = new JTextField("position Y");
	
	public FenetreSaisie(String reglageNom){
		setSize(200,100);
		setLocation(800,450);
		setLayout(null);
		
		JPanel conteneur = new JPanel();
		conteneur.setLayout(null) ;
		conteneur.setBounds(0,0,200,100);
		
		conteneur.add (angle);
		conteneur.add (posY);
		conteneur.add (posX);
	}
}

