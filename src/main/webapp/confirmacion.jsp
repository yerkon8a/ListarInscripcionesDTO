<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%> 
<% 
int idInsc = (Integer)request.getAttribute("idInsc"); 
%> 
<!DOCTYPE html> 
<html> 
<head> 
  <meta charset="UTF-8"> 
 

  <title>Listado de inscripciones</title> 
  <meta charset="utf-8"> 
  <meta name="viewport" content="width=device-width, initial-scale=1"> 
  <link rel="stylesheet" 
href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.c
 ss"> 
  <script  
src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></
 script> 
  <script  
src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"
 ></script> 
</head> 
<body> 
  <nav class="navbar navbar-default"> 
    <div class="container-fluid"> 
      <div class="navbar-header"> 
         <a class="navbar-brand" href="preListarInscripciones">Mantenedor 
de Cursos</a></div> 
         <ul class="nav navbar-nav"> 
           <li class="active"><a href="preListarInscripciones">Listar  
Inscripciones</a></li> 
           <li><a href="preInscripcion">Inscribir Cursos</a></li> 
         </ul> 
       </div> 
    </nav> 
   <h1>Solicitud Generada Correctamente</h1> 
    Su codigo de inscripción es: <%=idInsc%> 
</body> 
</html> 