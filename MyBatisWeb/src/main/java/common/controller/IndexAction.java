package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.MemberDAOMyBatis;

// SubController (일꾼) -> AbstractAction 추상 클래스를 상속받는다. -> execute() 메서드를 동일하게 구현해야 함(override)
// index.do -> IndexAction을 찾아서 execute()를 호출한 뒤 -> index.jsp로 forward 이동해서 응답
// mapping 정보는 MyMVC/WEB-INF/command.properties 파일에 저장돼있다
public class IndexAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("IndexAction의 execute() 호출됨..");
		
		MemberDAOMyBatis dao = new MemberDAOMyBatis();
		int cnt = dao.getMemberCount();
		
		
		req.setAttribute("msg", "Mybatis ORM Framework 사용");
		req.setAttribute("cnt", cnt);
		// 뷰페이지 지정
		this.setViewName("index.jsp");
		// 이동방식 지정
		this.setRedirect(false); // forward 방식으로 이동
	}

}
