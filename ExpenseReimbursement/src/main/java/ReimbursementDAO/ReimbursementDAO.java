package ReimbursementDAO;



import java.util.List;

import Beans.User;
import Beans.UserReimbursement;

public interface ReimbursementDAO {

	User Register(User us);
	User Login(String username, String password);
	public List<UserReimbursement> FindAllReimbursement(UserReimbursement u);
	UserReimbursement SubmitRequest(UserReimbursement us);
	UserReimbursement UpdateStatus(UserReimbursement ur);
}
