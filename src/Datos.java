/*
 * Created by TonyVazgar on 1/28/18.
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Collections;

public class Datos extends LinkedList<Paciente> implements Model {

    SequentialFile datos;

    public Datos(){
        cargaDatosDelRepositorioALaEstructura();
    }

    @Override
    public void cargaDatosDelRepositorioALaEstructura() {
        int numeroDeLineas;
        int numeroDeRegistros;
        int i;
        Paciente paciente;
        String nombre;
        int edad;
        String tratamiento;
        datos = new SequentialFile("/Users/tony/IdeaProjects/MVCProyect/src","recetas","txt");
        datos.open();
        numeroDeLineas = datos.getNumberOfLines();
        numeroDeRegistros = numeroDeLineas / 3;
        i = 0;
        while(i < numeroDeRegistros)
        {
            nombre = datos.readString();
            edad = datos.readInt();
            tratamiento = datos.readString();
            paciente = new Paciente(nombre,edad,tratamiento);
            System.out.println(paciente.toString());
            add(paciente);
            i = i + 1;
        }//end while

    }

    @Override
    public void salvaDatosDeLaEstructuraAlRepositorio() {

    }

    @Override
    public void agregaDatosALaEstructura(int indice, Object unDato) {
        Paciente dato;
        //
        dato = (Paciente) unDato;
        add(indice, dato);
    }

    @Override
    public void modificaDatosEnLaEstructura(int indice, Object dato) {

    }

    @Override
    public void eliminaDatosDeLaEstructura(int indice) {

    }

    @Override
    public void ordenaLaEstructura() {

    }

    @Override
    public double procesa(int indice) {
        return 0;
    }

    @Override
    public boolean hayDatos() {
        int tam = size();

        if (tam > 0) {
            return true;
        } else {
            return false;
        }
    }
}
