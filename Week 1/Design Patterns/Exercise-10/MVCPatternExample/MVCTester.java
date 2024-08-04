public class MVCTester {
    public static void main(String[] args) {
        Student student = new Student("1", "John Doe", "A");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);

        controller.updateView();

        controller.setStudentName("Jane Doe");
        controller.setStudentGrade("B");

        controller.updateView();
    }
}
