package com.edutecno.servlets; 
import java.io.IOException; 
import java.sql.SQLException; 
import com.edutecno.entidades.InscripcionDTO; 
import com.edutecno.facade.Facade;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 
 
@WebServlet("/posInscripcion") 
public class PosInscripcion extends HttpServlet { 
/** 
*  
*/ 
   private static final long serialVersionUID = 1L; 
   protected void doPost(HttpServletRequest request, 
HttpServletResponse response)throws ServletException, IOException { 
// obtengo los datos del formulario 
    String nombre = request.getParameter("nombre"); 
    String celular = request.getParameter("telefono"); 
    int idCurso = Integer.parseInt(request.getParameter("idCurso")); 
    int idFormaDePago = 
Integer.parseInt(request.getParameter("idFormaPago")); 
// instancio el DTO y le asigno los datos 
     InscripcionDTO dto = new InscripcionDTO(); 
     dto.setNombre(nombre); 
     dto.setCelular(celular); 
     dto.setIdCurso(idCurso); 
     dto.setIdFormaDePago(idFormaDePago); 
      
     System.out.println(dto.toString()); 
// invoco al facade para procesar la inscripcion 
     Facade facade = new Facade(); 
     int idInsc = 0; 
    try { 
       idInsc = facade.registrarInscripcion(dto); 
    } catch (SQLException e) { 
       e.printStackTrace(); 
    } catch (ClassNotFoundException e) { 
       e.printStackTrace(); 
    } 
// el resultado lo adjunto como atributo en el request 
    request.setAttribute("idInsc", idInsc); 
// redirecciono el control hacia la siguiente vista, 
// es decir: hacia su servlet de pre-confirmacion 
     request.getRequestDispatcher("/preConfirmacion").forward(request, 
response); 
  } 
}