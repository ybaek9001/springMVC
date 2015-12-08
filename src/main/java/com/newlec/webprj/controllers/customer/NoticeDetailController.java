package com.newlec.webprj.controllers.customer;

public class NoticeDetailController {
	public void 남훈(){
		String code = request.getParameter("c");

		NoticeDao dao = new MyBatisNoticeDao();
		Notice n = dao.getNotice(code);

		NoticeFileDao fileDao = new MyBatisNoticeFileDao();
		List<NoticeFile> files = fileDao.getNoticeFiles(code);
		
		//View에게 모델을 넘기면서 호출
	
	}
}
