<%@page import="java.util.Vector"%>
<%@page import="model.MemberDAO"%>
<%@page import="model.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

    <!-- 데이터베이스에서 회원 모두의 정보를 가져옴 -->
    <!-- table 태그를 이용하여 화면에 회원들의 정보를 출력 -->
    <%
    MemberDAO mdao = new MemberDAO();
    
    Vector<MemberBean> vec = mdao.allSelectMember();
    %>
    
    

</body>
</html>