<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,thenolja.mypage.model.vo.MyPageHeartList" %>  
<%
	ArrayList<MyPageHeartList> heartList = (ArrayList<MyPageHeartList>)request.getAttribute("heartList");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찜 목록 조회</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>

    div{
    	border: 1px solid red;
        box-sizing : border-box;
    }
    #output{
    	width: 1200px;
        height: auto;
        margin: auto;
    }
    #content{
        width: 1200px;
        height: 300px;
        margin-top: 20px;
    }
    #content_title{
        width: 100%;
        height: 100%;
        margin-top : 20px;
    }
    #left_title{
        margin-left: 60px;
    }
    #reser_info{
        width: 1000px;
        height: 80%;
        margin: auto;
        margin-top: 30px;
    }
    #reser_hotel_img{
        width: 25%;
        float: left;
    }
    #reser_hotel_img > img{
        border-radius: 10px;
    }
    #reser_detail > p{
        font-size: 20px;
    }
    #reser_detail > h3{
        font-weight: bold;
    }
    #reser_detail{
        width: 60%;
        height: 100%;
        float: left;
    }
    #homeBtn {
    	text-align:center;
    }
    #goHome{
    	width : 300px;
    	height: 50px;
    	border-radius : 10px;
    	background-color: #5BA199;
    	border : 0;
    	margin-bottom: 100px;
    	font-size: 22px;
    }
    #goHome:hover{
    	font-size:23px;
    }

    /*********************/
</style>

</head>
<body>
	<%@ include file="../common/menubar.jsp"%>
	<input type="hidden" name="memNo" value="<%= loginUser.getMemNo() %>">

	<div id="output">
        <div id="content_title">
            <div id="left_title"><h3>찜목록</h3></div>
		</div>
    	<% if(heartList.isEmpty()) { %>
			<table>
				<tr>
					<th style="font-size:40px;" colspan="5">찜한 내역이 존재하지 않습니다.</th>
				</tr>
			</table>
		<% } else { %>
		
			<% for(MyPageHeartList h : heartList) { %>
			<div id="content">
			        <div id="reser_info">
			            <div id="reser_hotel_img"><img src="#" alt="호텔이미지" width="220px" height="220px"></div>
				            <div id="reser_detail">
				                <h3><%= h.getHotelName() %></h3>
				                <p>객실이름</p>
				            </div>
			        </div>
				</div>
			<% } %>
		<% } %>
<div id="homeBtn">
	<a href="<%=contextPath%>"><button id="goHome" class="btn btn-info">메인으로 돌아가기</button></a>
</div>
</div>

</body>
</html>