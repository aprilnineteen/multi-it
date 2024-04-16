<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<script>
	$(()=>{
		$('#frm').on('submit', (e)=>{
			e.preventDefault();
			let str=$('input[name=ko]').val();
			if(!str){
				alert("내용을 입력하세요");
				return;
			}
			
			//alert(str);
			$.ajax({
				type:'post',
				url:'papago_trans',
				data:{
					str:str
				},
				dataType:'json',
				cache:false,
				success:function(res){
					alert(JSON.stringify(res));
					$('#result').html("<h3>"+res.message.result.translatedText+"</h3>")
					.addClass("alert alert-success");
				},
				error:function(err){
					alert('err')
				}
			})
			
			
		})//#frm end--------------
		
	})//$() end
</script>

<h3>번역할 데이터 입력</h3>
<form id="frm">
	<div class="my-3 py-3">
		<label>번역할 한글 문장 입력</label>
		<input type="text" name="ko" class="form-control">
	</div>
	<button class="btn btn-danger">한글을 영어로 번역합니다</button>
</form>
<hr>
<div id="result">
<!-- 여기에 번역된 내용이 나올 예정 -->
</div>