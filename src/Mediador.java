/**
 * Created by TonyVazgar on 1/28/18.
 */

import java.awt.*;
import java.awt.event.ActionEvent;


public class Mediador implements Controller {

    InterfazPrincipal view;
    InterfazNuevaReceta nuevaReceta;
    Datos model;
    int indice = 0;


    public Mediador(Datos model, InterfazPrincipal view) {
        this.model = model;
        this.view = view;
    }//end constructor


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

        String nombre, fecha, sexo, temperatura, diagnostico, tratamiento;
        int peso, edad;

        nombre = view.nombre.getText();
        fecha = view.fecha.getText();
        sexo = view.sexo.getText();
        edad = Integer.parseInt(view.edad.getText());
        temperatura = view.temperatura.getText();
        peso = Integer.parseInt(view.peso.getText());
        diagnostico = view.diagnostico.getText();
        tratamiento = view.tratamiento.getText();

        return new Paciente(nombre,fecha,sexo,edad,temperatura,peso,diagnostico,temperatura);
    }//end obtieneDatoDelView


    public void actualizaElView() {

        String nombre, fecha, sexo, temperatura, diagnostico, tratamiento;
        int peso, edad;
        Paciente paciente = obtieneDatoDelModel(indice);
        if (paciente != null){
            view.nombre.setText(paciente.getNombre());
            view.fecha.setText(paciente.getFecha());
            view.sexo.setText(paciente.getSexo());
            view.edad.setText(Integer.toString(paciente.getEdad()));
            view.temperatura.setText(paciente.getTemperatura());
            view.peso.setText(Integer.toString(paciente.getPeso()));
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
        }else if(accion.equals("Guardar")){
            /*
            dato = obtieneDatoDelView();
            indice = indice + 1;
            model.agregaDatosALaEstructura(indice, dato);
             */
        }
    }//end actualizaElModel

    public void actionPerformed(ActionEvent evento) {

        Button botonAccionado = (Button) evento.getSource();
        System.out.println(botonAccionado.getLabel());

        switch (botonAccionado.getLabel()){
            case "Nuevo":
                nuevaReceta = new InterfazNuevaReceta();
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
