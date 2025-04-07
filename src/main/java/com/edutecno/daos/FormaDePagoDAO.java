package com.edutecno.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.entidades.FormaDePagoDTO;

public class FormaDePagoDAO {

    // Método para obtener todas las formas de pago
    public List<FormaDePagoDTO> obtieneFormasDePago() throws SQLException, ClassNotFoundException {
        List<FormaDePagoDTO> formasDePago = new ArrayList<>();

        // Definir la consulta SQL
        String consultaSql = "SELECT * FROM forma_pago";

        // Configurar la conexión
        Class.forName("org.postgresql.Driver");
        try (Connection conexion = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/Usuarios", "postgres", "123456");
             PreparedStatement stmt = conexion.prepareStatement(consultaSql)) {

            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                FormaDePagoDTO formaDePago = new FormaDePagoDTO();
                formaDePago.setIdFormaDePago(resultado.getInt("id_forma_pago"));
                formaDePago.setDescripcion(resultado.getString("descripcion"));
                formasDePago.add(formaDePago);
            }
        }
        return formasDePago;
    }
}
