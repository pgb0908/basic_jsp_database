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

    // ��� �κ��� ������ �о��� �ٽ� ��Ŭ������ ����
    String[] hobby = request.getParameterValues("hobby");
    String textHobby = "";
    
    for(int i = 0; i < hobby.length; i++){
        textHobby += hobby[i]+ " ";
    }

%>

    <!--  useBean�� �̿��Ͽ� �Ѳ����� �����͸� �޾ƿ�  -->
    <jsp:useBean id="mbean" class="model.MemberBean">
        <jsp:setProperty name="mbean" property="*" />
    </jsp:useBean>
    
<%
    mbean.setHobby(textHobby);

    // ������ ���̽� ��ü ����
    MemberDAO mdao = new MemberDAO();
    mdao.insertMember(mbean);
    
    // ȸ�������� �Ǿ��ٸ� ȸ�������� �����ִ� �������� �̵���Ŵ
    response.sendRedirect("MemberList.jsp");
%>

    ����Ŭ �Ϸ�



</body>
</html>