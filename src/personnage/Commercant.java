
package personnage;

import personnage.Humain;

public class Commercant extends Humain{

	public Commercant(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
		this.setBoisson("the");
	
	}
	
	public void seFaireExtorquer() {
		this.setArgent(0);
		this.parler("J'ai tout perdu, le monde est trop injuste");
	}
	
	public void recevoirArgent(int i ) {
		this.setArgent(i);
		this.parler(i + " sous ! Je te remercie, genereux donateur !");
	}
	
	public static void main(String[] args) {
		Commercant c1 = new Commercant("Marco", "undefined", 15);
		System.out.println(c1.argent);
		c1.seFaireExtorquer();
		System.out.println(c1.argent);
		c1.recevoirArgent(4445);
		System.out.println(c1.argent);
		
	}
		
}