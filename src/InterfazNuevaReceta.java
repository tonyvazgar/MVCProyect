/*
 * Created by TonyVazgar on 1/26/18.
 */

import java.awt.*;
import java.awt.event.*;


public class InterfazNuevaReceta extends Frame implements ActionListener {

    Font tipografia = new Font("Helvetica", Font.PLAIN, 14);

    Button cancelar;
    Button guardar;

    TextField nombre;
    TextField fecha;
    TextField sexo;
    TextField peso;
    TextField temperatura;
    TextField edad;
    TextField diagnostico;
    TextArea tratamiento;

    Label etiquetaNombre;
    Label etiquetaFecha;
    Label etiquetaSexo;
    Label etiquetaPeso;
    Label etiquetaTemperatura;
    Label etiquetaEdad;
    Label etiquetaAnos;
    Label etiquetaDiagnostico;
    Label etiquetaTratamiento;

    public InterfazNuevaReceta() {
        Color color;
        setTitle("Nueva receta");
        setBounds(100, 100, 460, 500);
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
        setFont(tipografia);
    }//end constructor

    public void constuyeComponentes() {
        cancelar = new Button("Cancelar");
        guardar = new Button("Guardar");

        cancelar.setBounds(120, getHeight()-50, 80, 20);
        add(cancelar);
        guardar.setBounds(290, getHeight()-50, 80, 20);
        add(guardar);
        cancelar.addActionListener(this::actionPerformed);
        guardar.addActionListener(this::actionPerformed);

        etiquetaNombre = new Label("Nombre:");
        etiquetaFecha = new Label("Fecha");
        etiquetaSexo = new Label("Sexo:");
        etiquetaPeso = new Label("Peso:");
        etiquetaTemperatura = new Label("Temperatura:");
        etiquetaEdad = new Label("Edad:");
        etiquetaAnos = new Label("Años");
        etiquetaDiagnostico = new Label("Diagnostico:");
        etiquetaTratamiento = new Label("Tratamiento:");

        etiquetaNombre.setBounds(30, 50, 90, 20);
        add(etiquetaNombre);
        etiquetaFecha.setBounds(30, 80, 90, 20);
        add(etiquetaFecha);
        etiquetaSexo.setBounds(30, 110, 90, 20);
        add(etiquetaSexo);
        etiquetaPeso.setBounds(30, 140, 90, 20);
        add(etiquetaPeso);
        etiquetaTemperatura.setBounds(30, 170, 90, 20);
        add(etiquetaTemperatura);
        etiquetaEdad.setBounds(30, 200, 90, 20);
        add(etiquetaEdad);
        etiquetaAnos.setBounds(185, 200, 90, 20);
        add(etiquetaAnos);
        etiquetaDiagnostico.setBounds(30, 230, 90, 20);
        add(etiquetaDiagnostico);
        etiquetaTratamiento.setBounds(30, 260, 90, 20);
        add(etiquetaTratamiento);

        nombre = new TextField();
        fecha = new TextField();
        sexo = new TextField();
        peso = new TextField();
        temperatura = new TextField();
        edad = new TextField();
        diagnostico = new TextField();
        tratamiento = new TextArea();

        nombre.setBounds(120, 50, 250, 20);
        add(nombre);
        fecha.setBounds(120, 80, 250, 20);
        add(fecha);
        sexo.setBounds(120, 110, 250, 20);
        add(sexo);
        peso.setBounds(120, 140, 250, 20);
        add(peso);
        temperatura.setBounds(120, 170, 250, 20);
        add(temperatura);
        edad.setBounds(120, 200, 50, 20);
        add(edad);
        diagnostico.setBounds(120, 230, 250, 20);
        add(diagnostico);
        tratamiento.setBounds(120, 260, 250, 150);
        add(tratamiento);
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
