package personnage;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion=1;
	private int nb_trophees;
	private Equipement trophees[] = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "<<"+ texte + ">>");
	}
//	private String prendreParole() {
//		return "le Gaulois"+ nom + ":";
//	}
	private String prendreParole() {
		String texte = "Le gaulois " + nom + " : ";
		return texte;
	}

//	public void frapper (Romain romain) {
//		System.out.println(nom +" envoi un grand coup dans la machoire de " +romain.getNom());
//		romain.recevoirCoup(force/3);
//	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mechoire de " + romain.getNom());
		Equipement trophees[] = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nb_trophees++) {
		this.trophees[nb_trophees] = trophees[i];
		}
		return;
	}
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois decuplee.");
	}	
	public void faireUneDonnation(Musee musee) {
	    if (nb_trophees != 0) {
	    	String texte = "Je donne au musee tous mes trophees : ";
	    	for (int i = 0; i < nb_trophees; i++) {
	            texte += "\n- " + trophees[i];
	            musee.donnerTrophees(this, trophees[i]);
	            trophees[i] = null;
	         }
	    	nb_trophees = 0;
	        parler(texte);
	    }
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) {
	      Gaulois asterix = new Gaulois("Asterix", 8);
	      System.out.println("Test methode getNom");
	      System.out.println(asterix.getNom());
	      System.out.println("\nTest methode prendreParole");
	      asterix.prendreParole();
	      System.out.println("\nTest methode parler");
	      asterix.parler("Bonjour");
	      System.out.println("\nTest methode frapper");
	      asterix.frapper(new Romain("Minus", 6));
	      asterix.boirePotion(5);;
	}
}	