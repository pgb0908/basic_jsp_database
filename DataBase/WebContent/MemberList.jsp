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

    <!-- �����ͺ��̽����� ȸ�� ����� ������ ������ -->
    <!-- table �±׸� �̿��Ͽ� ȭ�鿡 ȸ������ ������ ��� -->
    <%
    MemberDAO mdao = new MemberDAO();
    
    Vector<MemberBean> vec = mdao.allSelectMember();
    %>
    
    

</body>
</html>