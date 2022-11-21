package personnage;

public class Yakuza extends Humain{
	
	private int reputation = 0;
	private String clan;

	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
	}
	
	
	
	public String getClan() {
		return clan;
	}



	public void extorquer(Commercant c) {
		
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par la ?");
		parler(c.getNom() + " si tu tiens a la vie, donne moi ta bourse !");
		
		argent += c.getArgent();
		
		parler("J'ai pique les " + c.getArgent() + " sous de " + c.getNom() + ", ce qui me fait " + getArgent() + " sous dans ma poche. Hi Hi !");
		c.seFaireExtorquer();
		reputation += 1;
	}
	

	public int getReputation() {
		return reputation;
	}

	
	public void perdre() {
		parler("J'ai perdu mon duel et mes " + getArgent() + " sous, snif... J'ai deshonore le clan de " + clan);
		reputation -= 1;
		setArgent(0);
		
	}
	
	public void gagner(Ronin ron) {
		setArgent(argent + ron.argent);
		reputation += 1;
		parler("Ce ronin pensait vraiment battre " + getNom() + " du clan de " + clan + "? Je l'ai depouille de ses " + ron.argent + " sous.");
		ron.setArgent(0);
	}
	
	@Override
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + getNom() + " et j'aime boire du " + getBoisson());
		parler("Mon clan est celui de " + getClan());
	}

	public static void main(String[] args) {
		Yakuza yak = new Yakuza("Yaku Le Noir", "Whysky", 30, "Warsong" );
		System.out.println(yak.clan);


	}

}