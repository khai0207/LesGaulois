package personnage;

public class Humain {
	private String nom;
	private String boisson;
	public int nbConnaissances = 0;
	private final int MaxConnaissances = 30;
	private Humain [] connex = new Humain[MaxConnaissances];
	public int argent;
	private int cpt = 0;
	
	


	public String getNom() {
		return nom;
	}

	public String getBoisson() {
		return boisson;
	}
	
	public void setBoisson(String boisson) {
		this.boisson = boisson;
	}


	public int getArgent() {
		return argent;
	}
	
		
    public void setArgent(int argent) {
		this.argent = argent;
	}


	public Humain(String nom, String boisson, int argent) {
		super();
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
	}


	public void parler(String texte) {
    	System.out.println(prendreParole() + texte);

    }

    private String prendreParole() {
        return "(" + nom + ")- ";
    }
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + getNom() + " et j'aime boire du " + getBoisson());
	}
	
	public void boire() {
		System.out.println(prendreParole() + "Mmmm, un bon verre de " + getBoisson() + " GLOUPS !");
	}
	
	public void acheter(String bien,int prix) {
		if (prix<=argent) {
			perdreArgent(prix);
			parler("J'ai "+ argent + " sous en poche, je vais pouvoir m'acheter un " + bien + " a " + prix +" sous " );
		} else {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux meme pas m'offrir un kimono a " + prix + " sous.");
		}
	}
	
	public void gagnerArgent(int gain) {
		this.argent = gain;
	}
	public void perdreArgent(int perte) {
		this.argent -= perte;
	}
	
	public void faireConnaissance(Humain homo) {
		System.out.println(getNom() + " rencontre " + homo.getNom());
		direBonjour();
		homo.direBonjour();
		this.memoriser(homo);
		homo.memoriser(this);
	}
	

	
	public void memoriser(Humain homo) {
		if (nbConnaissances < MaxConnaissances) {
			connex[nbConnaissances] = homo;
			nbConnaissances++;
		} else {
			connex[0] = homo;

		}
	
		
	}
	
	public void listerConnaissances() {
		parler("Je connais beaucoup de monde dont : ");
		for(int i=0; i<nbConnaissances; i++) {
			
			System.out.println(connex[i].getNom());
		}
	}


	public static void main(String[] args) {
		Humain h1 = new Humain("Ali", "Orangina", 56);
		h1.perdreArgent(6);
		System.out.println(h1.argent);

	}

}