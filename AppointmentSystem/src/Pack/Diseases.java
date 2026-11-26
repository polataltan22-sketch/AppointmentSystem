package Pack;

public class Diseases implements HInterface {

	int diseaseID;
	String diseases;
	
	public Diseases(int diseaseID, String diseases) {
		this.diseaseID = diseaseID;
		this.diseases = diseases;
	}
	
	
	public void display() {
		System.out.println("\n-Disease "+this.diseaseID+": "+this.diseases+"\n");
	}
	
}
