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
    
    <center>
    
    <h2> ��� ȸ�� ���� </h2>
    
    <table width="800" border="1">
        <tr height="50">
        <td align="center" width="150">���̵�</td>
        <td align="center" width="250">�̸���</td>
        <td align="center" width="200">��ȭ��ȣ</td>
        <td align="center" width="200">���</td>
        </tr>
        
        <%
        for(int i = 0; i < vec.size(); i++){
            MemberBean bean = vec.get(i);
        
        %>
        
        <tr height="50">
        <td align="center" width="150">
        <a href="MemberInfo.jsp?id=<%=bean.getId()%>">
        <%= bean.getId() %></a></td>
        <td align="center" width="250"><%= bean.getEmail() %></td>
        <td align="center" width="200"><%= bean.getTel() %></td>
        <td align="center" width="200"><%= bean.getHobby() %></td>
        </tr>
        
        <%
        }
        %>
    
    </table>
    
    
    </center>

</body>
</html>