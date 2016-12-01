package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RiskItemDao;
import vo.RiskItem;
import vo.Sum;

/**
 * Servlet implementation class SumController
 */
@WebServlet(name="SumController", urlPatterns="/sum")
public class SumController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SumController() {
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
		//doGet(request, response);
		String method=request.getParameter("method");
		if(method==null){
			method="list";
		}
		if(method.equals("list")){
			ArrayList<Sum> listget=this.listGet();
			ArrayList<Sum> listproblem=this.listProblem();
			HttpSession session = request.getSession();
			session.setAttribute("sumGetList", listget);
			session.setAttribute("sumProblemList", listproblem);
			response.sendRedirect("sum.jsp"); 
		}else if(method.equals("getMax")){
			String begin=request.getParameter("begin");
			String end=request.getParameter("end");
			ArrayList<Sum> list=this.listGet(begin,end);
			HttpSession session = request.getSession();
			session.setAttribute("sumGetList", list);
			response.sendRedirect("sum.jsp"); 
		}else if(method.equals("problemMax")){
			String begin=request.getParameter("begin");
			String end=request.getParameter("end");
			ArrayList<Sum> list=this.listProblem(begin,end);
			HttpSession session = request.getSession();
			session.setAttribute("sumProblemList", list);
			response.sendRedirect("sum.jsp"); 
		}		
	}
	public ArrayList<Sum> listGet(){
		ArrayList<Sum> result=new ArrayList<Sum>();
		RiskItemDao dao=new RiskItemDao();
		result=dao.listGat(result);
		return result;
	}
	public ArrayList<Sum> listProblem(){
		ArrayList<Sum> result=new ArrayList<Sum>();
		RiskItemDao dao=new RiskItemDao();
		result=dao.listProblem(result);
		return result;
	}
	public ArrayList<Sum> listGet(String begin,String end){
		ArrayList<Sum> result=new ArrayList<Sum>();
		RiskItemDao dao=new RiskItemDao();
		result=dao.listGat(result,begin,end);
		return result;
	}
	public ArrayList<Sum> listProblem(String begin ,String end){
		ArrayList<Sum> result=new ArrayList<Sum>();
		RiskItemDao dao=new RiskItemDao();
		result=dao.listProblem(result,begin,end);
		return result;
	}
	

}
