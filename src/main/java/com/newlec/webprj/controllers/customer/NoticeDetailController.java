package com.newlec.webprj.controllers.customer;

public class NoticeDetailController {
	public void ����(){
		String code = request.getParameter("c");

		NoticeDao dao = new MyBatisNoticeDao();
		Notice n = dao.getNotice(code);

		NoticeFileDao fileDao = new MyBatisNoticeFileDao();
		List<NoticeFile> files = fileDao.getNoticeFiles(code);
		
		//View���� ���� �ѱ�鼭 ȣ��
	
	}
}
