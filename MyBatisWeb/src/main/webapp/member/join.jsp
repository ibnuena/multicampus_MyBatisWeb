<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	var win = null;
	
	function openWin(){
		var url = "idCheck.do";
		win = open(url, "idCheck", "width=500, height=500, left=100, top=100");
		// get 방식 요청
	}
	
</script>
<div class="container">
<form name="mf" method="post" action="<%=request.getContextPath() %>/signup.do">
		<table border="1" style="width:80%; margin:3em auto">
			<tr>
				<th colspan="2">Signup - 회원가입</th>
			</tr>
			<tr>
				<th>
					이름
				</th>
				<td>
					<input type="text" name="name" required>
				</td>
			</tr>
			<tr>
				<th>
					아이디
				</th>
				<td>
					<input type="text" name="id" required readonly>
					<button type="button" class="btn" onclick="openWin()">중복 확인</button>
				</td>
			</tr>
			<tr>
				<th>
					비밀번호
				</th>
				<td>
					<input type="password" name="pw" required>
				</td>
			</tr>
			<tr>
				<th>
					연락처
				</th>
				<td>
					<input type="text" name="tel">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<button>회원가입</button>
				<button type="reset">다시쓰기</button>
			</tr>
		</table>
	
	</form>

</div>


