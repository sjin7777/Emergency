package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.ToDoUserVO;

public class ToDoUserDAO {
	private static ToDoUserDAO instance = new ToDoUserDAO();	

	public ToDoUserDAO(){
	}	
	
	public static ToDoUserDAO getInstance() {
		return instance;
	}
	
	
	
	/*
	 * DB 연결
	 */
	public	Connection getConnection() throws Exception {
//			Connection conn = null;
//			Context initContext = new InitialContext();
//			Context envContext  = (Context) initContext.lookup("java:/comp/env");
//			DataSource ds = (DataSource) envContext.lookup("jdbc/oracle"); // context.xml Resource name과 동일
//			conn = ds.getConnection();
//			return conn;		
			
			Connection conn = null;
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			
			conn = ds.getConnection();
			
			if(conn == null) {
				System.out.println("Connection is null");
			}else {
				System.out.println("Connection Success.");
			}
			return conn;		// 연결 정보를 리턴	
	}
	
	
	
	/*
	 * 조회 
	 * DB에 아이디(pk)로 회원 정보 SELECT
	 */ 
	public ToDoUserVO getMember(String user_id) {
		String sql = "SELECT * FROM todo_user WHERE user_id=?";
		ToDoUserVO tuVO = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				tuVO = new ToDoUserVO();
				
				tuVO.setUser_id(rs.getString("user_id"));
				tuVO.setUser_pwd(rs.getString("user_pwd"));
				tuVO.setUser_nick(rs.getString("user_nick"));
				tuVO.setUser_join_date(rs.getDate("user_join_date"));
				tuVO.setAdmin_code(rs.getInt("admin_code"));
				tuVO.setAccess_code(rs.getInt("access_code"));
			}							
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return tuVO;
	}
	
	
	
	/*
	 * 로그인(사용자 인증)시 사용 메소드 - 로그인 아이디/ 비밀번호
	 */ 
	public int userCheck(String user_id, String user_pwd) {
		int result = -1;
		
		String sql = "select user_pwd from todo_user where user_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			System.out.println("---------------------------------------");
			
			if(rs.next()) {
			System.out.println("sql - user_pwd: " + rs.getString("user_pwd"));
			System.out.println("입력 - user_pwd: " + user_pwd);
			
			if(rs.getString("user_pwd")!=null &&
					rs.getString("user_pwd").equals(user_pwd)) {
				result = 1; 	// 입력한 pwd와 조회한 sql pwd가 일치
			} else {
				result = 0;		// 입력한 pwd와 조회한 sql pwd가 불일치
			}
		} else {
			result = -1;		// DB에 아이디 없음
		}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());	
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)		
					rs.close();
				if(pstmt != null)	
					pstmt.close();
				if(conn != null)	
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());	
				e.printStackTrace();
			}
		}
//		System.out.println("result: " + result);
		return result;	// 정상(1), 비번다름(0), 아이디없음(-1)
	}
	
	

	/*
	 * 아이디 중복검사
	 */ 
	public int idCheck(String user_id) {
		int result = 0;		// 1이면 중복, 0이면 중복아님
		System.out.println("id check user_id: " + user_id);
		
		String sql = " SELECT USER_ID "
				   + " FROM TODO_USER "
				   + " WHERE USER_ID = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {	// 중괄호안의 로직을 수행하려다가
		
			conn = getConnection();
	
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user_id);

			rs = pstmt.executeQuery();
		
			if(rs.next()) {
				String userid = rs.getString("user_id");
				System.out.println("result" + userid);
				// userid가 null 값이 아니고 userid가 공백이 아닐 때
				// userid.equals(문자열변수) 는 boolean 값을 리턴
				if(userid != null && !userid.equals("")) {	// userid가 있으면 result = 1
					result = 1;
				}
			}else {
				System.out.println("------------------------RESULT IS NULL");
			}
		} catch (Exception e) {		// exception이 발생했을 때
			e.printStackTrace();
		} finally {		// 마지막 처리
			try {
				if(rs != null)		
					rs.close();
				if(pstmt != null)	
					pstmt.close();
				if(conn != null)	
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());	
				e.printStackTrace();
			}
		}
		return result;
	}

	
	/*
	 * 생성
	 * DB에 회원 가입 정보 INSERT
	 */
	public int insertMember(ToDoUserVO tuVO) {
		int result = -1;		// 회원가입 실패
		String sql = "INSERT INTO TODO_USER(USER_ID, USER_PWD, USER_NICK) VALUES(?, ?, ?)";

				
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();						
			pstmt = conn.prepareStatement(sql);	
			
			pstmt.setString(1, tuVO.getUser_id());	
			pstmt.setString(2, tuVO.getUser_pwd());
			pstmt.setString(3, tuVO.getUser_nick());
			
			result = pstmt.executeUpdate();	
			
		} catch (Exception e) {
            System.out.println("insertMember SQLE : ");
			e.getStackTrace();
		} finally {			
			try {
				if (pstmt != null)	pstmt.close();
				if (conn != null)	conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return result;
	}	

	
	
	
}
