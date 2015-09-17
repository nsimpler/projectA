<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>create</title>
</head>
<body>
<form:form method="post" action ="/projectA/admin/accountresult/create">
<label for="email">이메일</label>
<input type = "text" name="email" id="email" /><br/>
주소1
<input type="text" name="address.address1" /> <br/>
주소2
<input type="text" name="address.address2" /> <br/>
우편번호
<input type="text" name="address.address3" /> <br/>
이름:<input type = "text" name="name" /><br/>
암호:<input type = "password" name="password" /><br/>
암호 확인:<input type = "password" name="confirmPassword" /><br/>
<label>
<input type="checkbox" name="allowNoti" value="true">
</label>
<input type ="submit" value="가입">
</form:form>
</body>
</html>