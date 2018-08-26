<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/java4s.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
 
<s:actionerror/>
<s:form action="verify">
 
    <s:textfield name="uname" key="enter.user" cssClass="loginform_input"/><br>
    <s:password name="password" key="enter.pass" cssClass="loginform_input"/><br>
 
    <s:submit value="Login" align="center" cssClass="loginform_submit"/>
 
</s:form>
</body>
</html>