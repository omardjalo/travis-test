package master2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("localhost/additioner/add")
public class AdditionerServlet extends HttpServlet {
	private int paramDefault = 0;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int param1;
			int param2;
			
			
			param1= Integer.parseInt(req.getParameter("param1"));
			
			if(req.getParameter("param2") != null){
					param2 =  Integer.parseInt(req.getParameter("param2"));
			}
			else {
				param2 = paramDefault;
			}
			resp.setContentType("text/plain");
			resp.getWriter().println(param1 + param2);
			System.out.println( "Addition reussie");
		} catch(RuntimeException e){
			resp.setStatus(400);
			resp.setContentType("text/plain");
			resp.getWriter().println("Exécution impossible, paramètre manquant");
		}
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			paramDefault = Integer.parseInt(req.getReader().readLine());
			resp.setContentType("text/plain");
			resp.getWriter().println("ok");
		}
		catch(RuntimeException e){
			resp.setStatus(400);
			resp.setContentType("text/plain");
			resp.getWriter().println("KO");
		}
		
	}
	
	
}
