<%@page import="pack.*"%>  
<%@page import="org.apache.catalina.Session" %>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>

<jsp:useBean id="obj" class="pack.User"></jsp:useBean>  
<jsp:setProperty property="*" name="obj"/>  
  
<%  
int i=UserDao.register(obj);  
if(i>0)  
out.print("You are successfully registered");  
  
%>  