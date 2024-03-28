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
 * Servlet implementation class NoticeInsertController
 */
@WebServlet("/regNotice")
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertController() {
        super();
        // TODO Auto-generated constructor stub
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
	 * �������� ���
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getRequestURI());
		System.out.println(request.getContentType());
		// ��� submission ���
		// �Ķ���� �ѱ� ���� ������ ���� ���ڵ� ����
		request.setCharacterEncoding("UTF-8");
		
		// ȭ�鿡�� �Ѿ�� �Ķ���� �� ����
		// request.getParameter�� �ۼ��ϴ� ���ڿ��� > html �±׿� ������ name�� ��ġ�ؾ���.
		String title = "";
		String content = "";
		String status = "";
		title   = request.getParameter("title");
		content = request.getParameter("content");
		status  = request.getParameter("status");
		
		System.out.println("title : " + title);
		System.out.println("content : " + content);
		System.out.println("status : " + status);
		
		int svc = 0;
		boolean rslt = false;
		
		// �������� ���� ���� ȣ��
		Notice notice = new Notice(title, content, status);
		svc = new NoticeServiceImpl().insertNotice(notice);
		
		System.out.println("[svc] " + svc);
		
		// ����ó�� �� ��� ȭ������ sendRedirect
		if(svc > 0) {
			rslt = true;
			// ��ϿϷ� �� response ��ü�� contentType ����
			response.setContentType("text/html charset=UTF-8");
			request.setAttribute("rsp.success", rslt);
			
			// ��� �Ϸ� �� send Redirect���� > ������� �̵�
			//response.sendRedirect("/TheNoleJa/noticeList");
		}
		
		// ���� ���� �� ���ȭ������ sendRedirect
		else {
			rslt = false;
			// ��ϿϷ� �� response ��ü�� contentType ����
//			response.setContentType("text/html charset=UTF-8");
//			request.setAttribute("rsp.success", rslt);
//			response.sendRedirect("/TheNoleJa/noticeReg");
		}	
	}

}
