<%@page import="com.newlec.webprj.dao.mybatis.MyBatisNoticeFileDao"%>
<%@page import="com.newlec.webprj.dao.NoticeFileDao"%>
<%@page import="com.newlec.webprj.vo.NoticeFile"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.newlec.webprj.vo.Notice"%>
<%@page import="com.newlec.webprj.dao.mybatis.MyBatisNoticeDao"%>
<%@page import="com.newlec.webprj.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%

  ServletContext ctx = request.getServletContext();
  String path = ctx.getRealPath("/customer/upload");	//ctx���� ���� ������ ������ ����� ����θ� ���ڷ� �־ ���� ��� ���� ����
  
  /* title = new String(title.getBytes("ISO-8859-1"),"UTF-8");
  content = new String(content.getBytes("ISO-8859-1"),"UTF-8"); */

//������ �������� ���� Request�� MultipartRequest�� �����
  MultipartRequest req = new MultipartRequest(
	   request
	   , path
	   , 1024*1024*10
	   , "UTF-8"
	   , new DefaultFileRenamePolicy() );
  /* request���ڼ���, ���������� ���� ��� path, �뷮����, ���ڵ���ļ���, ������ �̸� ó�����  */  

  
  /*-- notice info -------------------------------------------- */  	
  String title = req.getParameter("title");
  String content = req.getParameter("content");

  NoticeDao noticeDao = new MyBatisNoticeDao();
  Notice n = new Notice();
  n.setTitle(title);
  n.setContent(content);
  n.setWriter("newlec"); //���߿��� �α��� �� ȸ�� ���̵� ��������
  
  int result = noticeDao.insert(n);
  
  
  /*-- noticeFile info -------------------------------------------- */
  String src = req.getOriginalFileName("file"); /* - ���� ���� �̸� */
  
  NoticeFile file = new NoticeFile();
  file.setNoticeCode(noticeDao.getLastCode());
  file.setSrc(src);
  
  NoticeFileDao fileDao = new MyBatisNoticeFileDao();
  fileDao.insert(file);
  
  if(result==1){
   response.sendRedirect("notice.jsp"); //response�� ���尴ü���� ������ϰ� �ᵵ�� / sendRedirect�� �������� �����ִ°�
}
%>

result = <%=result%>