<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파파고 번역</title>
<style>
#main{
	margin: 0 auto;
	margin-top: 200px;
	width: 1200px;
	height: 350px;
}

#srcDiv{
	position: relative;
	width: 500px;
	height: 350px;
	border: 1px solid;
}
#tarDiv{
	position: relative;
	left: 600px;
	bottom: 350px;
	width: 500px;
	height: 350px;
	border: 1px solid;
}
#srcSelectBox{
	width: auto;
	height: 50px;
	border:1px solid;
}
#tarSelectBox{
	width: auto;
	height: 50px;
	border:1px solid;
}
select{
	margin-top: 2.5px;
	height: 45px;
	width: 100px;
}
.bodyText{
	border:1px solid;
	
	height: 250px;

}
.bottomLine{
	border:1px solid;
	height: 45px;
}
</style>
</head>
<body>
	<div id="main">
		<div id="srcDiv">
			<div id="srcSelectBox">
				<select id="source" onchange="changeLang()">
					<option selected value="ko">한국어</option>
					<option value="en">영어</option>
				</select>
			</div>
			<div class="bodyText">
				<textarea rows="16" cols="73" id="sourceText"></textarea>
			</div>
			<div class="bottomLine" align="right">
				<button onclick="goTrans()">번역하기</button>
			</div>
		</div>
		<div id="tarDiv">
			<div id="tarSelectBox">
				<select id="target">
					<option selected value="en">영어</option>
					<option value="zh-CN">중국어 간체</option>
					<option value="zh-TW">중국어 번체</option>
					<option value="es">스페인어</option>
					<option value="fr">프랑스어</option>
					<option value="vi">베트남어</option>
					<option value="th">태국어</option>
					<option value="id">인도어</option>
				</select>
			</div>
			<div class="bodyText">
				<textarea rows="16" cols="73" readonly id="transText"></textarea>
			</div>
			<div class="bottomLine">
			</div>
		</div>
	</div>

	<script>
		function goTrans(){
			var source = document.querySelector('#source').value;
			var target = document.querySelector('#target').value;
			var sourceText = document.querySelector('#sourceText').value;
			
			var param = 'source=' + source + '&';
			param += 'target=' + target + '&';
			param += 'text=' + sourceText + '&';
			console.log(param);
			var xhr = new XMLHttpRequest();
			xhr.open('GET', '/papago?' + param);
			xhr.onreadystatechange = function() {
				if(xhr.readyState == 4 && xhr.status == 200){
					var res = JSON.parse(xhr.responseText);
					var result = res.message.result;
					console.log(result);
					document.querySelector('#transText').value = result.translatedText;
				}
			}
			xhr.send();
		}
		
		function changeLang(){
			var lang = document.querySelector('#source').value;
			var html = '';
			if(lang=='en'){
				html += '<option selected value="ko">한국어</option>';
				html += '<option value="ja">일본어</option>';
				html += '<option value="fr">프랑스어</option>';
			}else{
				html += '<option selected value="en">영어</option>';
				html += '<option value="zh-CN">중국어 간체</option>';
				html += '<option value="zh-TW">중국어 번체</option>';
				html += '<option value="es">스페인어</option>';
				html += '<option value="fr">프랑스어</option>';
				html += '<option value="vi">베트남어</option>';
				html += '<option value="th">태국어</option>';
				html += '<option value="id">인도어</option>';
			}
			document.querySelector('#target').innerHTML = html;
		}
	</script>
</body>
</html>