package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import common.util.CommonUtil;
import user.model.MemberDAOMyBatis;

public class IdCheckAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 요청방식에 따라 로직을 달리 처리하자
		String method = req.getMethod();
		System.out.println("method: " + method);

		// get 방식 요청이면 id 입력 form을 보여주고
		if(method.equalsIgnoreCase("get")) {
			this.setViewName("/member/idCheck.jsp");
		}else {// post 방식 요청이면 id 사용 가능 여부를 보여주자
			String id = req.getParameter("id");
			if(id==null || id.trim().isBlank()) {
				this.setViewName(CommonUtil.addMsgBack(req, "아이디를 입력하세요"));
				this.setRedirect(false);
				return;
			}
			
			MemberDAOMyBatis dao = new MemberDAOMyBatis();
			boolean isUse = dao.idCheck(id);
			// 사용 가능하면 true, 중복 아이디면 false
			String msg = (isUse) ? id + "는 사용 가능한 id입니다" : id + "는 이미 사용중인 id입니다";
			String result = (isUse) ? "ok" : "fail";
			
			req.setAttribute("msg", msg);
			req.setAttribute("result", result);
			req.setAttribute("uid", id);
			
			this.setViewName("/member/idCheckResult.jsp");
		}
		
		this.setRedirect(false);
	}

}
