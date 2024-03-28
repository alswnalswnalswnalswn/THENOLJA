package thenolja.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.notice.service.NoticeServiceImpl;

/**
 * Servlet implementation class NoticeDeleteController
 * �������� ����
 */
@WebServlet("/delNotice")
public class NoticeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteController() {
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
		System.out.println("[NoticeDeleteController param] " + request.getParameter("noticeNo"));
		
		int result  = 0;
		boolean rslt = false;
		int noticNo = Integer.parseInt( request.getParameter("noticeNo") );
		
		// �������� ����ó�� ���� ȣ��
		result      = new NoticeServiceImpl().deleteNoticeOne(noticNo);
		
		// ����ó�� �� ��� ȭ������ sendRedirect
		if(result > 0) {
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
