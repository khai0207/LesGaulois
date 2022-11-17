package personnage;


public class Chef {
	private String nom;
	private int force;
	private int effecPotion=1;
	private Village village;
	public Chef(String nom, int force, int effecPotion, Village village) {
		this.nom = nom;
		this.force = force;
		this.effecPotion = effecPotion;
		this.village=village;
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "<<"+ texte + ">>");
	}
	private String prendreParole() {
		return "le chef"+ nom +"du villafe"+village.getNom()+":";
	}
	public void frapper (Romain romain) {
		System.out.println(nom +" envoi un grand coup dans la machoire de " +romain.getNom());
		romain.recevoirCoup(force/3);
	}

}