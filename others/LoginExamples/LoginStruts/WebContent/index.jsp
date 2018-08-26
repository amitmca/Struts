<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Struts Login Application</title>

      
<SCRIPT LANGUAGE="JavaScript">


<!--

function setColor(el, bg) 
{
  if (el.style) el.style.backgroundColor = bg;
}

function checkInput(form) 
{
  var bgBad = "pink";
  var bgGood = "white";
  var valid = true;
  if (form.UserName.value == "") {
    valid = false;
    setColor(form.UserName, bgBad);
  
  } else {
    setColor(form.UserName, bgGood);
  }
 
  
 if (form.password.value == "") {
    valid = false;
    setColor(form.password, bgBad);
  
  } else {
    setColor(form.password, bgGood);
  }




  
  if (!valid) alert("Please fill out all the fields.");
  return valid;
}
// --> 
</SCRIPT>


</head>

<body background=images/banner2_old1.jpg>
<s:form action="verify">
<br><br><br><br><br><br><br><br>
             
		<table cellpadding="0" cellspacing="0" width="454" height="241" align=center background='images/j.jpg' valign="middle">
			<!-- MSTableType="layout" -->
                        <tr> 
                        <td>
                        
		        <table border=0>    
                        
			<tr>
				<td></td>
				<td align="right" valign="top">
				
				</font>
				</td>	
				<td align="center" valign="top">
				<font face="calibri" color=red size=6>
				<img src="images/login.png">&nbsp;&nbsp;<b>Login</b>
				</font>
				</td>
				<td height="73" valign="top">
				
				</td>
			</tr>
			<tr>
				<td></td>
				<td align="right" valign="top">
				<font face="calibri" color=green size=2>
				Username
				</font>
				</td>	
				<td align="center" valign="top"><b>:</b></td>
				<td height="51" valign="top">
				<s:textfield name="uname" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td align="right" valign="top">
				<font face="calibri" color=green size=2>
				Password
				</font>
				</td>
				<td align="center" valign="top"><b>:</b></td>
				<td height="56" valign="top">
				<s:textfield name="pass"/>
				</td>
			</tr>
			<tr>
				<td height="60" colspan="4" align="center">
				<s:submit value="Login" align="center" />
				</td>
			
			</tr>
			<tr>
				<td width="6"></td>
				<td width="150"></td>
				<td width="73"></td>
				<td height="1" width="225"></td>
			</tr>
                      
                        </table>
                        </td>
                        </tr>
			
		</table>

       		
        
</s:form>
</body>

</html>