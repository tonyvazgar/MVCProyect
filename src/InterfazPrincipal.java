/*
 * Created by TonyVazgar on 1/27/18.
 */

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class InterfazPrincipal extends Frame implements View {
    
    /* ---------------------------------------------- *
     *           Elementos de la interfaz             *
     * ---------------------------------------------- */

    Font tipografia = new Font("Helvetica", Font.PLAIN, 14);

    Button anterior;
    Button siguiente;
    Button nuevo;
    Button borrar;
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
    Label centigrados;
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
        setResizable(false);
        setFont(tipografia);
        constuyeComponentes();
        endProgram();
    }

    /* ---------------------------------------------- *
     *           Metodos del la clase view            *
     * ---------------------------------------------- */
    
    public void constuyeComponentes() {
        ponerBotones();
        ponerEtiquetas();
        ponerCasillas();
    }

    public void setActionListener(Controller theController) {
        nuevo.addActionListener(theController);
        borrar.addActionListener(theController);
        anterior.addActionListener(theController);
        siguiente.addActionListener(theController);
        guardar.addActionListener(theController);
    }
    
    /* ---------------------------------------------- *
     *               Metodos propios                  *
     * ---------------------------------------------- */
    
    public void ponerBotones(){
        nuevo = new Button("Nueva");
        borrar = new Button("Borrar");
        anterior = new Button("Anterior");
        siguiente = new Button("Siguiente");
        guardar = new Button("Guardar");

        nuevo.setBounds(370, 100, 80, 20);
        nuevo.setFont(tipografia);
        add(nuevo);
        borrar.setBounds(370, 140, 80, 20);
        add(borrar);
        anterior.setBounds(370, 240, 80, 20);
        add(anterior);
        siguiente.setBounds(370, 280, 80, 20);
        add(siguiente);
        guardar.setBounds(370,340,80,20);
        add(guardar);
    }

    public void ponerEtiquetas(){
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
        centigrados.setBounds(160,170,50,25);
        add(centigrados);
        etiquetaEdad.setBounds(10, 200, 90, 20);
        add(etiquetaEdad);
        etiquetaAnos.setBounds(155, 200, 90, 20);
        add(etiquetaAnos);
        etiquetaDiagnostico.setBounds(10, 230, 90, 20);
        add(etiquetaDiagnostico);
        etiquetaTratamiento.setBounds(10, 260, 90, 20);
        add(etiquetaTratamiento);
    }

    public void ponerCasillas(){
        nombre = new TextField();
        fecha = new TextField();
        sexo = new TextField();
        peso = new TextField();
        temperatura = new TextField();
        edad = new TextField();
        diagnostico = new TextField();
        tratamiento = new TextArea();

        nombre.setBounds(100, 50, 250, 20);
        nombre.setEditable(false);
        add(nombre);
        fecha.setBounds(100, 80, 250, 20);
        fecha.setEditable(false);
        add(fecha);
        sexo.setBounds(100, 110, 250, 20);
        sexo.setEditable(false);
        add(sexo);
        peso.setBounds(100, 140, 250, 20);
        peso.setEditable(false);
        add(peso);
        temperatura.setBounds(100, 170, 50, 20);
        temperatura.setEditable(false);
        add(temperatura);
        edad.setBounds(100, 200, 50, 20);
        edad.setEditable(false);
        add(edad);
        diagnostico.setBounds(100, 230, 250, 20);
        diagnostico.setEditable(false);
        add(diagnostico);
        tratamiento.setBounds(100, 260, 250, 150);
        tratamiento.setEditable(false);
        add(tratamiento);
    }

    public void inicia() {
        setVisible(true);
    }

    public void endProgram() {
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
    }
}
