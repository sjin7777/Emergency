<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Emergency</title>
    <link rel="stylesheet" href="./css/default.css">
    <script type="text/javascript" src="./js/jq.js"></script>
    <script type="text/javascript" src="./js/ToDoUser.js"></script>
    <style>
        h3{
            text-align: center;
            /* border: 2px solid blue; */
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
            <h3>회원가입</h3>
            <form action="joinServlet" method="post" class="join_form">
                <table>
                    <tr>
                        <td>아이디 *</td>
                        <td><input type="text" name="user_id" placeholder="영문 소문자, 숫자  2 ~ 12자 이내로 입력" size="40">
                            <button id="id_chk_btn" class="btn_id" type="button">중복 검사</button>
                        </td>
                    </tr>
                    <tr>
                        <td>패스워드 *</td>
                        <td><input type="password" name="user_pwd" id="user_pwd1" class="pwd" size="40"></td>
                        <!-- <td>영문 대, 소문자, 숫자, 특수문자 8 ~ 20자 이내로 입력</td> -->
                    </tr>
                    <tr>
                        <td>패스워드 확인 *</td>
                        <td><input type="password" name="user_pwdck"  id="user_pwd2" class="pwd" size="40"></td>
                    </tr>
                    <tr>
                        <td>닉네임 *</td>
                        <td><input type="text" name="user_nick" placeholder="2 ~ 20자 이내로 입력" size="40"></td>
                    </tr>
                    <tr>
                        <td><br>약관어쩌고저쩌고 동의하시겠습니까?</td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="취소"></td>
                        <td><input type="submit" value="가입하기"></td>
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
</body>
</html>