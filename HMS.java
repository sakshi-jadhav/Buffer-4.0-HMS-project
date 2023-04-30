package hms;

import java.util.Calendar;
import java.util.Scanner;

public class HMS {
	public static void main(String[]args) {

		PatientList plist= new PatientList();
		DoctorsList dlist= new DoctorsList();

		

		while(true) {

			MainMenu();
			Scanner s = new Scanner(System.in);
			String choice = s.nextLine();
			if(choice.equals("1")) {
				System.out.println("\n Doctors ID");
				String id= s.nextLine();

				System.out.println("\n Doctors Name");
				String name= s.nextLine();

				System.out.println("\n Doctors Contact");
				String contact= s.nextLine();

				System.out.println("\n Doctors Speciality");
				String spec= s.nextLine();

				System.out.println("\n Doctors Fee");
				int fee = s.nextInt();


				Doctor d = new Doctor(id,name,contact,spec,fee);
				dlist.Insert(d);
			} 
			else if(choice.equals("2")) {

				System.out.println("\n Patient ID");
				String id= s.nextLine();

				System.out.println("\n Patient Name");
				String name=s.nextLine();

				System.out.println("\n Patient Contact");
				String contact = s.nextLine();

				Patient patient = new Patient(id,name,contact);
				plist.Insert(patient);
			}
			else if(choice.equals("3")) {
				dlist.allDoctorsInfo();
			}
			else if(choice.equals("4")) {
				plist.printData();
			}
			else if(choice.equals("5")) {
				System.out.println("\nWelcome To CheckUp Menu");
				CheckUpList[] clist=new CheckUpList[dlist.size()];
				//System.out.println(clist.length);
				for(int i=0;i<clist.length;i++) {
					clist[i]=new CheckUpList();
					Doctor doctor=dlist.getAtIndex(i);
					System.out.println("\n\n Enter Patients For Doctor");
					System.out.println("Name        : "+doctor.getName());
					System.out.println("Speciality  : "+doctor.getSpecialty());
					System.out.println("Fees        : "+doctor.getFees());

					System.out.println("All Patients :");
					plist.printData();

					while(true) {
						System.out.println("Enter Patient Id Or type null to stop");
						String id=s.nextLine();

						if(id.equals("null")){
							break;
						}
						System.out.println("Priority 3 for Emergency, 2 for Intermediate and other key for normal");
						String per=s.nextLine();

						int p=1;

						if(per.equals("3")) {
							p=3;
						}
						else if(per.equals("2")) {
							p=2;
						}

						Patient patient=plist.searchByID(id);
						if(patient==null) {
							System.out.println("\n Invalid Patients ID  \n");
						}
						else {
							Checkup cup= new Checkup(doctor,patient,p,"",""+Calendar.getInstance().getTime().toString());
							clist[i].Enqueue(cup);

						}
					}
				}



				for(int i=0;i<clist.length;i++) {
					System.out.println("\n\n Patient "+(i+1)+" In Queue for Doctor " +dlist.getAtIndex(i).getName());
					if(clist[i] == null) {
						return;
					}
					for(int j=0;j<clist[i].size();j++) {
						System.out.println("Enter Recomendation for Patient:"+clist[i].getPatient(j));
						String rec=s.nextLine();
						clist[i].addRecommendation(j, rec);
					}
				}
			} else if(choice.equals("6")) {
				
			}

			else if(choice.equals("0")) {
				return;
			}
			System.out.println(" -- Thank you --");
		}
	}

	public static void MainMenu() {
		System.out.println("---------------------------------");
		System.out.println("\t\tHMS");
		System.out.println("---------------------------------");
		System.out.println("1. Insert new Doctor");
		System.out.println("2. Insert Patient");
		System.out.println("3. Print all doctors");
		System.out.println("4. Print all patients");
		System.out.println("5. CheckUp menu");
		System.out.println("6. Show the queue of patients");
		System.out.println("0. Exit");
		System.out.print("Enter your choice : ");
	}

}


