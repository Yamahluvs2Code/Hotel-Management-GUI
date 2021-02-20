public class Chambre {

	private int num;
	private String type;
	private boolean disponible;

	public Chambre(int num, String type, boolean disponible) {
		this.num = num;
		this.type = type;
		this.disponible = disponible;
	}

	public int getnum() {
		return num;
	}

	public void setnum(int num) {
		this.num = num;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {

		return String.format("%-25s %-25s %-25s", this.type, this.num, this.disponible);
	}

}
