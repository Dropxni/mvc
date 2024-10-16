package models;

public class Logic {

    private Person_Dao personDao = new Person_Dao(); // Instancia del DAO

    // Validar el registro de una persona
    public String validarRegistro(Person_Vo miPersona) {
        if (miPersona.getIdPersona() > 99) {
            try {
                // Inserta la persona en la base de datos
                personDao.registrarPersona(miPersona); // Llamada correcta
                return "Registro completado exitosamente.";
            } catch (Exception e) {
                e.printStackTrace();
                return "Error al registrar en la base de datos: " + e.getMessage();
            }
        } else {
            return "El ID debe ser mayor a 99.";
        }
    }

    // Validar la consulta de una persona
    public Person_Vo validarConsulta(String codigoPersona) {
        int codigo = Integer.parseInt(codigoPersona);
        if (codigo > 99) {
            try {
                return personDao.buscarPersona(codigo); // Llamada correcta
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    // Validar modificación
    public String validarModificacion(Person_Vo miPersona) {
        if (miPersona.getNombrePersona().length() > 5) {
            try {
                personDao.modificarPersona(miPersona); // Llamada correcta
                return "Modificación completada exitosamente.";
            } catch (Exception e) {
                e.printStackTrace();
                return "Error al modificar en la base de datos: " + e.getMessage();
            }
        } else {
            return "El nombre debe tener más de 5 caracteres.";
        }
    }

    // Validar eliminación
    public String validarEliminacion(String codigo) {
        int id = Integer.parseInt(codigo);
        if (id > 99) {
            try {
                personDao.eliminarPersona(id); // Llamada correcta
                return "Eliminación completada exitosamente.";
            } catch (Exception e) {
                e.printStackTrace();
                return "Error al eliminar en la base de datos: " + e.getMessage();
            }
        } else {
            return "El código debe ser mayor a 99.";
        }
    }
}
