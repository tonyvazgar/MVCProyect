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
    TextField edad;
    TextArea tratamiento;

    Label etiquetaNombre;
    Label etiquetaEdad;
    Label etiquetaAnos;
    Label etiquetaTratamiento;

    public InterfazPrincipal() {
        setTitle("*Recetas*");
        setBounds(100, 100, 460, 220);
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

        nuevo.setBounds(370, 50, 80, 20);
        add(nuevo);
        borrar.setBounds(370, 90, 80, 20);
        add(borrar);
        anterior.setBounds(370, 130, 80, 20);
        add(anterior);
        siguiente.setBounds(370, 170, 80, 20);
        add(siguiente);

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
