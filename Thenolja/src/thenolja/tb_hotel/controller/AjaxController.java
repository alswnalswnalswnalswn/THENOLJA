package thenolja.tb_hotel.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import thenolja.tb_hotel.model.service.HotelService;
import thenolja.tb_hotel.model.service.RoomService;
import thenolja.tb_hotel.model.vo.HotelCard;

public class AjaxController {
	
	public void deleteHotel(HttpServletRequest request, HttpServletResponse response) {
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		
		// System.out.println(hotelNo);
		
		int result = new HotelService().deleteHotel(hotelNo);
		String str = "삭제 실패";
		if(result > 0) {
			str = "삭제 성공";
		}
		
		response.setContentType("text/html; charset=UTF-8");
		try {
			response.getWriter().print(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteRoom(HttpServletRequest request, HttpServletResponse response) {
		int roomNo = Integer.parseInt(request.getParameter("roomNo"));
		
		int result = new RoomService().deleteRoom(roomNo);
		
		String str = "삭제 실패";
		if(result > 0) {
			str = "삭제 성공";
		}
		
		response.setContentType("text/html; charset=UTF-8");
		try {
			response.getWriter().print(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void selectPopular(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<HotelCard> pList = new HotelService().selectPopular();
		// System.out.println(pList);
		
		response.setContentType("application/json; charset=UTF-8");
		Gson gson = new Gson();
		
		try {
			gson.toJson(pList, response.getWriter());
		} catch (JsonIOException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void locRecomData(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<HotelCard> rList = new HotelService().selectRecomData();
		
		response.setContentType("application/json; charset=UTF-8");
		Gson gson = new Gson();
		
		try {
			gson.toJson(rList, response.getWriter());
		} catch (JsonIOException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void searchLocation(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<String> locList = new HotelService().selectLocation();
		
		response.setContentType("text/html; charset=UTF-8");
		try {
			response.getWriter().print(locList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
