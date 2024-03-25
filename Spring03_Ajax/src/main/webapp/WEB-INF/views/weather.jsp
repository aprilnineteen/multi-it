<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘의 날씨</title>
	<!-- ----------------------------------------- -->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<!-- -------------------------------------------- -->
	<script>
		$.ajax({
			type:'get',
		url:'http://api.openweathermap.org/data/2.5/weather?lat=37.52586755916735&lng=126.92843481555744&APPID=392555e6851b7a485b617e9b7325307e',	​
				dataType:'json',
			cache:false
		})
			.done((data)=>{
				console.log(JSON.stringify(data));
				alert(data)
			})
			.fail((err)=>{
				alert(err.status)
			})
			//function
	</script>
</head>
<body>
<div class="container py-5">
<h3>서울시의 오늘 날씨</h3>
<h3></h3>       
                 
</div>
</body>
</html>