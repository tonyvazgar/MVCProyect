/**
 * Created by TonyVazgar on 1/28/18.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Mediador implements Controller {

    InterfazPrincipal view;
    InterfazNuevaReceta nuevaReceta;
    Paciente paciente;
    Datos model;
    String borrado;
    int indice;


    public Mediador(Datos model, InterfazPrincipal view, InterfazNuevaReceta nuevaReceta) {
        this.model = model;
        indice = 0;
        this.view = view;
        this.nuevaReceta = nuevaReceta;
    }

    public Mediador(){}
    
    /* ---------------------------------------------- *
     *        Metodos del la clase controller         *
     * ---------------------------------------------- */

    public Paciente obtieneDatoDelModel(int indice) {
        Paciente dato = null;
        if(model.hayDatos()){
            dato = model.get(indice);
        }
        return dato;
    }

    public Paciente obtieneDatoDelView() {
        Paciente paciente;

        String nombre, fecha, sexo, temperatura, diagnostico, tratamiento, edad, peso;


        nombre = view.nombre.getText();
        fecha = view.fecha.getText();
        sexo = view.sexo.getText();
        edad = view.edad.getText();
        temperatura = view.temperatura.getText();
        peso = view.peso.getText();
        diagnostico = view.diagnostico.getText();
        tratamiento = view.tratamiento.getText();

        paciente = new Paciente(nombre,fecha,sexo,peso,temperatura,edad,diagnostico,tratamiento);

        return paciente;
    }

    public void actualizaElView() {

        model.ordenaLaEstructura();
        paciente = obtieneDatoDelModel(indice);

        if (paciente != null) {
            view.nombre.setText(paciente.getNombre());
            view.fecha.setText(paciente.getFecha());
            view.sexo.setText(paciente.getSexo());
            view.edad.setText(paciente.getEdad());
            view.temperatura.setText(paciente.getTemperatura());
            view.peso.setText(paciente.getPeso());
            view.diagnostico.setText(paciente.getDiagnostico());
            view.tratamiento.setText(paciente.getTratamiento());
        }
    }
    
    public void solicitaActualizacionDelModel(String accion) {
        
        if(accion.equals("Borrar")){
            model.eliminaDatosDeLaEstructura(indice);
            decrementaApuntador();
            actualizaElView();
        }
    }

    public void actionPerformed(ActionEvent evento) {

        Button botonAccionado = (Button) evento.getSource();

        if(botonAccionado == view.nuevo) {
            InterfazNuevaReceta nr = new InterfazNuevaReceta();
            nr.mediador = this;
            nr.inicia();
        }else if(botonAccionado == view.borrar) {
            borrado = obtieneDatoDelView().getNombre().toUpperCase();
            solicitaActualizacionDelModel("Borrar");
            mensaje("Borrado");
        }else if(botonAccionado == view.anterior) {
            decrementaApuntador();
            actualizaElView();
        }else if(botonAccionado == view.siguiente) {
            incrementaApuntador();
            actualizaElView();
        }else if(botonAccionado == view.guardar){
            model.salvaDatosDeLaEstructuraAlRepositorio();
            mensaje("Guardado");
        }
    }
    
    /* ---------------------------------------------- *
     *              Metodos del propios               *
     * ---------------------------------------------- */
    
    private void decrementaApuntador() {
        if(indice == 0)
            indice = model.size()-1;
        else
            indice = indice - 1;
    }
    
    private void incrementaApuntador() {
        if(indice == model.size()-1)
            indice = 0;
        else
            indice = indice  + 1;
    }
    
    public void guadar(Paciente nuevoPaciente){
        indice = indice + 1;
        model.agregaDatosALaEstructura(indice, nuevoPaciente);
        actualizaElView();
    }

    private void mensaje(String mensaje){
        if(mensaje.equals("Borrado")){
            JOptionPane.showMessageDialog(view, "Se ha removido la receta de " + borrado + ", pulse el botón guardar para confirmar", "AVISO", JOptionPane.PLAIN_MESSAGE);
        }else if(mensaje.equals("Guardado")){
            JOptionPane.showMessageDialog(view, "SE HAN GUARDADO LOS DATOS CORRECTAMENTE", "AVISO", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
