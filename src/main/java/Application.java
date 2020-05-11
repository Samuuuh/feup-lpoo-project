

import controller.MainController;
import view.ScreenView;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException, InterruptedException {
        ScreenView gui = new ScreenView(30, 20);

        MainController controller = new MainController(gui);
        controller.run();

        gui.close();
    }
}