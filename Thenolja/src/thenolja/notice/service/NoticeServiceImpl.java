package thenolja.notice.service;

import static thenolja.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import thenolja.notice.dao.NoticeDao;
import thenolja.notice.model.vo.Notice;


public class NoticeServiceImpl{

	
	/*
	 * �������� ��� ��ȸ
	 * 
	 * */	
	public ArrayList<Notice> selectNoticeList(){
		
		Connection conn = getConnection(); // SQL-MAPPER�ۼ��� SQL �޾ƴ��
		ArrayList<Notice> list = null;
		
		try {
			// dao���� db connection �����ϰ� ������ ��ȸ�ؼ� list�� ��Ƽ� ��ȯ
			list = new NoticeDao().selectNoticeList(conn);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// DB�������� ����
		close(conn);
		
		return list;
	}//method
	
	/*
	 * �������� ��ȭ�� ��ȸ (ȸ��)
	 * 
	 * */
	public Notice selectNoticeOne(int noticeNo, String flag) {
		
		System.out.println("[NoticeServiceimpl selectNoticeOne noticeNo] " + noticeNo);  
		System.out.println("[NoticeServiceimpl selectNoticeOne flag] " 	   + flag);  
		Connection conn = getConnection();
		Notice result = null;
		int viewCount = 0;
		
		try {
			
			// 1. �������� �������� ���� �� ��ȸ �� ������Ʈ (�������� ���� �ÿ���)
			if("N".equals(flag)) viewCount = new NoticeDao().increaseViewCount(conn, noticeNo);
			else viewCount = 1; // �������� ����/���� ������ ���� �� ��ȸ �� count ���� �� ����
			
			if(viewCount > 0) {
				// 2. �������� �������� ��ȸ
				result = new NoticeDao().selectNoticeOne(conn,noticeNo);
				close(conn);
			}else {
				close(conn);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}//method

	/*
	 * �������� �������� ���� �� ��ȸ �� ������Ʈ
	 * 
	 * */
	public int increaseViewCount(int noticeNo) {
		
		System.out.println("[NoticeService increaseViewCount] " + noticeNo);
		Connection conn = getConnection(); // SQL-MAPPER�ۼ��� SQL �޾ƴ��
		int result = 0;
		
		result = new NoticeDao().increaseViewCount(conn, noticeNo);
		
		return result;
	}
	
	/*
	 * �������� ���
	 * 
	 * */
	public int insertNotice(Notice notice) {
		
		Connection conn = getConnection();
		int result = 0;
		
		try {
			result = new NoticeDao().insertNotice(conn, notice);

			if(result > 0) commit(conn);
			else rollback(conn);
			
			close(conn);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}//method
	
	
	/*
	 * �������� ����
	 * 
	 * */	
	public int updateNoticeOne(Notice notice) {
		
		Connection conn = getConnection();
		int result = 0;
		
		try {
			
			result = new NoticeDao().updateNoticeOne(conn,notice);
			
			if(result > 0)
				 commit(conn);
			else rollback(conn);
			
			close(conn);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		
		return result;
		
	}	
	
	/*
	 * �������� ����
	 * 
	 * */
	public int deleteNoticeOne(int noticeNo) {
		
		Connection conn = getConnection();
		int result = 0;
		
		try {
			
			result = new NoticeDao().deleteNoticeOne(conn, noticeNo);
			
			if(result > 0) commit(conn);
			else rollback(conn);
			
			close(conn);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}//method
		
}
