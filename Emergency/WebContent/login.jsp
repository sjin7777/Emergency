<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Emergency</title>
<link rel="stylesheet" href="./css/default.css">
    <script type="text/javascript" src="./js/jq.js"></script>
    <script type="text/javascript"></script>
<style>
    h3{
        text-align: center;
    }
    
    table{
        margin: auto;
        text-align: center;
    }
</style>
</head>
<body>
	<%-- 헤더 --%>
	<jsp:include page="/layouts/headerA.jsp" />
	
	<%--본문 --%>
	<section>
        <div class="layout_wrap">
            <h3>로그인</h3>
            <form action="loginServlet" method="post" class="login_form">
                <table>
                    <tr>
                        <td>아이디</td>
                        <td><input type="text" name=user_id></td>
                    </tr>
                    <tr>
                        <td>패스워드</td>
                        <td><input type="password" name="user_pwd"></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="로그인" style="background-color: #FFAB40; color: white; border: none;">
                        </td>
                    </tr>
                    <tr>
						<td colspan="2">${message}</td>
					</tr>
                </table>
            </form>
        </div>
    </section>
	
	<%-- 푸터 --%>
	<jsp:include page="/layouts/footer.jsp" />
</body>
</html>