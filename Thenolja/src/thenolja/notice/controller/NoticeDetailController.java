package thenolja.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.notice.model.vo.Notice;
import thenolja.notice.service.NoticeServiceImpl;

/**
 * Servlet implementation class NoticeDetailController
 */
@WebServlet("/detail.notice")
public class NoticeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * �������� ��ȭ�� ��ȸ
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// �������� ��ȸ �� �Ķ���� �ޱ�
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		String flag  = request.getParameter("flag"); // ����, ���� / �� ������ ������ ���� �� �߰�
		
		System.out.println("[NoticeDetailController noticeNo] " + noticeNo);  

		Notice result = new Notice();
		result = new NoticeServiceImpl().selectNoticeOne(noticeNo, flag);
		System.out.println("[NoticeDetailController result] " + result);
		
		if(result != null) {
			request.setAttribute("notice", result);
			request.getRequestDispatcher("views/notice/noticeDetail.jsp").forward(request, response); //������
			
		}else { //���� => ���������� ������
			
			request.setAttribute("errorMsg", "�������� �� ��ȸ ����");
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.Msg");
			view.forward(request,response);	
		}
		
	}
		
		
		
		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
