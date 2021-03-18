<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<thead>
		<tr>
			<th>번호(rn)</th>
			<th>썸네일</th>
			<th>제목</th>
			<th>부제</th>
			<th>제작일</th>
			<th>연결 URL</th> <!--  클릭하면 해당 URL 이동 -->
		</tr>
	</thead>
	<tbody id="tBody">
	</tbody>
</table>

<script>
	var xhr = new XMLHttpRequest();
	xhr.open('GET', '/movies');
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var res = JSON.parse(xhr.responseText);
			var itemList = res.response.body.items.item;
			var html = '';
			for(var item of itemList) {
				html += '<tr>';
				html += '<td>' + item.rn + '</td>';
				html += '<td>' + item.referenceIdentifier + '</td>';
				html += '<td>' + item.title + '</td>';
				html += '<td>' + item.alternativeTitle + '</td>';
				html += '<td>' + item.createdDate + '</td>';
				html += '<td><a href="' + item.url + '">' + item.url + '</a></td>';
				html += '</tr>';
			}
			document.querySelector('#tBody').innerHTML = html;
		}
	}
	xhr.send();
</script>
</body>
</html>