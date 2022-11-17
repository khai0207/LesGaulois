package personnage;
//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
public class Romain {
	private String nom;
	private int force;
	private String texte;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement =0;
			
	public Romain (String nom, int force) {
		this.nom = nom;
		this.force = force;
		}
	public void parler(String texte) {
		System.out.println(prendreParole() + "<<"+ texte + ">>");
	}
	private String prendreParole() {
		return "le romain"+ nom + ":";
	}
//	public void recevoirCoup(int forceCoup) {
//		force -= forceCoup;
//		if (force > 0) {
//		parler("Aie !");
//		} else {
//		parler("J'abandonne...");
//		}
//	}
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// precondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aie");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		switch (force) {
		case 0:
			parler("Aie");
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
		}
		// post condition la force a diminuer
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "\nMais heureusement, grace a mon equipement sa force est diminue de ";
			for (int i = 0; i < nbEquipement;) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			}
			texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'equipement de " + nom.toString() + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2: {
			System.out.println("le soldat " + nom + " est deja bien protege! ");
			break;
		}
		case 1: {
			if (equipements[0] == equipement) {
				System.out.println("le soldat " + nom + " possede deja un " + equipement + "!");
				break;
			}

			else {
				equipement(equipement);
				break;
			}
		}

		default: {
			equipement(equipement);
			break;

		}

		}

	}

	private void equipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'equipe avec un " + equipement + ".");

	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(minus);
		minus.prendreParole();
		minus.parler("je suis le romain Minus ");
		minus.recevoirCoup(8);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);

	}

}