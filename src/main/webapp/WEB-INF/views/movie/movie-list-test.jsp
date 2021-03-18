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
	<thead id="tHead">
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
			var items = res.response.body.items.item;
			var headHtml = '';
			var bodyHtml = '';
			var isCheck = true;
			headHtml += '<tr>';
			for(var item of items) {
				bodyHtml += '<tr>';
				for(var key in item){
					if(isCheck){
						headHtml += '<th>' + key + '</th>';	
						
					}
					bodyHtml += '<td>' + item[key] + '</td>';
				}
				isCheck = false;
				bodyHtml += '</tr>';
			}
			headHtml += '</tr>';
			document.querySelector('#tHead').innerHTML = headHtml;
			document.querySelector('#tBody').innerHTML = bodyHtml;
		}
	}
	xhr.send();
</script>
</body>
</html>