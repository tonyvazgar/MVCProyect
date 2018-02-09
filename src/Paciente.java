/*
 * Created by TonyVazgar on 2//18.
 */
public class Paciente implements  Comparable<Paciente>{
    private String nombre;
    private String fecha;
    private String sexo;
    private String peso;
    private String temperatura;
    private String edad;
    private String diagnostico;
    private String tratamiento;

    public Paciente(String nombre, String fecha, String sexo, String peso, String temperatura, String edad, String diagnostico, String tratamiento){
        this.nombre = nombre;
        this.fecha = fecha;
        this.sexo = sexo;
        this.peso = peso;
        this.temperatura = temperatura;
        this.edad = edad;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String  peso) {
        this.peso = peso;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    @Override
    public int compareTo(Paciente o) {
        String op = o.getNombre();
        return nombre.compareTo(op);
    }

    public String toString(){
        return nombre + " | " + fecha + " | " + sexo + " | " + peso + " | " + temperatura + " | " + edad + " | " + diagnostico + " | " + tratamiento;
    }
}
