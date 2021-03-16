<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>유저리스트</h2>
<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
		</tr>
	</thead>
	<tbody id="tBody">
	</tbody>
</table>
<button onclick="location.href='/views/user-info/user-info-insert'">등록</button>
<script>
window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET', '/users');
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var res = JSON.parse(xhr.responseText);
			var html = '';
			for(var user of res){
				html += '<tr onclick="location.href=\'/views/user-info/user-info-view?uiNum='+ user.uiNum + '\'" style="cursor:pointer">';
				html += '<td>' + user.uiNum + '</td>';
				html += '<td>' + user.uiName + '</td>';
				html += '<td>' + user.uiId + '</td>';
				html += '<td>' + user.uiPwd + '</td>';
				html += '</tr>';
			}
			document.querySelector('#tBody').innerHTML = html;
		}
	}
	xhr.send();
}	
</script>
</body>
</html>