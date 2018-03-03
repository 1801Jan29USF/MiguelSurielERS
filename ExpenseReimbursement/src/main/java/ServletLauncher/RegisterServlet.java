package ServletLauncher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import Beans.User;
import ReimbursementDAO.DatabaseDAO;

public class RegisterServlet extends DefaultServlet {
	private Logger log = Logger.getRootLogger();
	private DatabaseDAO userService = new DatabaseDAO();
	public static User u = new User();

	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {	
		super.service(request, response);
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers","Origin, Methods, Credentials, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.setContentType("application/json");
	}
	

// getting the log in information  SUCCESSFUL FROM ANGULAR TO DAO
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// using JSON
		String json = request.getReader().lines().reduce((acc, cur) -> acc + cur).get();
		log.trace("json " + json);
		ObjectMapper om = new ObjectMapper();
		User credentials = (User) om.readValue(json, User.class);
		log.trace(credentials);
		u = userService.Register(credentials);

		if (u != null) {
			HttpSession sess = request.getSession();
			sess.setAttribute("user", u);
			String respjson = om.writeValueAsString(u);
			response.getWriter().write(respjson);
		} else {
			response.setStatus(401);
		}
	}
}

