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
	
	
	public void addDoctor(int roomNo,String fname,String sname, String workPart,String workSchedule, boolean availability) {
		Doctors doc = new Doctors(roomNo,fname,sname,workPart,workSchedule,availability);
		
		doctor.add(doc);
	}
	
	
	public void addPatient(String name,String surname,int id,boolean appointment) {
		Patients p = new Patients(name,surname,id,appointment);
		
		patient.add(p);
	}
	
	
	public int patientSize(int size) {
		size = patient.size();
		return size;
	}
	public int doctorSize() {
		int size = doctor.size();
		return size;
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
	
	
	public void displayDoctors() {
		doctor.forEach(doc -> {
			doc.display();
		});
	}
	
	
	public void viewAppointment(int pat, int doc, int dis) {
		System.out.print("\n------------------------------\n");
		System.out.print("\n\n--------- APPOINTMENT --------\n");
		System.out.print("Appointment details: \n");
		patient.get(pat).displayR();
		doctor.get(doc).displayR();
		doctor.get(doc).unavailable();
		patient.get(pat).notEligible();
		disease.get(dis).display();
		System.out.print("\n\n---------- RECEIPT -----------\n");
		System.out.print("\n------------------------------\n\n");
	}
	
	public void singularDoctor(int roomno) {
		doctor.get(roomno).display();
	}
	
	public void singularPatient(int id) {
		patient.get(id).display();
	}
	
	public void singularDisease(int disId) {
		disease.get(disId).display();
	}
	public void displayPatients() {
		patient.forEach(p -> {
			p.display();
		});
	}
	
	public void deleteDoctor(int roomNo) {
		doctor.removeIf(a->
						a.roomNo==roomNo);
	}
	
	public void menu() {
		
		System.out.println("\n****** MAIN MENU ******\n");
		System.out.println("[1] : Display patients list.");
		System.out.println("[2] : Choose one of the patients to make appointment.");
		System.out.println("[3] : Make an appointment.");
		System.out.println("[4] : Check available doctors to make an appointment with.");
		System.out.println("[5] : Exit program.");
		System.out.print("Enter your choice: ");
	}
	public boolean eligibleCheck(int id) {
		return patient.get(id - 1).checkA();
	}
	
	public boolean availableCheck(int roomno) {
		return doctor.get(roomno).check();
	}
	
	public static void main(String[] args) {
		Hospital app = new Hospital();
		@SuppressWarnings("resource")
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
		
		System.out.println("-- Welcome to The Hospital Appointment System --");
		
		do {
			
			app.menu();
			choice = scn.nextInt();
			
			switch(choice) {
			case 1:
				app.displayPatients();
				break;
			case 2:
				app.displayPatients();
				System.out.print("Which patient wants to make an appointment?Enter their ID: ");
				choice_patient = scn.nextInt();
				if (choice_patient < 1 || choice_patient > app.patientSize(0)) {
					System.out.println("Invalid input.");
					choice_patient = 0;
					break;
				}
				else if (!app.eligibleCheck(choice_patient)) {
					System.out.println("This patient already have an appointment.\n");
				    break;
				}
				break;
			case 3:
				if(choice_patient == 0) {
					System.out.println("ERROR: Please choose a patient first.");
					break;
				}
				else if (!app.eligibleCheck(choice_patient)) {
					System.out.println("This patient ALREADY HAVE an appointment.\n");
				    break;
				}
				app.displayDiseases();
				System.out.print("What is their problem?: ");
				choice_disease = scn.nextInt();
				if (choice_disease < 1 || choice_disease > app.diseaseSize()) {
					System.out.println("Please choose from 1 to 5.");
					break;
				}
				app.displayDoctors();
				System.out.print("Which doctor would they like to make an appointment with?: ");
				choice_doctor = scn.nextInt();
				choice_doctor -= 1;
				if (!app.availableCheck(choice_doctor)) {
				    System.out.println("The doctor they would like to make an appointment with is busy at that time.");
				    break;
				}
				else if (choice_doctor < 0 || choice_doctor >= app.doctorSize()) {
					System.out.println("Invalid number.");
					break;
				}
				app.viewAppointment(choice_patient - 1,choice_doctor,choice_disease - 1);
				choice_patient = 0;
				break;
			case 4:
				app.displayDoctors();
				break;
			case 5:
				System.out.print("Exiting program....");
				break;
			default:
				System.out.println("\nInvalid input, please enter 1 , 2 , 3 , 4 or 5.\n");
				choice = 0;
				break;
			}
			
		}while(choice != 5);
		
	}

}
