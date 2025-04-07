<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.edutecno.entidades.CursoDTO" %>
<%@ page import="com.edutecno.entidades.FormaDePagoDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Formulario Inscripción</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
  <%
    // Inicializar listas para evitar errores NullPointerException
    List<CursoDTO> cursos = (List<CursoDTO>) request.getAttribute("cursos");
    List<FormaDePagoDTO> formasPago = (List<FormaDePagoDTO>) request.getAttribute("formasPago");

    if (cursos == null) {
        cursos = java.util.Collections.emptyList(); // Evitar que sea null
    }
    if (formasPago == null) {
        formasPago = java.util.Collections.emptyList(); // Evitar que sea null
    }
  %>

  <nav class="navbar navbar-default">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="preListarInscripciones">Mantenedor De Cursos</a>
      </div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="preListarInscripciones">Listar Inscripciones</a></li>
        <li><a href="preInscripcion">Inscribir Cursos</a></li>
      </ul>
    </div>
  </nav>

  <div class="container">
    <form action="posInscripcion" method="post">
      <div class="form-group">
        <label for="nombre">Nombre:</label>
        <input type="text" class="form-control" name="nombre" id="nombre" required>
      </div>
      <div class="form-group">
        <label for="telefono">Teléfono:</label>
        <input type="text" class="form-control" name="telefono" id="telefono" required>
      </div>
      <div class="form-group">
        <label for="cursos">Cursos:</label>
        <select name="idCurso" class="form-control" required>
          <% for (CursoDTO dto : cursos) { %>
            <option value="<%= dto.getIdCurso() %>">
              <%= dto.getDescripcion() %>
            </option>
          <% } %>
        </select>
      </div>
      <div class="form-group">
        <label for="formasPago">Formas de Pago:</label>
        <select name="idFormaPago" class="form-control" required>
          <% for (FormaDePagoDTO dto : formasPago) { %>
            <option value="<%= dto.getIdFormaDePago() %>">
              <%= dto.getDescripcion() %>
            </option>
          <% } %>
        </select>
      </div>
      <button type="submit" class="btn btn-primary">Enviar</button>
    </form>
  </div>
</body>
</html>

