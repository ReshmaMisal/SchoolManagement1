package ShcoolManagementDemo;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/reshma")
public class servlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		long phnoeno =Long.parseLong(req.getParameter("phoneno"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("reshu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Principle p = new Principle();
		p.setId(id);
		p.setName(name);
		p.setPhoneno(phnoeno);
		p.setEmail(email);
		p.setPassword(password);
		
		et.begin();
		em.persist(p);
		et.commit();
		
		RequestDispatcher rd = req.getRequestDispatcher("login.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
		
	}
	

}
