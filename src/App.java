import Controllers.StudentController;
import Models.StudentData;
import Views.StudentView;

public class App {
    static void main() {
        StudentData model = new StudentData();
        StudentView view = new StudentView();

        new StudentController(model, view);

        view.setVisible(true);

    }
}
