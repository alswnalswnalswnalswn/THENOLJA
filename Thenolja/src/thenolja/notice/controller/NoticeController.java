package thenoleja.notice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenoleja.notice.model.vo.Notice;
import thenoleja.notice.service.NoticeService;
import thenoleja.notice.service.NoticeServiceImpl;

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
	 * 수정일 : 2024.03.20
	 * 수정자 : shkim
	 * 수정내용 : 공지사항 목록 조회 처리
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ## vo : value object (변하지 않는 값을 처리할 때 사용함)
		// 공지사항 조회 결과 담을 list선언 > list타입은 NoticeVO
		
		ArrayList<Notice> list  = new ArrayList<Notice>();
		
		// NoticeServiceImpl 객체 선언
		NoticeServiceImpl serviceImpl = new NoticeServiceImpl();
		
		// serviceImpl에서 selectNoticeList메소드 호출(공지사항 조회 메소드임)
		list = serviceImpl.selectNoticeList();
		
		//응답화면 띄우기
		request.setAttribute("noticeList", list);
		RequestDispatcher view = request.getRequestDispatcher("/view/notice/noticeList.jsp");
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
