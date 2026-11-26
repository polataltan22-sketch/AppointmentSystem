package Pack;

import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {

	
	ArrayList<Diseases> disease = new ArrayList<>();
	ArrayList<Doctors> doctor = new ArrayList<>();
	ArrayList<Patients> patient = new ArrayList<>();
	
	
	
	
	
	
	public void addDisease(int diseaseID,String diseases) {
		Diseases d = new Diseases(diseaseID,diseases);
		
		disease.add(d);
	}
	
	public int diseaseSize() {
		int size = disease.size();
		
		return size;
	}
	
	public void displayDiseases() {
		disease.forEach(d -> {
			d.display();
		});
	}
	
	public void singleDisease(int disId) {
		disease.get(disId).display();
	}
	
	
	
	
	
	
	
	public void addDoctor(int roomNo,String fname,String sname, String workPart,String workSchedule, boolean availability) {
		Doctors doc = new Doctors(roomNo,fname,sname,workPart,workSchedule,availability);
		
		doctor.add(doc);
	}
	
	public int doctorSize() {
		int size = doctor.size();
		return size;
	}
	
	public void displayDoctors() {
		doctor.forEach(doc -> {
			doc.display();
		});
	}
	
	public void singleDoctor(int roomno) {
		doctor.get(roomno).display();
	}
	
	public void deleteDoctor(int roomNo) {
		doctor.removeIf(a -> a.roomNo==roomNo);
	}
	
	public boolean availableCheck(int roomno) {
		return doctor.get(roomno - 1).check();
	}
	
	
	
	
	
	
	
	
	public void addPatient(String name,String surname,int id,boolean appointment) {
		Patients p = new Patients(name,surname,id,appointment);
		
		patient.add(p);
	}
	
	public int patientSize() {
		int size = patient.size();
		return size;
	}

	public void singlePatient(int id) {
		patient.get(id).display();
	}
	

	public void displayPatients() {
		patient.forEach(p -> {
			p.display();
		});
	}
	
	public boolean eligibleCheck(int id) {
		return patient.get(id - 1).checkA();
	}
	

	
	

	
	
	public void viewAppointment(int pat, int doc, int dis) {
		System.out.print("\n-----------------------------------\n");
		System.out.print("\n\n----------- APPOINTMENT -----------\n");
		System.out.println("Appointment details: \n");
		patient.get(pat).displayReceipt();
		doctor.get(doc).displayReceipt();
		doctor.get(doc).unavailable();
		patient.get(pat).notEligible();
		disease.get(dis).display();
		System.out.print("\n------------- RECEIPT -------------\n");
		System.out.print("\n-----------------------------------\n\n");
	}
	
	public void displayReceipt(int pat, int doc, int dis) {
		System.out.print("\n-----------------------------------\n");
		System.out.print("\n\n----------- APPOINTMENT -----------\n");
		System.out.println("Appointment details: \n");
		patient.get(pat).displayReceipt();
		doctor.get(doc).displayReceipt();
		disease.get(dis).display();
		System.out.print("\n------------- RECEIPT -------------\n");
		System.out.print("\n-----------------------------------\n\n");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void displayWelcome() {
		
		for(int firstRow = 0; firstRow < 40 ; firstRow++) {
			System.out.print("=");
		}
		
		System.out.print("\n");
		
		for(int columns = 0;columns < 4 ; columns++) {
			System.out.print("| |");
			
			for(int rows = 0; rows < 35; rows++) {
				if(columns == 1 && rows == 2)
				
				System.out.print("   Hospital Appointment System    ");
				
				else if(columns == 2 && rows == 2) {
				System.out.print("              Ver1.0              ");
				}
				
				else if(columns != 2 && columns != 1 && rows != 20) {
					System.out.print(" ");
				}
			}
			System.out.print("| |\n");
		}
		
		for(int lastRow = 0; lastRow < 40; lastRow++) {
			System.out.print("=");
		}
		
	}
	
	public void menu() {
		
		System.out.println("\n****** MAIN MENU ******\n");
		System.out.println("[1] : Display patients list.");
		System.out.println("[2] : Choose one of the patients to make appointment.");
		System.out.println("[3] : Make an appointment.");
		System.out.println("[4] : Check available doctors to make an appointment with.");
		System.out.println("[5] : Exit program.");
	}

	


	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Hospital app = new Hospital();
		Scanner scn = new Scanner(System.in);
		
		
		int choice = 0;
		int choice_disease = 0;
		int choice_doctor = 0;
		int choice_patient = 0;
		
		
		app.addPatient("Dave", "Gray", 1, true);
		app.addPatient("Mary", "Sunderland", 2, true);
		app.addPatient("Angela", "Orosco", 3, true);
		
		
		app.addDisease(1, "Common cold");
		app.addDisease(2, "Flu");
		app.addDisease(3, "Strep throat");
		app.addDisease(4, "Athlete's foot");
		app.addDisease(5, "Viral gastroenteritis");
		
		
		app.addDoctor(1, "Rick", "Novak", "Afternoon" , "Monday", true);
		app.addDoctor(2, "Susan", "Connor", "Morning" , "Tuesday", true);
		app.addDoctor(3, "Jeff", "Johnson", "Night" , "Wednesday", true);
		app.addDoctor(4, "Melvin", "Forbis", "Afternoon" , "Thursday", true);
		app.addDoctor(5, "Roger", "Lum", "Morning" , "Friday", true);
		
		app.displayWelcome();
		
		do {
				app.menu();
				
				System.out.print("Enter your choice: ");
			while(!scn.hasNextInt()) {
				System.err.println("\nERROR: Invalid input, please enter a number.\n");
					scn.next();
				System.out.print("Enter your choice: ");
			}
			choice = scn.nextInt();
				
				
			switch(choice) {
				case 1:
					app.displayPatients();
					break;
				case 2:
					app.displayPatients();
					do {
							System.out.print("Which patient wants to make an appointment?Enter their ID: ");
						while(!scn.hasNextInt()) {
							System.err.println("ERROR: Please enter a number.");
								scn.next();
							System.out.print("Which patient wants to make an appointment?Enter their ID: ");
						}
						choice_patient = scn.nextInt();
						if (choice_patient < 1 || choice_patient > app.patientSize()) {
							System.err.println("ERROR: Please choose from 1 to "+app.patientSize()+".");
							choice_patient = 0;
						}
						else if (!app.eligibleCheck(choice_patient)) {
							System.err.println("ERROR: This patient ALREADY HAVE appointment.\n");
							choice_patient = 0;
						}
						else
							break;
					}while(choice_patient < 1 || choice_patient > app.patientSize() || !app.eligibleCheck(choice_patient));
					break;
				case 3:
					if(choice_patient == 0) {
						System.err.println("ERROR: Please choose a patient first.");
						break;
					}
					app.displayDiseases();
					do {
						System.out.print("What is their problem?: ");
					while(!scn.hasNextInt()) {
						System.err.println("ERROR: Please enter a number.");
							scn.next();
						System.out.print("What is their problem?: ");
					}
						choice_disease = scn.nextInt();
						if (choice_disease < 1 || choice_disease > app.diseaseSize()) {
							System.err.println("ERROR: Please choose from 1 to "+app.diseaseSize()+".");
							choice_disease = 0;
						}
						else
							break;
					}while(choice_disease < 1 || choice_disease > app.diseaseSize());
					app.displayDoctors();
					do {
						System.out.print("Which doctor would they like to make an appointment with?: ");
					while(!scn.hasNextInt()) {
						System.err.println("ERROR: Please enter a number.");
							scn.next();
						System.out.print("Which doctor would they like to make an appointment with?: ");
						}
						choice_doctor = scn.nextInt();
						if (choice_doctor < 1 || choice_doctor > app.doctorSize()) {
							System.err.println("ERROR: Please choose from 1 to "+app.doctorSize()+".");
							choice_doctor = 0;
						}
						else if (!app.availableCheck(choice_doctor)) {
						    System.err.println("ERROR: The doctor already have an appointment with a patient at that time.");
						    choice_doctor = 0;
						}
						else
							break;
					}
					while(choice_doctor < 1 || choice_doctor > app.doctorSize() || !app.availableCheck(choice_doctor));
					
					app.viewAppointment(choice_patient - 1,choice_doctor - 1,choice_disease - 1);
					choice_patient = 0;
					break;
				case 4:
					app.displayDoctors();
					break;
				case 5:
					System.out.print("Exiting program....");
					break;
				default:
					System.err.println("\nERROR: Invalid input, please enter 1 , 2 , 3 , 4 or 5.\n");
					choice = 0;
					break;
				}
				
		}while(choice != 5);
		
	}
	
}
