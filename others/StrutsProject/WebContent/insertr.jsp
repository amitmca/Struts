<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
 
<head>
<link rel="stylesheet" type="text/css" href="css/java4s.css" />
</head>
 
<body>
<a href="<s:url action="view.action"/>">Display Records</a>
<br><br>
<b><font color="#5d8122" face="verdana">Insert Details</font></b>
<s:form action="insert">
<s:textfield label="ContactId" name="mb.id" cssClass="bord"/> 
<s:textfield label="Name" name="mb.name" cssClass="bord"/>
<s:textarea label="Address" name="mb.address" cols="50" rows="10" cssClass="bord"/>
<s:textfield label="Email" name="mb.email" cssClass="bord"/>
<s:textfield label="Contact" name="mb.contact" cssClass="bord"/>
<s:select label="Select a month" 
		headerKey="-1" headerValue="Select Month"
		list="#{'1':'Jan', '2':'Feb', '3':'Mar', '4':'Apr'}" 
		name="yourMonth" 
		value="2" cssClass="bord"/> 
<s:checkbox name="checkMe" fieldValue="true" value="true" label="Check Me for testing" cssClass="bord"/> 
	
<s:submit value="Insert" />

</s:form>
</body>
</html>