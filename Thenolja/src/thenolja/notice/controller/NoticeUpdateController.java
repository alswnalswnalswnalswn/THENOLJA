package thenolja.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.notice.model.vo.Notice;
import thenolja.notice.service.NoticeServiceImpl;

/**
 * Servlet implementation class NoticeUpdateController
 * �������� ����
 */
@WebServlet("/updNotice")
public class NoticeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * �������� ���� ó��
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// �Ķ���� �� Ȯ��
		System.out.println("[NoticeUpdateController param] " + request.getParameter("noticeNo"));
		
		request.setCharacterEncoding("UTF-8");
		
		// ȭ�鿡�� �Ѿ�� �Ķ���� �� ����
		// request.getParameter�� �ۼ��ϴ� ���ڿ��� > html �±׿� ������ name�� ��ġ�ؾ���.
		String title = "";
		String content = "";
		String status = "";
		int result  = 0;
		
		int noticeNo = Integer.parseInt( request.getParameter("noticeNo") );
		title   = request.getParameter("title");
		content = request.getParameter("content");
		status  = request.getParameter("status");
		
		System.out.println("title   : " + title);
		System.out.println("content : " + content);
		System.out.println("status  : " + status);
		System.out.println("noticNo : " + noticeNo);
		System.out.println("status length  : " + status.length());
		
		int svc = 0;
		boolean rslt = false;
		
		// �������� ���� ���� ȣ��
		Notice notice = new Notice(title, content, status, noticeNo);
		svc = new NoticeServiceImpl().updateNoticeOne(notice);
		
		System.out.println("[svc] " + svc);
		
		// ����ó�� �� ��� ȭ������ sendRedirect
		if(svc > 0) {
			rslt = true;
			// ��ϿϷ� �� response ��ü�� contentType ����
			response.setContentType("text/html charset=UTF-8");
			response.getWriter().write("SUCCESS");
		}
		
		// ���� ���� �� ���ȭ������ sendRedirect
		else {
			rslt = false;
			// ��ϿϷ� �� response ��ü�� contentType ����
			response.setContentType("text/html charset=UTF-8");
			response.getWriter().write("FAIL");
		}		
		
	}

}
