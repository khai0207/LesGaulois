package personnage;

public class Ronin extends Humain{
	private int honneur = 1;
	private int force = 2*honneur;
	
	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
		// TODO Auto-generated constructor stub
	}
	
	public void don(Commercant c) {
		c.setArgent(c.argent + (getArgent()*10)/100);
		parler(c.getNom() + ", prend ces " + (getArgent()*10)/100 + " sous");
		c.recevoirArgent((getArgent()*10)/100);
	}
	
	public void provoquer(Yakuza yak) {
		if(force >= yak.getReputation()) {
			setArgent(yak.getArgent());
			honneur += 1;
			parler("Je t'ai retrouve vermine, tu vas payer pour ce que tu as fait a ce pauvre marchand");
			parler("Je t'ai eu petit yakusa!");
			yak.perdre();
		} else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup");
			yak.gagner(this);
			honneur -=1;
		}
	}


	public static void main(String[] args) {
		Commercant c1 = new Commercant("Marco", "undefined", 15);
		Ronin ron = new Ronin("Roro", "shoshu", 60);
		
		ron.don(c1);

	}

}