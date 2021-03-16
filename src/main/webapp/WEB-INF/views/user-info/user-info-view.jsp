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
<table border="1">
</table>
<script>
window.onload = function() {
	var xhr = new XMLHttpRequest();
	xhr.open('GET', '/user?uiNum=' + ${param.uiNum} );
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
		}
	}
	xhr.send();
}

</script>
</body>
</html>