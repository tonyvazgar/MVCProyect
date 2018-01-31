/**
 * Created by TonyVazgar on 1/28/18.
 */

import java.awt.*;
import java.awt.event.ActionEvent;


public class Mediador implements Controller {
    InterfazPrincipal view;
    int indice = 0;
    InterfazNuevaReceta viewSecundario;
    Datos model;

    public Mediador(Datos model, InterfazPrincipal theView, InterfazNuevaReceta theView2) {
        model = model;
        view = theView;
        viewSecundario = theView2;
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
        Paciente paciente =  null;//new Paciente(view.nombre.getText(),Integer.parseInt(view.edad.getText()),view.tratamiento.getText());
        return paciente;
    }//end obtieneDatoDelView


    public void actualizaElView() {

    }//end actualizaElView


    ///////// Metodos de actualizacion del Model /////////////

    public void solicitaActualizacionDelModel(String accion) {


    }//end actualizaElModel



/*
    ///////// Metodos de control  /////////////

    private void decrementaApuntador() {
        if(indice == 0)
            indice = model.size()-1;
        else
            indice = indice - 1;
        //end if else
    }//end decrementaApuntador


    private void incrementaApuntador() {
        if(indice == model.size()-1)
            indice = 0;
        else
            indice = indice  + 1;
        //end if else
    }//end incrementaApuntador


    */


    public void actionPerformed(ActionEvent evento) {
        Button botonAccionado = (Button) evento.getSource();
        System.out.println(botonAccionado);
        viewSecundario = new InterfazNuevaReceta();
        if(botonAccionado == view.nuevo) {
            viewSecundario.inicia();
        }//end if

/*
        if(botonAccionado == view.botonAgregar)
        {
            if(interfazEstaLimpia)
            {
                solicitaActualizacionDelModel("agregar");
                actualizaElView();
            }//end if
        }//end if


        if(botonAccionado == view.botonEliminar)
        {
            if(model.hayDatos())
            {
                dialogo = new Dialogo(view, "Deseas eliminar este registro?");
                if(dialogo.seAceptaAccion())
                {
                    solicitaActualizacionDelModel("eliminar");
                    decrementaApuntador();
                    actualizaElView();
                }//end if
            }//end if
        }//end if


        if(botonAccionado == view.botonModificar)
        {
            solicitaActualizacionDelModel("modificar");
            actualizaElView();
        }//end if


        if(botonAccionado == view.botonOrdenar)
        {
            solicitaActualizacionDelModel("ordenar");
            indice = 0;
            actualizaElView();
        }//end if


        if(botonAccionado == view.botonSalvar)
        {
            dialogo = new Dialogo(view, "Deseas salvar  los datos?");
            if(dialogo.seAceptaAccion())
                model.salvaDatosDeLaEstructuraAlRepositorio();
            //end if
        }//end if


        if(botonAccionado == view.botonLimpiar)
        {
            limpiaInterfaz();
        }//end if
  */
    }//end actionPerformed

}//end class Mediator
