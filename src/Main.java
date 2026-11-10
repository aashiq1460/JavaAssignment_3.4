
import java.io.*;

public class Main {

    public static void main(String[] args) {

        Student student = new Student(1, "John", 20);

        Course course = new Course(
                "JAVA101", "Java Programming", "Smith"
        );

        Enrollment enrollment = new Enrollment(
                student, course, "2023-01-01"
        );

        // Save the enrollment
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("enrollments.ser")
            );

            out.writeObject(enrollment);
            out.close();

            System.out.println("Enrollment saved!");

        } catch (IOException e) {
            System.out.println("Error saving: " + e);
        }

        // Read the enrollment
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("enrollments.ser")
            );

            Enrollment saved = (Enrollment) in.readObject();
            in.close();

            System.out.println("Student ID: " +
                    saved.getStudent().getId());

            System.out.println("Student Name: " +
                    saved.getStudent().getName());

            System.out.println("Student Age: " +
                    saved.getStudent().getAge());

            System.out.println("Course Code: " +
                    saved.getCourse().getCourseCode());

            System.out.println("Course Name: " +
                    saved.getCourse().getCourseName());

            System.out.println("Instructor: " +
                    saved.getCourse().getInstructor());

            System.out.println("Enrollment Date: " +
                    saved.getEnrollmentDate());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading: " + e);
        }
    }
}
