package hms;

class PNode{
	Patient patient;
	PNode next,pre;

	public PNode() {
	}

	public PNode(Patient patient) {
		this.patient=patient;
		next=null;
		pre=null;
	}

}

public class PatientList {

	PNode head,tail;
	
	public PatientList() {
		head=null;
		tail=null;

	}
	
	public void Insert(Patient patient) {
		PNode node =new PNode(patient);
		if(head == null|| tail== null) {
			head=node;
			tail=node;
		}
		else {
			head.next=node;
			node.pre=head;
			head=node;
		}
	}

	public Patient searchByID(String id) {
		PNode temp=head;
		while(temp!=null) {
			if(temp.patient.getId().equals(id)) {
				return temp.patient;
			}
			temp=temp.pre;
		}
		return null;
	}

	public Patient searchByContact(String contact) {
		PNode temp=head;
		while(temp!=null) {
			if(temp.patient.getContact().equals(contact)) {
				return temp.patient;
			}
			temp=temp.pre;
		}
		return null;
	}
	
	public void printData() {
		PNode temp = head;
		int cnt = 0;
		while(temp != null) {
			cnt++;
			System.out.println(cnt+" "+temp.patient.toString());
			temp = temp.pre;
		}
	}
}

