package com.newlec.webprj.dao;

import java.sql.SQLException;
import java.util.List;

import com.newlec.webprj.vo.Notice;

public interface NoticeDao {
	public List<Notice> getNotices(int page, String field, String query);
	public Notice getNotice(String code);
	public int insert(Notice n) throws SQLException;
	public String getLastCode();
	
}
