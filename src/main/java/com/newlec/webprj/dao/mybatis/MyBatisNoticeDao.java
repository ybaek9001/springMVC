package com.newlec.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.lf5.util.ResourceUtils;

import com.newlec.webprj.dao.MemberDao;
import com.newlec.webprj.dao.NoticeDao;
import com.newlec.webprj.vo.Member;
import com.newlec.webprj.vo.Notice;

public class MyBatisNoticeDao implements NoticeDao {

	SqlSessionFactory ssf = NewlecSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Override
	public List<Notice> getNotices(int page, String field, String query) {
		SqlSession session = ssf.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class); // mapper按眉 积己
		List<Notice> list = dao.getNotices(page, field, query);

		session.close(); // 技记 辆丰.

		return list;
	}

	@Override
	public Notice getNotice(String code) {
		SqlSession session = ssf.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class); // mapper按眉 积己
		Notice notice = dao.getNotice(code);

		session.close(); // 技记 辆丰.

		return notice;
	}

	@Override
	public int insert(Notice n) throws SQLException {
		SqlSession session = ssf.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);
		int result = 0;

		try {
			result = dao.insert(n);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			session.rollback();
		}

		session.commit();
		session.close();

		return result;
	}

	@Override
	public String getLastCode() {
		SqlSession session = ssf.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);
		String code = dao.getLastCode();
		
		session.close();
		
		return code;
	}

}
