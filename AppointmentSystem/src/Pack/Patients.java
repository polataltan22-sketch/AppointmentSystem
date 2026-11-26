package Pack;

public class Patients implements HInterface {

	String name;
	String surname;
	int id;
	boolean appointment;
	
	public Patients(String name, String surname, int id, boolean appointment) {
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.appointment = appointment;
	}
	
	public void display() {
		System.out.println("\n-Patient ID: ["+this.id+"]");
		System.out.println("Patient Name: "+this.name);
		System.out.println("Patient Surname: "+this.surname);
		if(appointment == true) {
			System.out.println("This patient is eligible to get an appointment.\n");
		}
		else {
			System.out.println("This patient is NOT eligible to get an appointment(they already have one).\n");
		}
	}
	
	public void displayReceipt() {
		System.out.println("-Patient ID: ["+this.id+"]");
		System.out.println("\nPatient Name: "+this.name);
		System.out.println("Patient Surname: "+this.surname);
	}
	
	public void notEligible() {
		this.appointment = false;
		
	}
	public boolean checkA() {
		return this.appointment;
	}
	
}
