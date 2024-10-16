package models;

public class Person_Vo {
    private int idPersona;
    private String nombrePersona;
    private int edadPersona;
    private String profesionPersona;
    private String telefonoPersona;

    // Constructor vacío (por si lo necesitas)
    public Person_Vo() {
    }

    // Constructor con parámetros
    public Person_Vo(int idPersona, String nombrePersona, int edadPersona, String profesionPersona, String telefonoPersona) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.edadPersona = edadPersona;
        this.profesionPersona = profesionPersona;
        this.telefonoPersona = telefonoPersona;
    }

    // Getters y Setters
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public int getEdadPersona() {
        return edadPersona;
    }

    public void setEdadPersona(int edadPersona) {
        this.edadPersona = edadPersona;
    }

    public String getProfesionPersona() {
        return profesionPersona;
    }

    public void setProfesionPersona(String profesionPersona) {
        this.profesionPersona = profesionPersona;
    }

    public String getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(String telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }
}
