<%@page import="com.model.Note"%>
<%@page import="com.model.Matiere"%>
<%@page import="com.model.Etudiant"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.Manager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
td{ 
background-color: green; 
border:1px; border-radius:10px; 
border-style: groove;
}
.form{
width: 25%;
float: left;
border: solid 2px;
margin: 10px;
padding: 10px;
}
</style>
</head>
<% Manager dao=new Manager(); %>
<body>
<div class="form">
<h3>Add Etudiant</h3>
<form action="Addetudiant">
<input type="text" name="nom"/><br/>
<input type="text" name="prenom"/><br/>
<input type="text" name="log"/><br/>
<input type="password" name="pass"/><br/>
<input type="submit" value="addetudiant"/>
</form>
</div>
<div class="form">
<h3>Add Matier</h3>
<form action="AddeMatier">
<input placeholder="libelle" type="text" name="lib"/><br/>
<input placeholder="coiffecient" type="text" name="coiff"/><br/>
<input type="submit" value="addMatiere"/>
</form>
</div>
<%
List<Matiere> ms=dao.AllMatier();
List<Etudiant> ets= dao.Alletudiants();

%>
<div class="form">
<h3>Add Note</h3>
<form action="AddeNote">
<input placeholder="note" type="text" name="note"/><br/>
<select name="ide">
<%for(Etudiant e: ets)
{
	%>
<option value="<%= e.getId()%>"><%=e.getNom() %></option>
<%} %>
</select> <br/>
<select name="idm">
<%for(Matiere e: ms)
{
	%>
<option value="<%= e.getIdm() %>"><%=e.getLibelle() %></option>
<%} %>
</select> <br/>

<input type="submit" value="addNote"/>
</form>
</div>
<table style="width: 80%; background-color: gold">
<%

for(Etudiant e: ets)
{
%>
<tr >
<td ><%=e.getId() %></td>
<td><%=e.getNom() %></td>
<td><%=e.getPrenom() %></td>
<td><%=e.getLog() %></td>
<td>
<select >
<% 
List<Note> nt=dao.allnote4Etudiant(e.getId());
for(Note n:nt){
%>
<option><%= n.getNote() %> </option>
<% }%>
</select>
</td>
<td>
<h3><%=dao.moyenne(e.getId()) %></h3>
</td>
</tr>
<%} %>
</table>
</body>
</html>