<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/java4s.css" />
</head>
<body>
<s:actionerror/>
<s:form action="verify">
<div id="loginpanelwrap">
  	
	<div class="loginheader">
    <div class="logintitle"><a href="#">Login</a></div>
    </div>

     
    <div class="loginform">
        
        <div class="loginform_row">
        <s:textfield name="uname" key="enter.user" cssClass="loginform_input"/>
        </div>
        <div class="loginform_row">
        <s:password name="password" key="enter.pass" cssClass="loginform_input"/>
        </div>
        <div class="loginform_row">
        <s:submit value="Login" align="center" cssClass="loginform_submit"/>
        </div> 
        <div class="clear"></div>
    </div>
 

</div>

</s:form>   	
</body>
</html>