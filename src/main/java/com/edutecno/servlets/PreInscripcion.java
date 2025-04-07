package com.edutecno.servlets; 
import java.io.IOException; 
import java.sql.SQLException; 
import java.util.List; 

import com.edutecno.entidades.CursoDTO; 
import com.edutecno.entidades.FormaDePagoDTO; 
import com.edutecno.facade.Facade;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 
 
@WebServlet("/preInscripcion") 
public class PreInscripcion extends HttpServlet { 
/** 
*  
*/ 
   private static final long serialVersionUID = 1L; 
  
 protected void doGet(HttpServletRequest request, HttpServletResponse 
response)throws ServletException, IOException { 
//se obtiene el facade instanciando un objeto 
   Facade facade = new Facade(); 
   try { 
//se obtiene la lista de cursos con el objeto facade 
     List<CursoDTO> listaCursos = null; 
     try { 
         listaCursos = facade.obtenerCursos(); 
      } catch (ClassNotFoundException e) { 
          e.printStackTrace(); 
      } 
//se obtiene la lista de cursos con el objeto facade 
    List<FormaDePagoDTO> listaFormasPago = null; 
    try { 
       listaFormasPago = facade.obtenerFormasDePago(); 
     } catch (ClassNotFoundException e) { 
       e.printStackTrace(); 
     } 
//se guardan las listas al request 
    request.setAttribute("cursos", listaCursos); 

    request.setAttribute("formasPago", listaFormasPago); 
//se redirecciona el request a la página jsp 
    request.getRequestDispatcher("inscripcion.jsp").forward(request, 
response); 
    } catch (SQLException e) { 
       e.printStackTrace(); 
    }  }  }