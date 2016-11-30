package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlanDao;
import dao.RiskItemDao;
import vo.Plan;
import vo.RiskItem;

/**
 * Servlet implementation class PlanController
 */
@WebServlet(name="PlanController", urlPatterns="/plan")
public class PlanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlanController() {
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
			ArrayList<Plan> list=this.list();
			HttpSession session = request.getSession();
			session.setAttribute("planList", list);
			response.sendRedirect("plan.jsp"); 
		}else if(method.equals("add")){
			Plan plan=new Plan();
			plan.setName(request.getParameter("name"));			
			this.add(plan);
			ArrayList<Plan> list=this.list();
			HttpSession session = request.getSession();
			session.setAttribute("planList", list);
			response.sendRedirect("plan.jsp"); 
		}else{
			System.out.println(method);
			ArrayList<RiskItem> list=this.listPlan(method);
			HttpSession session = request.getSession();
			session.setAttribute("riskItemList", list);
			response.sendRedirect("riskItem.jsp"); 
		}
		
		
	}
	protected void add(Plan plan){
		PlanDao planDao=new PlanDao();
		planDao.add(plan);
	}
	
	protected ArrayList<Plan> list(){
		ArrayList<Plan> planList=new ArrayList<Plan>();
		PlanDao planDao=new PlanDao();
		planList=planDao.list();
		return planList;
		
	}
	protected ArrayList<RiskItem> listPlan(String planName){
		ArrayList<RiskItem> riskItemList=new ArrayList<RiskItem>();
		RiskItemDao riskItemDao=new RiskItemDao();
		riskItemList=riskItemDao.listPlan( planName);
		return riskItemList;
	}

}

