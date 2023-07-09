import Presenter.*;
import View.Registry;
import View.View;

public class Program {
    public static void main(String[] args) {
        Registry animals = new Registry();
        View view = new View();
        Presenter presenter = new Presenter(view, animals);
        presenter.Open();
    }
}