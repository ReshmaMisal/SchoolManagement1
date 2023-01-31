package ShcoolManagementDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reshu")
public class ValidationStageServer extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		PrintWriter pw = resp.getWriter();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("reshu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
        
		
		Query q = em.createQuery("select a from Principle a where a.email=?1 and a.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		
		List<Principle> principle = q.getResultList();
		
		if(principle.size()>0) {
			
			pw.write("Welcome to Shcool");;
			RequestDispatcher rd = req.getRequestDispatcher("Demo1.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			resp.setContentType("text/html");
			pw.write("incorrect credincial");
			rd.include(req, resp);
			
		}

	
	}
}
