package models;

import java.sql.*;

public class Person_Dao {

    // Método para registrar una persona en la base de datos
    public void registrarPersona(Person_Vo miPersona) throws SQLException {
        ConnectionManager conex = new ConnectionManager(); // Crear una instancia de la clase Conexion
        String sql = "INSERT INTO persona (id, nombre, edad, profesion, telefono) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = conex.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, miPersona.getIdPersona());
            ps.setString(2, miPersona.getNombrePersona());
            ps.setInt(3, miPersona.getEdadPersona());
            ps.setString(4, miPersona.getProfesionPersona());
            ps.setString(5, miPersona.getTelefonoPersona());

            ps.executeUpdate();
            System.out.println("Persona registrada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar la persona: " + e.getMessage());
            throw e;
        }
    }

    // Método para buscar una persona por ID
    public Person_Vo buscarPersona(int codigo) throws SQLException {
        ConnectionManager conex = new ConnectionManager();
        String sql = "SELECT * FROM persona WHERE id = ?";
        Person_Vo persona = null;
        try (Connection con = conex.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                persona = new Person_Vo();
                persona.setIdPersona(rs.getInt("id"));
                persona.setNombrePersona(rs.getString("nombre"));
                persona.setEdadPersona(rs.getInt("edad"));
                persona.setProfesionPersona(rs.getString("profesion"));
                persona.setTelefonoPersona(rs.getString("telefono"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar la persona: " + e.getMessage());
            throw e;
        }
        return persona;
    }

    // Método para modificar los datos de una persona
    public void modificarPersona(Person_Vo miPersona) throws SQLException {
        ConnectionManager conex = new ConnectionManager();
        String sql = "UPDATE persona SET nombre = ?, edad = ?, profesion = ?, telefono = ? WHERE id = ?";
        try (Connection con = conex.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, miPersona.getNombrePersona());
            ps.setInt(2, miPersona.getEdadPersona());
            ps.setString(3, miPersona.getProfesionPersona());
            ps.setString(4, miPersona.getTelefonoPersona());
            ps.setInt(5, miPersona.getIdPersona());

            ps.executeUpdate();
            System.out.println("Persona modificada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al modificar la persona: " + e.getMessage());
            throw e;
        }
    }

    // Método para eliminar una persona por ID
    public void eliminarPersona(int codigo) throws SQLException {
        ConnectionManager conex = new ConnectionManager();
        String sql = "DELETE FROM persona WHERE id = ?";
        try (Connection con = conex.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, codigo);
            ps.executeUpdate();
            System.out.println("Persona eliminada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar la persona: " + e.getMessage());
            throw e;
        }
    }
}
