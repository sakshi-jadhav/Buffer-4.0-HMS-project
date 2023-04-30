package hms;

public class Checkup {
	Doctor Doctor;
	Patient Patient;
	int Priority;
	String Recomendation,Date;

	public Checkup(Doctor doctor, Patient patient, int priority, String recomendation, String date) {

		this.Doctor = doctor;
		this.Patient = patient;
		this.Priority = priority;
		this.Recomendation = recomendation;
		this.Date = date;
	}

	public Doctor getDoctor() {
		return Doctor;
	}

	public void setDoctor(Doctor doctor) {
		Doctor = doctor;
	}

	public Patient getPatient() {
		return Patient;
	}

	public void setPatient(Patient patient) {
		Patient = patient;
	}

	public int getPriority() {
		return Priority;
	}

	public void setPriority(int priority) {
		Priority = priority;
	}

	public String getRecomendation() {
		return Recomendation;
	}

	public void setRecomendation(String recomendation) {
		Recomendation = recomendation;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	@Override
	public String toString() {
		return "Checkup [Doctor=" + Doctor.toString() + ", Patient=" + Patient.toString() + ", Priority=" + Priority + ", Recomendation="
				+ Recomendation + ", Date=" + Date + "]";
	}



}
