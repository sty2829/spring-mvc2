<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
private String uiName;
private String uiId;
private String uiPwd;
private String uiGenre;
private String uiEmail;
private String uiPhone1;
private String uiPhone2;
private String uiAddress;
private String uiHint;
private String uiAnswer; -->
<h2>유저등록</h2>
<input type="text" id="uiName" placeholder="이름"><br>
<input type="text" id="uiId" placeholder="아이디"><br>
<input type="text" id="uiPwd" placeholder="비밀번호"><br>
<input type="text" id="uiGenre" placeholder="장르"><br>
<input type="text" id="uiEmail" placeholder="이메일"><br>
<input type="text" id="uiPhone1" placeholder="폰앞자리"><br>
<input type="text" id="uiPhone2" placeholder="폰뒷자리"><br>
<input type="text" id="uiAddress" placeholder="주소"><br>
<input type="text" id="uiHint" placeholder="질문"><br>
<input type="text" id="uiAnswer" placeholder="답변"><br>
<button onclick="join()">회원가입</button>
</body>
<script>
function join(){
	var param = {};
	var objs = document.querySelectorAll('input[type=text]');
	for(var i=0; i<objs.length; i++){
		var obj = objs[i];
		var key = obj.id;
		var value = obj.value;
		param[key] = value;
	}
	console.log(param);
	var xhr = new XMLHttpRequest();
	xhr.open('POST', '/user');
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
		}
	}
	xhr.setRequestHeader('content-type', 'application/json;charset=UTF-8')
	xhr.send(JSON.stringify(param));
}
</script>
</html>