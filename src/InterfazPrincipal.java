/*
 * Created by TonyVazgar on 1/27/18.
 */

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class InterfazPrincipal extends Frame implements View {
    //Elementos de la interfaz
    Button anterior;
    Button siguiente;
    Button nuevo;
    Button borrar;

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

    public InterfazPrincipal() {
        setTitle("*RECETAS*");
        setBounds(100, 100, 460, 420);
        setLocationRelativeTo(null);
        setBackground(new Color(255,255,255));
        setLayout(null);
        //Para hacer que se cierre el programa cuando damos en la equis de la centana
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
        setResizable(false);
        constuyeComponentes();
    }


    ///////// Construccion de los componentes de la interfaz //////////////
    public void constuyeComponentes() {
        nuevo = new Button("Nuevo");
        borrar = new Button("Borrar");
        anterior = new Button("Anterior");
        siguiente = new Button("Siguiente");

        nuevo.setBounds(370, 130, 80, 20);
        add(nuevo);
        borrar.setBounds(370, 170, 80, 20);
        add(borrar);
        anterior.setBounds(370, 210, 80, 20);
        add(anterior);
        siguiente.setBounds(370, 250, 80, 20);
        add(siguiente);

        etiquetaNombre = new Label("Nombre:");
        etiquetaFecha = new Label("Fecha");
        etiquetaSexo = new Label("Sexo:");
        etiquetaPeso = new Label("Peso:");
        etiquetaTemperatura = new Label("Temperatura:");
        etiquetaEdad = new Label("Edad:");
        etiquetaAnos = new Label("Años");
        etiquetaDiagnostico = new Label("Diagnostico:");
        etiquetaTratamiento = new Label("Tratamiento:");

        etiquetaNombre.setBounds(10, 50, 90, 20);
        add(etiquetaNombre);
        etiquetaFecha.setBounds(10, 80, 90, 20);
        add(etiquetaFecha);
        etiquetaSexo.setBounds(10, 110, 90, 20);
        add(etiquetaSexo);
        etiquetaPeso.setBounds(10, 140, 90, 20);
        add(etiquetaPeso);
        etiquetaTemperatura.setBounds(10, 170, 90, 20);
        add(etiquetaTemperatura);
        etiquetaEdad.setBounds(10, 200, 90, 20);
        add(etiquetaEdad);
        etiquetaAnos.setBounds(155, 200, 90, 20);
        add(etiquetaAnos);
        etiquetaDiagnostico.setBounds(10, 230, 90, 20);
        add(etiquetaDiagnostico);
        etiquetaTratamiento.setBounds(10, 260, 90, 20);
        add(etiquetaTratamiento);

        nombre = new TextField();
        fecha = new TextField();
        sexo = new TextField();
        peso = new TextField();
        temperatura = new TextField();
        edad = new TextField();
        diagnostico = new TextField();
        tratamiento = new TextArea();

        nombre.setBounds(100, 50, 250, 20);
        add(nombre);
        fecha.setBounds(100, 80, 250, 20);
        add(fecha);
        sexo.setBounds(100, 110, 250, 20);
        add(sexo);
        peso.setBounds(100, 140, 250, 20);
        add(peso);
        temperatura.setBounds(100, 170, 250, 20);
        add(temperatura);
        edad.setBounds(100, 200, 50, 20);
        add(edad);
        diagnostico.setBounds(100, 230, 250, 20);
        add(diagnostico);
        tratamiento.setBounds(100, 260, 250, 150);
        add(tratamiento);


    }

    public void setActionListener(Controller theController) {
        nuevo.addActionListener(theController);
        borrar.addActionListener(theController);
        anterior.addActionListener(theController);
        siguiente.addActionListener(theController);
    }//end setActionListener


    public void inicia() {
        setVisible(true);
    }



}//end class Interfaz
