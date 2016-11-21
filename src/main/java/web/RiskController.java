package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.RiskItemDao;
import vo.RiskItem;

/**
 * Servlet implementation class RiskController
 */
@WebServlet(name="RiskController", urlPatterns="/riskItem")
public class RiskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RiskController() {
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
			ArrayList<RiskItem> list=this.list();
			HttpSession session = request.getSession();
			session.setAttribute("riskItemList", list);
			response.sendRedirect("riskItem.jsp"); 
		}else if(method.equals("add")){
			RiskItem riskItem=new RiskItem();
			Calendar c = Calendar.getInstance();
			java.util.Date date = c.getTime();				
			riskItem.setDate(date);
			riskItem.setName(request.getParameter("name"));
			riskItem.setType(request.getParameter("type"));
			riskItem.setPossible(request.getParameter("possible"));
			riskItem.setInfluence(request.getParameter("influence"));			
			riskItem.setCommit(request.getParameter("commit"));
			riskItem.setFollow(request.getParameter("follow"));			
			riskItem.setIsNew("是");
			riskItem.setStatus(request.getParameter("status"));
			riskItem.setSolution("无");
			riskItem.setRa("无");			
			this.add(riskItem);
			response.sendRedirect("riskItemadd.jsp");
		}else if(method.equals("update")){
			RiskItem riskItem=new RiskItem();
			Calendar c = Calendar.getInstance();
			java.util.Date date = c.getTime();				
			riskItem.setDate(date);
			riskItem.setName(request.getParameter("name"));
			riskItem.setType(request.getParameter("type"));
			riskItem.setPossible(request.getParameter("possible"));
			riskItem.setInfluence(request.getParameter("influence"));		
			riskItem.setCommit(request.getParameter("commit"));
			riskItem.setFollow(request.getParameter("follow"));
			riskItem.setIsNew("是");
			riskItem.setStatus(request.getParameter("status"));
			riskItem.setSolution("无");
			riskItem.setRa("无");	
			this.update(riskItem);
			response.sendRedirect("riskItemupdate.jsp");
			
		}else if(method.equals("find")){
			String name=request.getParameter("name");
			ArrayList<RiskItem> list=this.find(name);
			HttpSession session = request.getSession();
			session.setAttribute("riskItemList", list);
			response.sendRedirect("riskItem.jsp"); 
		}
	}
	protected ArrayList<RiskItem> find(String name){
		ArrayList<RiskItem> riskItemList=new ArrayList<RiskItem>();
		RiskItemDao riskItemDao=new RiskItemDao();
		riskItemList=riskItemDao.find(riskItemList,name);
		return riskItemList;
	}
	protected ArrayList<RiskItem> list(){
		ArrayList<RiskItem> riskItemList=new ArrayList<RiskItem>();
		RiskItemDao riskItemDao=new RiskItemDao();
		riskItemList=riskItemDao.list();
		return riskItemList;
	}
	protected  void add(RiskItem riskItem){
		RiskItemDao riskItemDao=new RiskItemDao();
		riskItemDao.add(riskItem);
	}
	protected void update(RiskItem riskItem){
		RiskItemDao riskItemDao=new RiskItemDao();
		riskItemDao.update(riskItem);
	}
	
	
	

}
