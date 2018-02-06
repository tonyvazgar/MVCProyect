/**
 * Created by TonyVazgar on 1/28/18.
 */

import java.awt.*;
import java.awt.event.ActionEvent;


public class Mediador implements Controller {

    InterfazPrincipal view;
    InterfazNuevaReceta nuevaReceta;
    Paciente paciente;
    Boolean agregado;
    Datos model;
    int indice;


    public Mediador(Datos model, InterfazPrincipal view, InterfazNuevaReceta nuevaReceta) {
        this.model = model;
        indice = 0;
        agregado = false;
        this.view = view;
        this.nuevaReceta = nuevaReceta;
    }//end constructor

    public Mediador(){

    }
    ///////// Metodos de obtencion de datos del Model /////////////

    public Paciente obtieneDatoDelModel(int indice) {
        Paciente dato;
        if(model.hayDatos()){
            dato = model.get(indice);
        }else {
            dato = null;
        }
        return dato;
    }//end obtieneDatoDelModel

    ///////// Metodos de obtencion de datos del View /////////////

    public Paciente obtieneDatoDelView() {

        String nombre, fecha, sexo, temperatura, diagnostico, tratamiento, edad, peso;


        nombre = view.nombre.getText();
        fecha = view.fecha.getText();
        sexo = view.sexo.getText();
        edad = view.edad.getText();
        temperatura = view.temperatura.getText();
        peso = view.peso.getText();
        diagnostico = view.diagnostico.getText();
        tratamiento = view.tratamiento.getText();

        return new Paciente(nombre,fecha,sexo,edad,temperatura,peso,diagnostico,temperatura);
    }//end obtieneDatoDelView


    public void actualizaElView() {
        String nombre, fecha, sexo, temperatura, diagnostico, tratamiento;
        int peso, edad;
        paciente = obtieneDatoDelModel(indice);
        System.err.println(paciente.toString() + "***" + paciente.getNombre());
        if (paciente != null && !agregado){
            view.nombre.setText(paciente.getNombre());
            view.fecha.setText(paciente.getFecha());
            view.sexo.setText(paciente.getSexo());
            view.edad.setText(paciente.getEdad());
            view.temperatura.setText(paciente.getTemperatura());
            view.peso.setText(paciente.getPeso());
            view.diagnostico.setText(paciente.getDiagnostico());
            view.tratamiento.setText(paciente.getTratamiento());
        }else if(agregado){
            view = new InterfazPrincipal();
            view.nombre.setText(paciente.getNombre());
            view.fecha.setText(paciente.getFecha());
            view.sexo.setText(paciente.getSexo());
            view.edad.setText(paciente.getEdad());
            view.temperatura.setText(paciente.getTemperatura());
            view.peso.setText(paciente.getPeso());
            view.diagnostico.setText(paciente.getDiagnostico());
            view.tratamiento.setText(paciente.getTratamiento());
        }
    }//end actualizaElView


    ///////// Metodos de actualizacion del Model /////////////

    public void solicitaActualizacionDelModel(String accion) {

        if(accion.equals("Borrar")){
            model.eliminaDatosDeLaEstructura(indice);
            if(indice == model.size()-1){
                indice = 0;
            }else {
                indice = indice + 1;
            }
            actualizaElView();
        }
    }//end actualizaElModel


    public void guadar(Paciente nuevoPaciente){
        this.paciente = nuevoPaciente;
        model = new Datos();
        indice = indice + 1;
        System.err.println(indice);
        model.agregaDatosALaEstructura(indice, this.paciente);
        agregado = true;
        actualizaElView();
        model.salvaDatosDeLaEstructuraAlRepositorio();
    }


    public void actionPerformed(ActionEvent evento) {

        Button botonAccionado = (Button) evento.getSource();
        System.out.println(botonAccionado.getLabel());

        switch (botonAccionado.getLabel()){
            case "Nuevo":
                nuevaReceta.inicia();
                break;
            case "Borrar":
                solicitaActualizacionDelModel("Borrar");
                break;
            case "Anterior":
                if(indice == 0) {
                    indice = model.size() - 1;
                }else {
                    indice = indice - 1;
                }
                actualizaElView();
                break;
            case "Siguiente":
                if(indice == model.size()-1){
                    indice = 0;
                }else {
                    indice = indice + 1;
                }
                actualizaElView();
                break;
        }
    }
}//end class Mediator
