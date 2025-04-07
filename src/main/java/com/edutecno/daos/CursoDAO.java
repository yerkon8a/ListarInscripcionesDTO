package com.edutecno.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.entidades.CursoDTO;

public class CursoDAO {
    public List<CursoDTO> obtieneCurso() throws SQLException, ClassNotFoundException {
        List<CursoDTO> listaDeCursos = new ArrayList<>();
        String consultaSql = "SELECT id_curso, descripcion, precio FROM cursos";

        // Cargar el controlador de PostgreSQL
        Class.forName("org.postgresql.Driver");
        
        // Conexión a la base de datos PostgreSQL
        Connection conexion = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/Usuarios", "postgres", "123456"     
        		  );

        try (PreparedStatement stmt = conexion.prepareStatement(consultaSql)) {
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                CursoDTO cursoDto = new CursoDTO();
                cursoDto.setIdCurso(resultado.getInt("id_curso"));
                cursoDto.setDescricion(resultado.getString("descripcion"));
                cursoDto.setPrecio(resultado.getDouble("precio"));
                listaDeCursos.add(cursoDto);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listaDeCursos;
    }
}
