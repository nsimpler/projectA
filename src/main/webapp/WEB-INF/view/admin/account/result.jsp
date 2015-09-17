<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Hello</title>
</head>
<body>
가입완료:${accountRegistRequest.name}님 환영합니다.
체크완료:${accountRegistRequest.allowNoti}
체크완료:${accountRegistRequest.address.address1}
체크완료:${accountRegistRequest.address.address2}
</body>
</html>