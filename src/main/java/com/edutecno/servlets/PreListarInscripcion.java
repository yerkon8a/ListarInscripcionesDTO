package com.edutecno.servlets; 
import java.io.IOException; 
import java.sql.SQLException; 
import java.util.List; 
import com.edutecno.entidades.InscripcionDTO; 
import 
com.edutecno.facade.Facade;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;@WebServlet("/preListarInscripciones") 
public class PreListarInscripcion extends HttpServlet { 
/** 
*  
*/ 
 private static final long serialVersionUID = 1L; 
 protected void doGet(HttpServletRequest request, HttpServletResponse 
response) 
 throws ServletException, IOException { 
//obtenemos el facade 
  Facade facade = new Facade(); 
  try { 
//obtenemos las listas 
   List<InscripcionDTO> InscripcionesPorAlumno = null; 
   try { 
     InscripcionesPorAlumno = facade.obtieneInscripciones(); 
    } catch (ClassNotFoundException e) { 
     e.printStackTrace(); 
    } 
//se guardan las listas al request 
    request.setAttribute("inscripciones", InscripcionesPorAlumno); 
//se redirecciona el request a la pagina jsp 
request.getRequestDispatcher("ListaInscripciones.jsp").forward(request,
 response); 
    } catch (SQLException e) { 
      e.printStackTrace(); 
    } 
 } 
}