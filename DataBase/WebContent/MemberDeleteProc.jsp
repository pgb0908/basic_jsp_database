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
    %>

    <jsp:useBean id="mbean" class="model.MemberBean">
        <jsp:setProperty name="mbean" property="*"/>
    </jsp:useBean>

    <%
    MemberDAO mdao = new MemberDAO();
    String pass = mdao.getPass(mbean.getId());
    
    // 수정하기 위해서 가져온 pass와 입력한 pass를 비교
    if(mbean.getPass1().equals(pass)){
        // 기존 패스와 입력한 패스가 같다
        
        // MemberDao 클래스의 회원수정 메소드를 호출
        mdao.deleteMember(mbean.getId());
        response.sendRedirect("MemberList.jsp");
    }else{
    %>
    <script type="text/javascript">
        alert("패스워드가 맞지 않습니다. 다시 확인해 주세요");
        history.go(-1);
        </script>
    <%     
    }
    %>

</body>
</html>