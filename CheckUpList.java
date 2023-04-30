package hms;

class CNode {
	Checkup cu;
	CNode next, pre;

	public CNode (Checkup cu) {
		next = pre = null;
		this.cu = cu;
	}
}


public class CheckUpList {

	CNode head, tail;
	int cnt = 0;

	public CheckUpList() {
		head = null;
		tail = null;

	}

	public void Enqueue(Checkup cu) {
		CNode node = new CNode (cu);
		if(head ==null || tail == null) {
			head = node;
			tail = node;
		} 
		else if (head.cu.getPriority() < cu.getPriority()) {
			head.next = node;
			node.pre = head;
			head = node;

		}
		else if(tail.cu.getPriority() >= cu.getPriority()) {
			tail.pre = node;
			node.next = tail;
			tail = node;
		}
		else {
			CNode temp = tail;
			while(temp != null) {
				if(temp.cu.getPriority() >= cu.getPriority()) {
					break;
				}
				temp = temp.next;
			}
		}
		cnt++;
	}

	public Checkup dequeue() {
		if(head==null) {
			return null;
		}
		CNode checkup = head;
		head = head.next;
		return checkup.cu;
	}

	public void addRecommendation(int index, String rec) {
		CNode temp = head;
		int i = 0;
		while (temp != null) {
			if(index == i) {
				temp.cu.setRecomendation(rec);
				break;
			}
			i++;
			temp = temp.pre;
		}
	}

	public Patient getPatient(int index) {
		CNode temp = head;
		int i = 0;
		while (temp != null) {
			if(index == i) {
				break;
			}
			i++;
			temp = temp.pre;
		}
		return temp.cu.getPatient();
	}

	public int size() {
		return cnt;
	}

	public void Print() {
		CNode temp = head;
		while(temp != null) {
			System.out.println(temp.cu.getPriority()+" "+temp.cu.getRecomendation());
			temp = temp.pre;
		}
	}
}
