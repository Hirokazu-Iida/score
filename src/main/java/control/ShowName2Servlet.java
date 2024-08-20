package control;

import java.io.IOException;

import bean.StudentDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.StudentDAO;

/**
 * Servlet implementation class ShowName2Servlet
 */
public class ShowName2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String msg="Display all";
		request.setCharacterEncoding("utf-8");
		String btn=request.getParameter("btn");
		
		StudentDAO sdao=new StudentDAO();
		
		if(btn.equals("insert")) {
			int no=Integer.parseInt(request.getParameter("no"));
			String name=request.getParameter("name");
			int score=Integer.parseInt(request.getParameter("score"));
			sdao.insert(no,name,score);
			msg="Insert ID = "+no;
		}else if(btn.equals("update")) {
			int no=Integer.parseInt(request.getParameter("no"));
			String name=request.getParameter("name");
			int score=Integer.parseInt(request.getParameter("score"));
			sdao.update(no,name,score);
			msg="Update ID = "+no;
		}else if(btn.equals("delete")) {
			int no=Integer.parseInt(request.getParameter("no"));
			sdao.delete(no);
			msg="Delete ID = "+no;
		}
		
//		sdao.connect();
//		String name=sdao.select(4);
//		sdao.disconnect();
		StudentDTO sdto=sdao.select();
		
		// リクエストスコープに格納
		request.setAttribute("sdto",sdto);
		request.setAttribute("msg",msg);
	    //JSPにフォワード
	    RequestDispatcher rd = request.getRequestDispatcher("/showname2.jsp");
	    rd.forward(request, response);
	    
	}

}
