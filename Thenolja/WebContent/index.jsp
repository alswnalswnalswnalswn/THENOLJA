<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<!-- CSS -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />

<!-- JS -->
  <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>

<style>
	div{
		box-sizing: border-box;
	}
	#wrap{
		width: 1200px;
		height: 800px;
		border: 1px solid red;
		margin: auto;
	}
	
	.swiper {
      width: 100%;
      height: 350px;
    }
    .swiper-slide {
      text-align: center;
      font-size: 18px;
      background: #fff;
      display: flex;
      justify-content: center;
      align-items: center;
    }
    .swiper-slide img {
      display: block;
      width: 100%;
      height: 100%;
      object-fit: cover;
    }
    
    
    .card-imgDiv, .card-info{
		display: inline-block;
		width: 50%;
		height: 100%;
	}
    .card-img{
		width: 100%;
		height: 100%;
		border-radius: 10px;
		cursor: pointer;
	}
	.card-info {
		float:right;
	}
	.card-info > h4 {
		text-align: center;
	}
	.card-info > p{
		margin: 0px;
		padding-left: 30px;
		margin-bottom: 10px;
	}
	.cards{
		width:	100%;
		height: 250px;
		margin: 10px;	
	}
</style>
</head>

<body>
	<%@ include file="views/common/menubar.jsp" %>
	<%@ include file="views/hotel/common/searchForm.jsp" %>
	
	<div id="wrap">
	<h3>요즘 인기있는 숙소</h3>
	 <div class="swiper mySwiper">
	    <div class="swiper-wrapper">
	    </div>
    	<div class="swiper-pagination"></div>
  	</div>
		
		
	</div>
	
	<script>
	$(function (){
		$.ajax({
			url:"favoriteData.jqAjax",
			type: 'post',
			success: function(result){
				console.log(result);
				console.log(result[0].hotelPath);
				for(let i = 0; i < result.length; i++){
					$('.swiper-wrapper').append('<div class="swiper-slide">'
							+'<div class="cards">'
								+'<div class="card-imgDiv">'
									+'<img class="card-img" src="'+result[i].hotelPath+'">'
								+'</div>'
								+'<div class="card-info">'
									+'<h4>'+result[i].hotelLocation+'</h4>'
									+'<p>숙소명 : '+result[i].hotelName +'</p>'
									+'<p>종류 : '+result[i].hotelCategory+'</p>'
								+'</div>'
							+'</div>'	
						+'</div>');	
				}
			},
			async : false,
			error: function(){
				
			},
		});
		
		var swiper = new Swiper(".mySwiper", {
		      slidesPerView: 3,
		      spaceBetween: 30,
		      freeMode: true,
		      pagination: {
		        el: ".swiper-pagination",
		        clickable: true,
		      },
		});
	})
	</script>
</body>
</html>