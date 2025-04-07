<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.edutecno.entidades.CursoDTO" %>
<%@ page import="com.edutecno.entidades.FormaDePagoDTO" %>
<%@ page import="com.edutecno.entidades.InscripcionDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Listado de Inscripciones</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="preListarInscripciones">Mantenedor de Cursos</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="preListarInscripciones">Listar Inscripciones</a></li>
                <li><a href="preInscripcion">Inscribir Cursos</a></li>
            </ul>
        </div>
    </nav>

    <div class="container">
        <h2>Listado de Inscripciones</h2>
        <p>A continuación se muestra el listado de inscripciones:</p>
        
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Id Inscripción</th>
                    <th>Nombre</th>
                    <th>Teléfono</th>
                    <th>Id Curso</th>
                    <th>Id Forma de Pago</th>
                </tr>
            </thead>
            <tbody>
                <% 
                List<InscripcionDTO> inscripciones = (List<InscripcionDTO>) request.getAttribute("inscripciones");
                if (inscripciones != null && !inscripciones.isEmpty()) {
                    for (InscripcionDTO dto : inscripciones) { 
                %>
                <tr>
                    <td><%= dto.getIdInsc() %></td>
                    <td><%= dto.getNombre() %></td>
                    <td><%= dto.getCelular() %></td>
                    <td><%= dto.getIdCurso() %></td>
                    <td><%= dto.getIdFormaDePago() %></td>
                </tr>
                <% 
                    }
                } else { 
                %>
                <tr>
                    <td colspan="5" class="text-center">No hay inscripciones disponibles.</td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
