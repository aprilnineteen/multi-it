<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피자 주문서</title>
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
		let req=false;
			
		const init=function(){
			try{
			req=new XMLHttpRequest();
			console.log('req: '+req);
			}catch(e){
				alert('request 생성 실패');
			}
			}
	
	const getUserInfo=function(){ 
		//alert('a')
		//1. 사용자가 입력한 연락처 정보를 알아내자
		let tel=$('#phone').val(); //document.getElementById('phone').value
		//alert(tel);
		//2. Ajax로 요청을 보내 보자
		//[1] 요청을 준비하는 단계 => XMLHttpRequest의 open(요청 방식, url, [비동기여부])
		//let url="pizzaResult.jsp?phone="+tel; // 쿼리 스트링, text data를 생성
		//let url="pizzaResultXml.jsp?phone="+tel; // 쿼리 스트링, xml data 생성, db 연동
		  let url="pizzaResultJson.jsp?phone="+tel; // xml data 생성
		req.open('GET', url, true) //true => 비동기 방식으로 요청을 보낸다 (디폴트)
		//[2] 요청을 보내기 전에 onreadystatechange 속성값에 콜백함수 지정
		req.onreadystatechange = updatePage;
		//[3] 요청을 전송하는 단계 => send(파라미터 데이터들)
		req.send(null);
		//get: null을 전달 (body가 비어서 가기 때문)
		//post: phone=1111&id=hong (body 데이터)
	}
		const updatePage=function(){
			if(req.readyState==4 && req.status==200){
				let res=req.resposeText;
				//alert(res+", typeof res: "+typeof(res)); //string
				//[1] JSON.parse(문자열) => 문자열이 json객체로 변환된다
				//[2] JSON.stringify(json객체) => json객체를 문자열로 변환함
				
				let obj = JSON.parse(res);
				//alert(obj+", typeof(obj): "+typeof(obj))
				let num = obj.num;
				let name = obj.name;
				let phone = obj.phone;
				let addr = obj.addr;
				
				if(parseInt(num)==0){
					$('#nonUser').show(1000);//보여 주기
					$('#userInfo').html("").hide(1000);//감추기
					$('#addr').focus();
				}else{
					let str=`
					<div class="alert alert-danger my-3">
						<h3>회원 번호: \${num}</h3>
						<h3>회원 이름: \${name}</h3>
						<h3>회원 주소: \${addr}</h3>
						<h3>회원 연락처: \${phone}</h3>
						</div>
						`;
						$('#userInfo').html(str).show(1000);
						$('#nonUser').hide();
						$('#addr').val("");
				}
			}//if
		}
	
	
	
		//2. xml로 받을 경우
		const updatePage2=function(){
		if(req.readyState==4 && req.status==200){
			let res = req.responseXML; //xml로 받을 경우 => XMLDocument 객체로 응답 온다=>이 문서를 파싱하여 필요한 데이터를 추출한다=>jquery의 find()
			//alert(res);
			let num = $(res).find('num').text(); //랩핑 후 엘리먼트명
			if(parseInt(num)==0){//비회원일 경우
				$('#nonUser').show(1000);//보여 주기
				$('#userInfo').html("").hide(1000);//감추기
				$('#addr').focus();
			}else{//회원일 경우
			let name=$(res).find('name').text();
			let addr=$(res).find('addr').text();
			let phone=$(res).find('phone').text();
			
			//phone 태그의 type 속성을 찾아 넣으세요 정적: attr(), 기능적: prop()
			let phoneType=$(res).find('phone').attr('type');
			
			let str=`
			<h3>회원 번호: \${num}</h3>
			<h3>회원 이름: \${name}</h3>
			<h3>회원 주소: \${addr}</h3>
			<h3>회원 연락처[\${phoneType}]: \${phone}</h3>
			`;
			$('#userInfo').html(str).show(1000);
			$('#nonUser').hide();
			$('#addr').val("");
		}//else
		}//if
		}//
	
		//응답 데이터를 1. text형태(html) 2. xml *파싱이 어렵다 3. json *파싱이 쉽다
		//1. text로 받을 경우
		const updatePage1=function(){
			//alert(req.readyState+"/"+req.status);
			if(req.readyState==4 && req.status==200){//데이터 수신이 완료되면 4를 반환
				//응답 데이터 받기 1. text(html) 형식이면 responseText로 받고
				//			 2. xml 형식이면 reqponseXML
				//			 3. json 형식이면 responseText로 받은 뒤 JSON.parse() 함수 이용해 문자열을 json 객체로 변환
				let res=req.responseText;
				//alert(res);
				//'#' 구분자를 기준으로 쪼개어 배열에 저장
				let tokens=res.split('#')
				//tokens[0]:회원 번호 tokens[1]=이름...
				let str="<h3>회원 이름: "+tokens[1]+"</h3>";
				let str2=`
					<h3>회원 주소: \${tokens[2]}</h3>
					<h3>회원 연락처: \${tokens[3]}</h3>
				`;
				$('#userInfo').html(str);
				$('#address').html(str2);
				
			}
		}//---------------------
	
	window.onload = init; //$(function(){})
	</script>
</head>
<body>
<div class="container py-5">
    
    <h1 class="m-4 text-center">Pizza Order Page</h1>
    
    <form role="form" class="form-horizontal" 
    name="orderF" id="orderF"
     action="order.jsp" method="POST">
        <div class="form-group">
            <p class="text-info">
            <b>귀하의 전화번호를 입력하세요:</b>
            <input type="text" size="20" name="phone" id="phone" onchange="getUserInfo()"  class="form-control"/>
            </p>
            <p class="text-danger">
            <b>
                귀하가 주문하신 피자는 아래 주소로 배달됩니다.
            </b>  
            </p>
            <div id="userInfo"></div>
            <div id="address"></div>
            <!-- 비회원 입력 폼 : 비회원일 경우 주소입력 폼을 보여주자.-->
            <div id="nonUser" style="display:none;">
                주소: <input type="text" name="addr" id="addr"
                        size="60" style="border:2px solid maroon;" class="form-control"/>
            </div>
            <!-- ------------------------------------------- -->
            <p class="text-info">
            <b>주문 내역을 아래에 기입하세요</b></p>
            <p>
                <textarea name="orderList"
                 id="orderList" rows="6" cols="50" class="form-control"></textarea>
            </p>
            <p>
                <input type="submit" value="Order Pizza" class="btn btn-primary"/>
            </p>
        </div>
    </form>
</div>
</body>
</html>