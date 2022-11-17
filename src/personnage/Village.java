package personnage;

public class Village {
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private String nom;
	private Chef chef;

	public Village(String nom, int nbVillageoisMaximum) {
		villageois = new Gaulois[nbVillageoisMaximum];
		this.nom = nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois gauloisAAjouter) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gauloisAAjouter;
			nbVillageois++;
		}

	}

	public Gaulois trouverHabitant(int numVillageois) {
		return villageois[numVillageois];

	}

	public void afficherVillageois() {
		String info = "Dans village du chef " + chef.getNom() + " vivent les legendaires gaulois:";

		System.out.println(info);
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println(villageois[i].getNom());

		}
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irreductibles", 30);

		Chef chef = new Chef("Abraracourcix",5, 10, village);
		village.setChef(chef);
		Gaulois asterix = new Gaulois("asterix", 8);
		village.ajouterHabitant(asterix);

		Gaulois obelix = new Gaulois("obelix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();

	}

}