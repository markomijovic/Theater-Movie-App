import Controller.ViewControllers.*;
import View.*;

public class App {
    public static void main(String[] args) {
        HomePage p = new HomePage();
        HomepageController c = new HomepageController(p);
        p.display();
    }
}
