package ServletLauncher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import Beans.User;
import Beans.UserReimbursement;
import ReimbursementDAO.DatabaseDAO;

public class PendingServlet extends DefaultServlet {
	 private DatabaseDAO dao = new DatabaseDAO();
     private Logger log = Logger.getRootLogger(); 
     private UserReimbursement reim = new UserReimbursement();
     private User user = new User();
	 
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {	
		super.service(request, response);
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers","Origin, Methods, Credentials, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.setContentType("application/json");
	}
	
	
	// the information they want to receive 
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			if(request.getSession().getAttribute("user") == null) {
				response.setStatus(403);
				return;
			}
			
		    List<UserReimbursement> tickets = dao.FindAllReimbursement(reim);
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(tickets);
	        response.getWriter().write(json);
	        
	        
		}	
}
