package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import vo.User;

/**
 * Servlet implementation class Login
 */
@WebServlet(name="LoginController", urlPatterns="/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{  
        String psw = request.getParameter("password");  
        String username = request.getParameter("username");
        String occupation=request.getParameter("occupation");
        User user=new User();
        UserDao userDao=new UserDao();
        
        if(username==null||psw==null||occupation==null){
        	 System.out.println("username and password cannot be null");  
             response.sendRedirect("login.jsp"); 
        }
        
        user.setName(username);       
        user.setPassword(psw);
        user.setOccupation(occupation);
        
        boolean find=userDao.check(user);
       
        if(find){
        	
        		try { 
                	HttpSession session = request.getSession();
                	session.setAttribute("username", username);
                	session.setAttribute("occupation", occupation);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } catch (ServletException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }  
        	}else{
        		System.out.println("password is wrong!");  
                response.sendRedirect("login.jsp");  
             
        	}
               
            
         
    }  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
