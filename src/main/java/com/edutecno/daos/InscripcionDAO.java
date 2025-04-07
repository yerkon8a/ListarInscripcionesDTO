package com.edutecno.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.entidades.InscripcionDTO;

public class InscripcionDAO {

    // Método para insertar una inscripción
    public int insertarInscripcion(InscripcionDTO dto) throws SQLException, ClassNotFoundException {
        int max = 0;

        // Query para obtener el próximo ID
        String consultaProximoId = "SELECT COALESCE(MAX(id_inscripcion), 0) + 1 FROM public.inscripcion";

        // Query para insertar inscripción
        String insertarInscripcion = "INSERT INTO public.inscripcion("
                + "id_inscripcion, nombre, telefono, id_curso, id_forma_pago)"
                + " VALUES (?, ?, ?, ?, ?)";

        // Configuración de la conexión
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5433/Usuarios";
        String usuario = "postgres";
        String password = "123456";

        try (Connection conexion = DriverManager.getConnection(url, usuario, password);
             PreparedStatement stmt1 = conexion.prepareStatement(consultaProximoId);
             PreparedStatement stmt2 = conexion.prepareStatement(insertarInscripcion)) {

            // Obtener el próximo ID
            ResultSet resultado = stmt1.executeQuery();
            if (resultado.next()) {
                max = resultado.getInt(1);
            }

            // Configurar valores para insertar
            stmt2.setInt(1, max);
            stmt2.setString(2, dto.getNombre());
            stmt2.setString(3, dto.getCelular());
            stmt2.setInt(4, dto.getIdCurso());
            stmt2.setInt(5, dto.getIdFormaDePago());

            // Ejecutar la inserción
            if (stmt2.executeUpdate() != 1) {
                throw new RuntimeException("Ocurrió un error inesperado al insertar la inscripción.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error al conectar con la base de datos: " + ex.getMessage());
        }

        return max;
    }

    // Método para obtener todas las inscripciones
    public List<InscripcionDTO> obtieneInscripciones() throws SQLException, ClassNotFoundException {
        List<InscripcionDTO> inscripciones = new ArrayList<>();

        // Query para obtener todas las inscripciones
        String consultaSql = "SELECT * FROM public.inscripcion";

        // Configuración de la conexión
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5433/Usuarios";
        String usuario = "postgres";
        String password = "123456";

        try (Connection conexion = DriverManager.getConnection(url, usuario, password);
             PreparedStatement stmt = conexion.prepareStatement(consultaSql)) {

            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                InscripcionDTO inscripcion = new InscripcionDTO();
                inscripcion.setIdInsc(resultado.getInt("id_inscripcion"));
                inscripcion.setNombre(resultado.getString("nombre"));
                inscripcion.setCelular(resultado.getString("telefono"));
                inscripcion.setIdCurso(resultado.getInt("id_curso"));
                inscripcion.setIdFormaDePago(resultado.getInt("id_forma_pago"));

                inscripciones.add(inscripcion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error al obtener las inscripciones: " + ex.getMessage());
        }

        return inscripciones;
    }
}

