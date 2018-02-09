/*
 * Created by TonyVazgar on 1/26/18.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JOptionPane;


public class InterfazNuevaReceta extends Frame implements ActionListener {
    
    /* ---------------------------------------------- *
     *           Elementos de la interfaz             *
     * ---------------------------------------------- */

    Font tipografia = new Font("Helvetica", Font.PLAIN, 14);

    Mediador mediador;
    Button cancelar;
    Button agregar;

    TextField nombre;
    TextField fecha;
    JComboBox sexoo;
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
    Label centigrados;
    Label etiquetaEdad;
    Label etiquetaAnos;
    Label etiquetaDiagnostico;
    Label etiquetaTratamiento;

    public InterfazNuevaReceta() {
        setTitle("Nueva receta");
        setBounds(100, 100, 460, 500);
        setLocationRelativeTo(null);
        setBackground(new Color(255,255,255));
        setLayout(null);
        setResizable(false);
        constuyeComponentes();
        setFont(tipografia);
        endProgram();
    }

    public void constuyeComponentes() {
        cancelar = new Button("Cancelar");
        agregar = new Button("Agregar");

        cancelar.setBounds(120, getHeight()-50, 80, 20);
        add(cancelar);
        agregar.setBounds(290, getHeight()-50, 80, 20);
        add(agregar);
        cancelar.addActionListener(this::actionPerformed);
        agregar.addActionListener(this::actionPerformed);

        etiquetaNombre = new Label("Nombre:");
        etiquetaFecha = new Label("Fecha");
        etiquetaSexo = new Label("Sexo:");
        etiquetaPeso = new Label("Peso:");
        etiquetaTemperatura = new Label("Temperatura:");
        centigrados = new Label("ºC");
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
        centigrados.setBounds(180,170,50,25);
        add(centigrados);
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
        sexoo = new JComboBox();
        peso = new TextField();
        temperatura = new TextField();
        edad = new TextField();
        diagnostico = new TextField();
        tratamiento = new TextArea();

        nombre.setBounds(120, 50, 250, 20);
        add(nombre);
        fecha.setBounds(120, 80, 250, 20);
        add(fecha);
        sexoo.addItem("Masculino");
        sexoo.addItem("Femenino");
        sexoo.setBounds(120,110,250,30);
        add(sexoo);
        peso.setBounds(120, 140, 250, 20);
        add(peso);
        temperatura.setBounds(120, 170, 50, 20);
        add(temperatura);
        edad.setBounds(120, 200, 50, 20);
        add(edad);
        diagnostico.setBounds(120, 230, 250, 20);
        add(diagnostico);
        tratamiento.setBounds(120, 260, 250, 150);
        add(tratamiento);
    }

    public void actionPerformed(ActionEvent evento) {
        Button botonAccionado = (Button) evento.getSource();
        if(botonAccionado == cancelar) {
            termina();
        }
        if (botonAccionado == agregar){

            Paciente dato = obtieneDatoDelView();
            mediador.guadar(dato);
            termina();
            JOptionPane.showMessageDialog(this, "Se ha agregado la receta de " + this.nombre.getText().toUpperCase() + ", pulse GUARDAR si quiere validar esta acción.", "AVISO", JOptionPane.PLAIN_MESSAGE);
            
        }
    }

    public Paciente obtieneDatoDelView() {

        String nombre, fecha, sexo, temperatura, diagnostico, tratamiento, edad, peso;

        nombre = this.nombre.getText();
        fecha = this.fecha.getText();
        sexo = this.sexoo.getItemAt(sexoo.getSelectedIndex()).toString();
        edad = this.edad.getText();
        temperatura = this.temperatura.getText();
        peso = this.peso.getText();
        diagnostico = this.diagnostico.getText();
        tratamiento = this.tratamiento.getText();

        return new Paciente(nombre,fecha,sexo,peso,temperatura,edad,diagnostico,tratamiento);
    }

    public void inicia() {
        setVisible(true);
    }

    public void termina() {
        setVisible(false);
    }
    
    public void endProgram() {
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we)
            {
                termina();
            }
        });
    }

}
