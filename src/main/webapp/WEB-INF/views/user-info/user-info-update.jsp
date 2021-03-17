<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>유저수정</h2>
<input type="hidden" id="uiNum">
<input type="hidden" id="credat">
<input type="hidden" id="cretim">
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
<button onclick="update()">회원수정</button>
<script>
	window.onload = function(){
		var xhr = new XMLHttpRequest();
		xhr.open('GET', '/user?uiNum=' + ${param.uiNum});
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200){
				var res = JSON.parse(xhr.responseText);
				for(var key in res){
					var obj = document.querySelector('#' + key);
					if(obj != null){
						obj.value = res[key];
					}
				}
			}
		}
		xhr.send();
	}
	function update(){
		var objs = document.querySelectorAll('input[type="text"],input[type="hidden"]');
		var param = {};
		for(var obj of objs){
			var key = obj.id;
			var value = obj.value;
			param[key] = value;
		}
		console.log(param);
		
		var xhr = new XMLHttpRequest();
		xhr.open('POST', '/user/update');
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200){
				console.log(xhr.responseText);
			}
		}
		
		xhr.setRequestHeader('content-type', 'application/json;charSet=UTF-8');
		xhr.send(JSON.stringify(param));
	}

</script>
</body>
</html>