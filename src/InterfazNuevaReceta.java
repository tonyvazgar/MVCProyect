/*
 * Created by TonyVazgar on 1/26/18.
 */

import java.awt.*;
import java.awt.event.*;


public class InterfazNuevaReceta extends Frame implements ActionListener {
    Button cancelar;
    Button guardar;

    TextField nombre;
    TextField edad;
    TextArea tratamiento;

    Label etiquetaNombre;
    Label etiquetaEdad;
    Label etiquetaAnos;
    Label etiquetaTratamiento;

    public InterfazNuevaReceta() {
        Color color;
        setTitle("Nueva receta");
        setBounds(100, 100, 400, 250);
        setLocationRelativeTo(null);
        setBackground(new Color(255,255,255));
        setLayout(null);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we)
            {
                termina();
            }
        });
        setResizable(false);
        constuyeComponentes();
    }//end constructor

    public void constuyeComponentes() {
        cancelar = new Button("Cancelar");
        guardar = new Button("Guardar");

        cancelar.setBounds(120, 210, 80, 20);
        add(cancelar);
        guardar.setBounds(200, 210, 80, 20);
        add(guardar);
        cancelar.addActionListener(this::actionPerformed);
        guardar.addActionListener(this::actionPerformed);

        nombre = new TextField();
        edad = new TextField();
        tratamiento = new TextArea();

        nombre.setBounds(100, 50, 250, 20);
        add(nombre);
        edad.setBounds(100, 80, 50, 20);
        add(edad);
        tratamiento.setBounds(100, 110, 250, 80);
        add(tratamiento);

        etiquetaNombre = new Label("Nombre:");
        etiquetaEdad = new Label("Edad:");
        etiquetaAnos = new Label("Años");
        etiquetaTratamiento = new Label("Tratamiento:");

        etiquetaNombre.setBounds(10, 50, 200, 20);
        add(etiquetaNombre);
        etiquetaEdad.setBounds(10, 80, 100, 20);
        add(etiquetaEdad);
        etiquetaAnos.setBounds(155, 80, 100, 20);
        add(etiquetaAnos);
        etiquetaTratamiento.setBounds(10, 110, 200, 20);
        add(etiquetaTratamiento);
    }//end constuyeComponentes

    public void actionPerformed(ActionEvent evento) {
        Button botonAccionado = (Button) evento.getSource();
        System.out.println(botonAccionado);
        if(botonAccionado == cancelar) {
            termina();
        }else if (botonAccionado == guardar){
            //Accion para guardar datos

        }//end if
    }//end actionPerformed

    public void inicia() {
        setVisible(true);
    }//end inicia
    public void termina(){
        setVisible(false);
    }
}//end class Interfaz
