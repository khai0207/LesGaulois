package personnage;
import java.util.Random;

public class Druide {
	private String nom;
	private int effecPotionMin;
	private int effecPotionMax;
	private int forcePotion =1;
	public Druide(String nom, int effecPotionMin, int effecPotionMax) {
		this.nom = nom;
		this.effecPotionMin = effecPotionMin;
		this.effecPotionMax = effecPotionMax;
		parler("Bonjour, je suis le druide " + nom +"et ma potion peur aller  d'une force " + effecPotionMin + " a " + effecPotionMax);
	}
	
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "<<"+ texte + ">>");
	}
	
	private String prendreParole() {
		return "le druide"+ nom + ":";
	}
	
	public int preparerPotion () {
		Random test = new Random();
		int effetPotion = this.effecPotionMin-1;
		while (effetPotion< this.effecPotionMin) {
			effetPotion = test.nextInt(this.effecPotionMax+1);
		}
		this.forcePotion = effetPotion;
		if (this.forcePotion > 7) {
			this.parler(" J'ai  prepare une super potion de force " + this.forcePotion);
		} else {
			this.parler("Je  n'ai  pas  trouve  tous  les  ingredients,  ma  potion  est seulement de force "+ this.forcePotion);
		}
		return forcePotion;
	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom()=="Obelix") {
			this.parler("Non, Obelix !... Tu n'auras pas de potion magique");
		}else {
			gaulois.boirePotion(this.forcePotion);
		}
	}

	public static void main(String[] args) {
		Druide panoramix = new Druide("panoramix", 5, 10);
		panoramix.preparerPotion();
	}A

}