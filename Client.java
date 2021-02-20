
public class Client {

	private String nom;
	private String prenom;
	private String telephone;
	private String numChambre;
	private String Arriver;
	private String Depart;

	public Client(String nom, String prenom, String telephone, String numChambre, String arriver, String depart) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.numChambre = numChambre;
		this.Arriver = arriver;
		this.Depart = depart;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNumChambre() {
		return numChambre;
	}

	public void setNumChambre(String numChambre) {
		numChambre = numChambre;
	}

	public String getArriver() {
		return Arriver.toString();
	}

	public void setArriver(String arriver) {
		Arriver = arriver;
	}

	public String getDepart() {
		return Depart.toString();
	}

	public void setDepart(String depart) {
		Depart = depart;
	}

	@Override
	public String toString() {

		return String.format("%-20s %-20s %-20s %-20s %-20s %-20s", this.nom, this.prenom, this.telephone,
				this.numChambre, this.Arriver, this.Depart);

	}

}
