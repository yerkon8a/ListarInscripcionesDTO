package com.edutecno;  
import java.sql.SQLException;  
import java.util.List; 
import com.edutecno.entidades.CursoDTO; 
import com.edutecno.entidades.FormaDePagoDTO; 
import com.edutecno.facade.Facade; 
  
public class Main {  
 public static void main(String[] args) { 
  //instancia de CursoDTO  
   CursoDTO curso = new CursoDTO(); 
  //seteo de los atributos del objeto curso de la clase CursoDTO  
   curso.setIdCurso(1);  
   curso.setDescricion("Descripcion"); 
   curso.setPrecio(20000); 
  //prueba en consola con impresion del funcionamiento de la clase DTO  
   System.out.println(curso.toString()); 
  //obtenemos el facade  
  Facade facade = new Facade();  
  try { 
  //obtenemos la lista de cursos  
    List<CursoDTO> listaCursos = null; 
     try {  
       listaCursos = facade.obtenerCursos(); 
  //impresion de las listas en consola, de la consulta obtenida a la base de datos  
        System.out.println(listaCursos);  
       }catch (ClassNotFoundException e) { 
          e.printStackTrace(); 
       } 
   //obtenemos la lista de forma de pago  
       List<FormaDePagoDTO> listaFormasPago = null;  
    try{ 
        listaFormasPago = facade.obtenerFormasDePago(); 
    //impresion de las listas en consola, de la consulta obtenida a la base de datos  
         System.out.println(listaFormasPago); 
      } catch (ClassNotFoundException e) { 
           e.printStackTrace(); 
     } 
   } catch (SQLException e) { 
         e.printStackTrace(); 
   } 
  } 
}
