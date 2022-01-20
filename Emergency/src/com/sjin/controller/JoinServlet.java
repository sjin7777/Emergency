package com.sjin.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ToDoUserDAO;
import dto.ToDoUserVO;

/**
 * Servlet implementation class JoinServelet
 */
@WebServlet("/joinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public JoinServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("join.jsp");
		dispatcher.forward(request, response);
    	
    };

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 회원 가입에서 작성한 정보들을 getParameter를 통해 가져옴
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		String user_nick = request.getParameter("user_nick");
//		Date user_join_date = new Date();
//		String admin_code = request.getParameter("admin_code");
//		String access_code = request.getParameter("access_code");
		
		ToDoUserVO tuVO = new ToDoUserVO();

		tuVO.setUser_id(user_id);
		tuVO.setUser_pwd(user_pwd);
		tuVO.setUser_nick(user_nick);
//		tuVO.setUser_join_date(user_join_date);
//		tuVO.setAdmin_code(Integer.parseInt(admin_code));
//		tuVO.setAccess_code(Integer.parseInt(access_code));

		ToDoUserDAO	tuDAO = ToDoUserDAO.getInstance();
		
		int result = tuDAO.insertMember(tuVO);
		
		HttpSession session = request.getSession(); 
		
		System.out.println("result: " + result);
		
		
		if(result == 1) {
			System.out.println("회원가입 성공");
			request.setAttribute("message", "회원가입에 성공하였습니다.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);		// 페이지 이동
		} else {
			System.out.println("회원가입 실패");
			request.setAttribute("message", "회원가입에 실패하였습니다.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("join.jsp");
			dispatcher.forward(request, response);		// 페이지 이동
		}
		
		
	}

}
