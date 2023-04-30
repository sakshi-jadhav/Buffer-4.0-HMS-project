package hms;

class DNode{
	Doctor doctor;
	DNode next,pre;

	public DNode() {
	}

	public DNode(Doctor doctor) {
		this.doctor=doctor;
		next=null;
		pre=null;
	}

}

public class DoctorsList {

	DNode head, tail;

	public DoctorsList() {
		head=null;
		tail=null;
	}

	public void Insert(Doctor doctor) {
		DNode node = new DNode(doctor);
		if(head==null || tail==null) {
			head=node;
			tail=node;
		}
		else {
			head.next=node;
			node.pre=head;
			head=node;
		}
	}

	public Doctor searchByID(String id) {
		DNode temp=head;
		while(temp!=null) {
			if(temp.doctor.getId().equals(id))
			{
				return temp.doctor;
			}
			temp=temp.pre;
		}
		return null;
	}

	public Doctor searchByContact(String contact) {
		DNode temp=head;
		while(temp!=null) {
			if(temp.doctor.getContact().equals(contact))
			{
				return temp.doctor;
			}
			temp=temp.pre;
		}
		return null;
	}

	public Doctor allDoctorsInfo () {
		DNode temp=head;
		while(temp!=null) {
			System.out.println("Doctor ID = "+temp.doctor.getId()+"\tSpeciality = "+temp.doctor.getSpecialty());
			temp=temp.pre;
		}
		return null;
	}

	public int size() {
		DNode temp=head;
		int cnt=0;
		while(temp!=null) {
			cnt++;
			temp=temp.pre;
		}
		return cnt;
	}

	public Doctor getAtIndex(int index ) {
		DNode temp=head;
		for(int i=0; i<index; i++) {
			temp=temp.pre;
		}
		return temp.doctor;
	}



}
