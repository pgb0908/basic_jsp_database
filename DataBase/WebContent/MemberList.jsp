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
    
    <center>
    
    <h2> 모든 회원 보기 </h2>
    
    <table width="800" border="1">
        <tr height="50">
        <td align="center" width="150">아이디</td>
        <td align="center" width="250">이메일</td>
        <td align="center" width="200">전화번호</td>
        <td align="center" width="200">취미</td>
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