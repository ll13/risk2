package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RiskTypeDao;
import vo.RiskType;




/**
 * Servlet implementation class TriggerController
 */
@WebServlet(name="TriggerController", urlPatterns="/trigger")
public class TriggerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TriggerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method=request.getParameter("method");
		if(method==null){
			method="list";
		}
		if(method.equals("list")){
			ArrayList<RiskType> list=this.list();
			HttpSession session = request.getSession();
			session.setAttribute("risktypelist", list);
			response.sendRedirect("trigger.jsp"); 
		}else if(method.equals("delete")){
			String type=request.getParameter("type");
			this.delete(type);
			ArrayList<RiskType> list=this.list();
			HttpSession session = request.getSession();
			session.setAttribute("risktypelist", list);
			response.sendRedirect("trigger.jsp"); 
		}else if(method.equals("add")){
			RiskType risktype=new RiskType();
			risktype.setType(request.getParameter("type"));
			risktype.setPossible(request.getParameter("possible"));
			risktype.setInfluence(request.getParameter("influence"));
			this.add(risktype);
			response.sendRedirect("triggeradd.jsp");
		}else if(method.equals("update")){
			RiskType risktype=new RiskType();
			risktype.setType(request.getParameter("type"));
			risktype.setPossible(request.getParameter("possible"));
			risktype.setInfluence(request.getParameter("influence"));
			this.delete(risktype.getType());
			this.add(risktype);
			response.sendRedirect("triggerupdate.jsp");
		}
		
		
		
		
		
		
	}
	protected void add(RiskType trigger){
	    RiskTypeDao risktypeDao=new RiskTypeDao();
		risktypeDao.add(trigger);
	}
	protected void delete(String type){
		RiskTypeDao risktypeDao=new RiskTypeDao();
		risktypeDao.delete(type);
	}
	protected ArrayList<RiskType> list(){
		ArrayList<RiskType> risktypelist=new ArrayList<RiskType>();
		RiskTypeDao risktypeDao=new RiskTypeDao();
		risktypelist=risktypeDao.list();
		return risktypelist;
		
	}

}