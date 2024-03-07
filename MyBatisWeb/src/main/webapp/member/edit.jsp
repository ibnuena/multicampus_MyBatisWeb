<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>::회원정보 수정::</title>
</head>
<body>
	<!-- edit.jsp -->
	
<%  // scriptlet 태그 : 자바 코드를 기술
	// 내장 객체 : (request, response, out, session, application, exception)
	
	member.model.MemberVO vo = (member.model.MemberVO)request.getAttribute("user");
	// out.println("<h1>user : " + vo + "</h1>");
	if(vo==null){
		%>
		<script>
			alert('해당 아이디의 회원은 없습니다.');
			history.back();
		</script>
		
		<%
		return;
	}
	
%>

<div id="wrap">
	<form name="mf" method="post" action="MemberUpdateEnd">
		<table border="1" style="width:80%; margin:3em auto">
			<tr>
				<th colspan="2">Member Update - 회원정보 수정</th>
			</tr>
			<tr>
				<th>
					이름
				</th>
				<td>
					<input type="text" name="name" value="<%=vo.getName()%>">
					<%-- jsp 주석
						<%=변수 %> : 변수 값을 출력함
						<%=메서드() %> : 메서드가 반환하는 값을 출력
					 --%>
				</td>
			</tr>
			<tr>
				<th>
					아이디
				</th>
				<td>
					<input type="text" name="id" value="<%=vo.getId()%>" readonly>
				</td>
			</tr>
			<tr>
				<th>
					비밀번호
				</th>
				<td>
					<input type="password" name="pw">
				</td>
			</tr>
			<tr>
				<th>
					연락처
				</th>
				<td>
					<input type="text" name="tel" value="<%=vo.getTel()%>">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<button>수정</button>
				<button type="reset">다시쓰기</button>
			</tr>
		</table>
	
	</form>
</div>
</body>
</html>