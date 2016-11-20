package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import vo.User;

/**
 * Servlet implementation class AdminController
 */
@WebServlet(name="AdminController", urlPatterns="/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
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
			ArrayList<User> list=this.list();
			HttpSession session = request.getSession();
			session.setAttribute("userList", list);
			response.sendRedirect("admin.jsp"); 
		}else if(method.equals("delete")){
			String id=request.getParameter("id");
			this.delete(id);
			ArrayList<User> list=this.list();
			HttpSession session = request.getSession();
			session.setAttribute("userList", list);
			response.sendRedirect("admin.jsp"); 
		}else if(method.equals("add")){
			User user=new User();
			user.setId(request.getParameter("id"));
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setOccupation(request.getParameter("occupation"));
			this.add(user);
			response.sendRedirect("adminadd.jsp");
		}else if(method.equals("update")){
			User user=new User();
			user.setId(request.getParameter("id"));
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setOccupation(request.getParameter("occupation"));
			this.delete(user.getId());
			this.add(user);
			response.sendRedirect("adminupdate.jsp");
		}
		
		
	}
	protected void add(User user){
		UserDao userDao=new UserDao();
		userDao.add(user);
	}
	protected void delete(String id){
		UserDao userDao=new UserDao();
		userDao.delete(id);
	}
	protected ArrayList<User> list(){
		ArrayList<User>userList=new ArrayList<User>();
		UserDao userDao=new UserDao();
		userList=userDao.list(userList);
		return userList;
		
	}

}
