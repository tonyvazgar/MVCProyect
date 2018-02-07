/**
 * Created by TonyVazgar on 1/28/18.
 */

import com.sun.deploy.net.proxy.pac.PACFunctions;

import java.awt.*;
import java.awt.event.ActionEvent;


public class Mediador implements Controller {

    InterfazPrincipal view;
    InterfazNuevaReceta nuevaReceta;
    Paciente paciente;
    Datos model;
    int indice;


    public Mediador(Datos model, InterfazPrincipal view, InterfazNuevaReceta nuevaReceta) {
        this.model = model;
        indice = 0;
        this.view = view;
        this.nuevaReceta = nuevaReceta;
    }//end constructor

    public Mediador(){

    }
    ///////// Metodos de obtencion de datos del Model /////////////

    public Paciente obtieneDatoDelModel(int indice) {
        Paciente dato = null;
        if(model.hayDatos()){
            dato = model.get(indice);
        }
        return dato;
    }//end obtieneDatoDelModel

    ///////// Metodos de obtencion de datos del View /////////////

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
    }//end obtieneDatoDelView


    public void actualizaElView() {
        model.ordenaLaEstructura();
        String nombre, fecha, sexo, temperatura, diagnostico, tratamiento;
        int peso, edad;

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
    }//end actualizaElView

    private void decrementaApuntador() {
        if(indice == 0)
            indice = model.size()-1;
        else
            indice = indice - 1;
    }//end decrementaApuntador


    private void incrementaApuntador() {
        if(indice == model.size()-1)
            indice = 0;
        else
            indice = indice  + 1;
    }//end incrementaApuntador



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
        indice = indice + 1;
        model.agregaDatosALaEstructura(indice, nuevoPaciente);
        actualizaElView();
        //model.salvaDatosDeLaEstructuraAlRepositorio();
        //System.err.println(indice);
    }


    public void actionPerformed(ActionEvent evento) {

        Button botonAccionado = (Button) evento.getSource();
        //System.out.println(botonAccionado.getLabel());

        if(botonAccionado == view.nuevo) {
            InterfazNuevaReceta nr = new InterfazNuevaReceta();
            nr.mediador = this;
            nr.inicia();
        }
        if(botonAccionado == view.borrar) {
            solicitaActualizacionDelModel("Borrar");
        }
        if(botonAccionado == view.anterior) {
            decrementaApuntador();
            actualizaElView();
        }
        if(botonAccionado == view.siguiente) {
            incrementaApuntador();
            actualizaElView();
        }
        if(botonAccionado == view.guardar){
            model.salvaDatosDeLaEstructuraAlRepositorio();
        }
    }
}//end class Mediator
