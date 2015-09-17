<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head><title>로그인</title></head>
<body>


<form:form commandName="loginCommand" method="post">
<p>
<label for="email"><spring:message code="getting" arguments="ddd,sss" /></label>: 
<input type="text" name="email" id="email" value="${loginCommand.email}" />
<form:errors path="email"/> 
</p>
<p>
<label for="password">암호</label>: 
<input type="text" name="password" id="password" value="${loginCommand.from}" />
<form:errors path="password"/> 
</p>
<p>
<label for="from">날짜</label>: 
<input type="datetime" name="from" id="from" value="${loginCommand.from}" />
<form:errors path="from"/> 
</p>
<%-- 
<p>
<label for="loginType"><spring:message code="login.form.type" /></label>
<form:select path="loginType" items="${loginTypes}" />
</p>
--%>
<p>
<form:select path="loginType">
<option value="">-----선택하세요-----</option>
<form:options items="${loginTypes}" />
</form:select>
</p>

<p>
	<label for="jobCode">직업</label>:
	<form:select path="jobCode" >
		<option value="">--- 선택하세요 ---</option>
		<form:options items="${jobCodes}" itemLabel="label" itemValue="code" />
	</form:select>
</p>

<p>
	<form:label path="favoriteOs">선호 OS</form:label>
	<form:checkboxes items="${favoritesOsCodes}" path="favoriteOs" 
	  itemValue="code" itemLabel="label"/>
	<form:errors path="favoriteOs" />
</p>


<%-- 	<form:select path="loginType"> --%>
<%-- 		<form:option value="일반회원" /> --%>
<%-- 		<form:option value="기업회원">기업</form:option> --%>
<%-- 		<form:option value="헤드헌터회원" label="헤드헌터" /> --%>
<%-- 	</form:select> --%>

<input type="submit" value="로그인">
</form:form>
<ul>
	<li>이메일/암호로 yuna@yuna.com/yuna 입력 또는 sanghwa@sanghwa.com/sanghwa 로 테스트</li>
</ul>
</body>
</html>