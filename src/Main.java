public class Main {
    public static void main(String[] args)
    {
        InterfazPrincipal view;
        InterfazNuevaReceta view2;
        Datos model;
        Mediador controller;
        Mediador controller2;
        /////////////////////////////////////

        //Se crea el model.
        model = new Datos();

        // Se crea el view.
        view = new InterfazPrincipal();
        view2 = new InterfazNuevaReceta();

        // Se crea el controller,
        controller = new Mediador(model, view, view2);
        // y se asocia al view.
        view.setActionListener(controller);
        view2.setActionListener(controller);
        // se inicia el contenido del view
        controller.actualizaElView();

        // Se inicia la ejecucion de la aplicacion.
        view.inicia();
    }//end main
}
