<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <title>Struts 2 Maven Welcome page!</title>
    </head>
    <body>
        <h2 style="color: red"><s:property value="message"/></h2>
        <p>
            First Name: <s:property value="firstName" />
        </p>
        <p>
            Last Name: <s:property value="lastName" />
        </p>
        <p>
            Location: <s:property value="location" />
        </p>
    </body>
</html>