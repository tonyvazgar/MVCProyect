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
        String nombre, fecha, sexo, temperatura, diagnostico, tratamiento;
        int edad, peso;
        datos = new SequentialFile("/Users/tony/IdeaProjects/MVCProyect/src","recetas","txt");
        datos.open();
        numeroDeLineas = datos.getNumberOfLines();
        numeroDeRegistros = numeroDeLineas / 8;
        i = 0;
        while(i < numeroDeRegistros)
        {
            nombre = datos.readString();
            fecha = datos.readString();
            sexo = datos.readString();
            peso = datos.readInt();
            temperatura = datos.readString();
            edad = datos.readInt();
            diagnostico = datos.readString();
            tratamiento = datos.readString();
            paciente = new Paciente(nombre, fecha, sexo, peso, temperatura, edad, diagnostico, tratamiento);
            System.out.println(paciente.toString() + " " + paciente.getNombre() + " "+ paciente.getTemperatura() + " " + paciente.getTratamiento());
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
        if( indice < size() && indice >= 0) {
            remove(indice);
        }
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
