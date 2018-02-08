public class Main {
    public static void main(String[] args) {
        InterfazPrincipal viewPrincipal;
        InterfazNuevaReceta viewNuevaReceta;
        Datos model;
        Mediador controller;

        //Se crea el model.
        model = new Datos();

        // Se crea el view.
        viewPrincipal = new InterfazPrincipal();
        viewNuevaReceta = new InterfazNuevaReceta();

        // Se crea el controller,
        controller = new Mediador(model, viewPrincipal, viewNuevaReceta);
        // y se asocia al view.
        viewPrincipal.setActionListener(controller);
        // se inicia el contenido del view
        controller.actualizaElView();

        // Se inicia la ejecucion de la aplicacion.
        viewPrincipal.inicia();
    }//end main
}
