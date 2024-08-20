<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="bean.*" %>
<jsp:useBean id="sdto" scope="request" class="bean.StudentDTO"></jsp:useBean>
<jsp:useBean id="msg" scope="request" class="java.lang.String"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap" rel="stylesheet">
<style type="text/css">
*{
font-family: "Noto Sans JP", sans-serif;
font-optical-sizing: auto;
font-weight: 700;
font-style: normal;
font-feature-settings: "palt";
}
table{
border-collapse: separate;
    border-spacing: 1rem .5rem;
}
th{
color: #999;
}
</style>
<title>Score Board</title>
</head>
<body class="p-3 my-sm-5 container text-center">
<section class="mb-4">
<h1><%= msg %></h1>
</section>
<section class="mb-4 mx-sm-3">
<table class="mx-auto">
<tr>
<th>ID</th>
<th>NAME</th>
<th>SCORE</th>
</tr>

<%
  for(int i = 0; i < sdto.size(); i++){
    StudentBean sb = sdto.get(i);
%>
<tr>
<td><%= sb.getNo() %></td>
<td><%= sb.getName() %></td>
<td><%= sb.getScore() %></td>
</tr>
<%
}
%>
</table>
</section>
<a href="/dbweb/showname2.html">home</a>
</body>
</html>