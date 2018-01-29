public class Paciente {
    private String nombre;
    private int edad;
    private String tratamiento;

    public Paciente(String elNombre, int laEdad, String elTratamiento){
        nombre = elNombre;
        edad = laEdad;
        tratamiento = elTratamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
}
