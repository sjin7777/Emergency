// 아이디 중복 체크

// $(document).ready는 화면이 준비가 된 후에 이 function을 실행 
 $(document).ready(function(){
	 $("#id_chk_btn").click(function() {
			var userid = $('input[name=user_id]').val();
			console.log(userid);
			

			if(userid == ''){
				alert('아이디를 입력해주세요.');
				// 더 이상 실행하지 않고 리턴
				return;
			}
			
			$.ajax({      
		        type:"POST",  
		        url: "idCheckServlet",      
		        data: { // json. 다음꺼 구분은 쉼표로
		        	"user_id" :  userid 
		        },      
		        success:function(args){
		        	// 요청이 성공했을 시
		        	if(args == 0)
						alert('사용 가능한 아이디입니다.');
		        	else if(args == 1)
						alert('이미 사용 중인 아이디입니다.');
		        	console.log("success: " + args);
		        },   
		        error:function(e){  
		        	// 요청이 실패했을 시
					alert('에러입니다.');
		        	console.log("error: "+ e);
		        }  
		    }); 
			
//			if ($('.user_id_input').attr("check_result") == "fail"){
//			    alert("아이디 중복체크를 해주시기 바랍니다.");
//			    $('.user_id_input').focus();
//			    return false;
//			  }

		 	}
				 
		 );
	 
	 })

	 
// 패스워드 확인 
// 패스워드와 패스워드 확인이 일치하지 않을 경우 
// alert창을 띄우고, user_pwd2 값을 null로 바꾸고, focus를 맞춤
$(function(){
	// 패스워드 (id = "user_pwd1")
	// 패스워드 확인 (id = "user_pwd2") 
	// blur : 포커스 해제
	$('#user_pwd2').blur(function(){
			// 두 값이 일치하지 않을 경우
		   if($('#user_pwd1').val() != $('#user_pwd2').val()){
			   // '패스워드 확인'의 값이 null이 아니라면
		    	if($('#user_pwd2').val()!=''){
	    		// 경고창 띄우기
			    alert("패스워드가 일치하지 않습니다.");
			    	// '패스워드 확인'의 값을  null로 바꾸고
		    	    $('#user_pwd2').val('');
		    	    // focus를 '패스워드 확인'에 맞춤 
		          $('#user_pwd2').focus();
		       }
		    }
		})  	   
	});
 
 

