package com.sjin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ToDoUserDAO;
import dto.ToDoUserVO;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="login.jsp";
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") != null) {
			url = "main.jsp";				// 메인 페이지로 이동
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);	
		dispatcher.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "login.jsp";
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
				
		ToDoUserDAO tuDAO = ToDoUserDAO.getInstance();
		
		
		int result = tuDAO.userCheck(user_id, user_pwd);
		
		if (result == 1) {
			ToDoUserVO tuVO = tuDAO.getMember(user_id);
			
			HttpSession session = request.getSession();	
			
			session.setAttribute("loginUser", tuVO);
			

			out.print("인증이 완료되었습니다.");	
			request.setAttribute("message", "인증이 완료되었습니다.");
			url = "main.jsp";
			
		} else if (result == 0 ) {
			out.print("비밀번호가 맞지 않습니다.");				
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
			
		} else {
			out.print("존재하지 않는 회원입니다.");				
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}
		
		System.out.println("url : " + url);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);			
		
	}

}
