<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.*;" %>
 
<head>
<link rel="stylesheet" type="text/css" href="css/java4s.css" />
<script type="text/javascript">
function deleteRecord()
{
document.fom.action="del.action";
document.fom.submit();
}
function editr(val)
{
document.fom.action="update.action?fid="+val;
document.fom.submit();
}
</script>
</head>
 
<a href="insertr.jsp">Insert</a>
 
<br><br>
 
<table>
<form name="fom" method="post">
<%
List l=(List)request.getAttribute("disp");
if(l!=null)
{
 
Iterator it=l.iterator();
 
while(it.hasNext())
{
 
com.srcsys.Mybean b=(com.srcsys.Mybean)it.next();
int tempNum = b.getContactId();
String tempName = b.getName();
String tempCountry = b.getAddress();
 
%>
<tr>
<td><input type="checkbox" value="<%= tempNum %>" name="rdel"></td>
<td><%= tempNum %></td>
<td><%= tempName %></td>
<td><%= tempCountry %></td>
<td><a href="javascript:editr('<%= tempNum %>')">Edit</a></td>
</tr>
 
<%
 
}
}
 
%>
<input type="button" value="delete" onclick="deleteRecord();">
</table>
 
</form>