package Pack;

public class Doctors implements HInterface {

	int roomNo;
	String fname;
	String sname;
	String workPart;
	String workSchedule;
	boolean availability;
	
	public Doctors(int roomNo, String fname, String sname, String workPart,String workSchedule, boolean availability) {
		this.roomNo = roomNo;
		this.fname = fname;
		this.sname = sname;
		this.workPart = workPart;
		this.workSchedule = workSchedule;
		this.availability = availability;
	}
	
	public void display() {
		System.out.println("\n-Room Number: "+this.roomNo);
		System.out.println("Doctor's Name & Surname : "+this.fname+" "+this.sname);
		System.out.println("Doctor's work time of day: "+this.workPart);
		System.out.println("Doctor's work day: "+this.workSchedule);
		if(availability == true) {
			System.out.println("Status: AVAILABLE for an appointment.\n");
		}
		else {
			System.out.println("Status: UNAVAILABLE for an appointment.\n");
		}
		
	}
	
	public void unavailable() {
		this.availability = false;
		
	}
	public boolean check() {
		return this.availability;
	}
}
