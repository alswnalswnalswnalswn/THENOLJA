package thenolja.notice.model.vo;

import java.util.Date;

public class Notice {
	
	private String noticeTitle;
	private String noticeContent;
	private String createDate;
	private String status;
	private int writerNo;
	private String writer; 	   // ��ȭ�� ��ȸ �� �ۼ��ڸ�
	private int viewCount;	   // ��ȸ ��
	private int noticeNo;
	
	public Notice() {
		super();
	}
	// ���� �� �Ķ���� ó���� ���� ������ ����
	public Notice(String title, String content) {
		this.noticeTitle   = title;
		this.noticeContent = content;
	}	
	// ���� �� �Ķ���� ó���� ���� ������ ����
	public Notice(String title, String content, String status) {
		this.noticeTitle    = title;
		this.noticeContent  = content;
		this.status 		= status;
	}
	
	// ������ �Ķ���� ó���� ���� ������ ����
	public Notice(String title, String content, String status, int noticeNo) {
		this.noticeTitle    = title;
		this.noticeContent  = content;
		this.status 		= status;
		this.noticeNo 		= noticeNo;
	}		

	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(int writerNo) {
		this.writerNo = writerNo;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	
}
