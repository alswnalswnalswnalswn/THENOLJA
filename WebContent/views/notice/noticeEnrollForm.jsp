<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
#insert-form{
    width: 800px;
    margin: auto;
}
label{
    font-weight: bold;
}

</style>
</head>
<body>

<%@ include file="../common/menubar.jsp"%>


<div class="outer">
<h2 align="center">�������� ����/����</h2>
<br><br>

<!-- 
    �� select    get
     
    �� insert    post

    �� 


    get / post


    put / fetch / delete

-->



<form action="<%= contextPath %>/insert.notice" method="post" id="insert-form">
	
<!--	<input type="hidden" name="userNo" value="<%=loginUser.getUserNo() %>">  --> 
	

    <div class="form-group">
        <label for="usr">����</label>
        <input type="text" class="form-control" id="usr" name="title">
    </div>

    <div class="form-group">
        <label for="comment">����</label>
        <textarea class="form-control" name="content" rows="15" id="comment" style="resize: none;"></textarea>
    </div>

    <div align="center">
        <button type="submit" class="btn btn-sm info">����ϱ�</button>
        <button type="button" class="btn btn-sm btn-secondary" 
        onclick="history.back();">�ڷΰ���</button>
    </div>





</form>


</div>




</body>
</html>