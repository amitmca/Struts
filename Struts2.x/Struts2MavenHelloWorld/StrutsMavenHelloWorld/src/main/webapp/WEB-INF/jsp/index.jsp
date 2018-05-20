<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <title>Struts 2 Maven Hello world!!!</title>
        <s:head/>
    </head>
 
    <body>
        <h1 style="color: red"><s:text name="label.welcome" /></h1>
        <s:if test="hasActionErrors()">
            <div id="fieldErrors">
                <s:actionerror/>
            </div>
        </s:if>
        
        <s:form action="strutsAction" namespace="/" method="post" name="strutsForm">
            <s:textfield name="firstName" size="30" maxlength="50" key="label.firstName"/>
            <s:textfield name="lastName" size="30" maxlength="50" key="label.lastName"/>
            <s:textfield name="location" size="30" maxlength="50" key="label.location"/>            
            <s:submit key="Submit" align="right"/>
        </s:form>
    </body> 
</html>  