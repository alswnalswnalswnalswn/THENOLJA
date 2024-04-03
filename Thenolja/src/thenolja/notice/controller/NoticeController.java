package thenolja.notice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.notice.model.vo.Notice;
import thenolja.notice.service.NoticeServiceImpl;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/noticeList")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * ������ : 2024.03.20
	 * ������ : shkim
	 * �������� : �������� ��� ��ȸ ó��
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ## vo : value object (������ �ʴ� ���� ó���� �� �����)
		// �������� ��ȸ ��� ���� list���� > listŸ���� NoticeVO
		ArrayList<Notice> list  = new ArrayList<Notice>();
		
		// NoticeServiceImpl ��ü ����
		NoticeServiceImpl serviceImpl = new NoticeServiceImpl();
		
		// serviceImpl���� selectNoticeList�޼ҵ� ȣ��(�������� ��ȸ �޼ҵ���)
		list = serviceImpl.selectNoticeList();
		
		//����ȭ�� ���� (list��ü, ����¡ ��ü setAttribute)
		request.setAttribute("noticeList", list);
		//request.setAttribute("pagingVo", pagingVo);
		RequestDispatcher view = request.getRequestDispatcher("/views/notice/noticeList.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
