<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
    request.setCharacterEncoding("euc-kr");

    // 취미 부분은 별도로 읽어드려 다시 빈클래스에 저장
    String[] hobby = request.getParameterValues("hobby");
    String textHobby = "";
    
    for(int i = 0; i < hobby.length; i++){
        textHobby += hobby[i]+ " ";
    }

%>

    <!--  useBean을 이용하여 한꺼번에 데이터를 받아옴  -->
    <jsp:useBean id="mbean" class="model.MemberBean">
        <jsp:setProperty name="mbean" property="*" />
    </jsp:useBean>
    
<%
    mbean.setHobby(textHobby);

    // 데이터 베이스 객체 생성
    MemberDAO mdao = new MemberDAO();
    mdao.insertMember(mbean);
    
    // 회원가입이 되었다면 회원정보를 보여주는 페이지로 이동시킴
    response.sendRedirect("MemberList.jsp");
%>

    오라클 완료



</body>
</html>