package com.sjin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.ToDoUserVO;

import dao.ToDoUserDAO;

/**
 * Servlet implementation class IdCheckServlet
 */
@WebServlet("/idCheckServlet")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    /**
     * POST : 아이디 조회, 파라미터로 받은 아이디 일치하는지 비교,
     * 데이터 리턴
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		System.out.println("user_id: " + user_id);
		
		// 받은 user_id 값으로 중복 검사
		
		ToDoUserDAO	tuDAO = ToDoUserDAO.getInstance();
		
		int result = tuDAO.idCheck(user_id);
		System.out.println("doPost RETURN VALUE : " + result);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(result);
	}
}
