package ferran;





public class Peticions  {

	private String activitat = null;
	private String espai = null;
	private String dataInici = null;
	private String dataFi = null;
	private String mascaraDies = null;
	private String mascaraHores = null;
	private int posicio;

	Peticions(String activitat, String espai, String dataInici, String dataFi,
			String mascaraDies, String mascaraHores, int posicio) {
		this.activitat = activitat;
		this.espai = espai;
		this.dataInici = dataInici;
		this.dataFi = dataFi;
		this.mascaraDies = mascaraDies;
		this.mascaraHores = mascaraHores;
		this.posicio = posicio;

	}
	
	
	public int getPosicio() {
		return posicio;
	}


	public void setPosicio(int posicio) {
		this.posicio = posicio;
	}


	@Override
	public String toString() {
		return activitat + ", " + espai;
	}

	public String getActivitat() {
		return activitat;
	}

	public void setActivitat(String activitat) {
		this.activitat = activitat;
	}

	public String getEspai() {
		return espai;
	}

	public void setEspai(String espai) {
		this.espai = espai;
	}

	public String getDataInici() {
		return dataInici;
	}

	public void setDataInici(String dataInici) {
		this.dataInici = dataInici;
	}

	public String getDataFi() {
		return dataFi;
	}

	public void setDataFi(String dataFi) {
		this.dataFi = dataFi;
	}

	public String getMascaraDies() {
		return mascaraDies;
	}

	public void setMascaraDies(String mascaraDies) {
		this.mascaraDies = mascaraDies;
	}

	public String getMascaraHores() {
		return mascaraHores;
	}

	public void setMascaraHores(String mascaraHores) {
		this.mascaraHores = mascaraHores;
	}


	

	

}
