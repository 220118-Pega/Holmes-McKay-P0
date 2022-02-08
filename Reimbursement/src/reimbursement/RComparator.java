package reimbursement;

import java.util.Comparator;

//this class allows sorting of List<Request> objects based on request ID
public class RComparator implements Comparator<Request>{

	@Override
	public int compare(Request o1, Request o2) {
		return o1.getId()-o2.getId();
	}

}
