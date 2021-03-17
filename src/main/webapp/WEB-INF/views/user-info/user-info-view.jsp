<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>유저 VIEW</h2>
<table border="1" id="viewTable">
</table>
<script>
window.onload = function() {
	var xhr = new XMLHttpRequest();
	xhr.open('GET', '/user?uiNum=' + ${param.uiNum} );
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			var res = JSON.parse(xhr.responseText);
			var html = '';
			html += '<tr><th>번호</th>' + '<td>' + res.uiNum + '</td></tr>';
			html += '<tr><th>이름</th>' + '<td>' + res.uiName + '</td></tr>';
			html += '<tr><th>아이디</th>' + '<td>' + res.uiId + '</td></tr>';
			html += '<tr><th>비밀번호</th>' + '<td>' + res.uiPwd + '</td></tr>';
			html += '<tr><th>장르</th>' + '<td>' + res.uiGenre + '</td></tr>';
			html += '<tr><th>이메일</th>' + '<td>' + res.uiEmail + '</td></tr>';
			html += '<tr><th>폰번호</th>' + '<td>' + res.uiPhone1 + '-' + res.uiPhone2 + '</td></tr>';
			html += '<tr><th>주소</th>' + '<td>' + res.uiAddress + '</td></tr>';
			html += '<tr><th>힌트</th>' + '<td>' + res.uiHint + '</td></tr>';
			html += '<tr><th>답변</th>' + '<td>' + res.uiAnswer + '</td></tr>';
			html += '<tr><th>등록일</th>' + '<td>' + res.credat + '</td></tr>';
			html += '<tr><th>등록시간</th>' + '<td>' + res.cretim + '</td></tr>';
			html += '<tr><th>수정일</th>' + '<td>' + res.moddat + '</td></tr>';
			html += '<tr><th>수정시간</th>' + '<td>' + res.modtim + '</td></tr>';
			html += '<tr><td colspan="2" align="center">';
			html += '<button onclick="location.href=\'/views/user-info/user-info-update?uiNum=' + res.uiNum + '\'">수정</button>';
			html += '<button onclick="userDelete(' + res.uiNum + ')">삭제</button></td></tr>';
			document.querySelector('#viewTable').innerHTML = html;
		}
	}
	xhr.send();
}
	function userDelete(uiNum){
		var xhr = new XMLHttpRequest();
		xhr.open('POST', '/user/delete');
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200){
				console.log(xhr.responseText);
			}
		}
		param = {
				uiNum : uiNum
		}
		xhr.setRequestHeader('content-type', 'application/json;charSet="UTF-8"');
		xhr.send(JSON.stringify(param));
	}

</script>
</body>
</html>