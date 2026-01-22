package pl.szwyngiel;

public class App
{
    private static Model model = new Model();
    private static View view = new View();

    private static Display display = new Display();

    public static void main( String[] args ) {
        new Controller(model, view);
        view.addDisplayObserver(display);
    }
}
