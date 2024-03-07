package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import common.util.CommonUtil;
import user.model.MemberDAOMyBatis;

public class MemberDeleteAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String id = req.getParameter("id");
				
		System.out.println("id " + id);
		MemberDAOMyBatis dao = new MemberDAOMyBatis();
		
		int n = dao.deleteMember(id);
//		System.out.println("delete 3000");

		String msg = (n>0) ? "탈퇴 완료!" : "회원탈퇴 실패"; 
		String loc = (n>0) ? "memberList.do" : "javascript:history.back()";
		
		String viewName = CommonUtil.addMsgLoc(req, msg, loc);
		
		this.setViewName(viewName);
		this.setRedirect(false);

	}

}
