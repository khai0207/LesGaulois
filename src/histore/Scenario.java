package histore;

import personnage.Gaulois;
import personnage.Romain;
import personnage.Druide;

public class Scenario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gaulois asterix = new Gaulois("Asterix",8);
		
		Gaulois obelix = new Gaulois("Obelix",10);
		
		Romain minus = new Romain ("Minus",6);
		
		Druide panoramix = new Druide("Panoramix",5,10);
		
		panoramix.parler("Je vais aller preparer une petite potion...");
		
		int forcePotion =panoramix.preparerPotion();
		
		panoramix.booster(obelix);
		
		obelix.parler("Par Belenos, ce n'est pas juste !");
		
		asterix.parler("Merci Druide, je sens que ma force est " + forcePotion + " fois decuplee.");
	
		asterix.parler("Bonjour a tous");
		
		
		minus.parler("UN GAU... UN GAUGAU...");
		
		asterix.frapper(minus);

		asterix.frapper(minus);

		asterix.frapper(minus);	
	}

}