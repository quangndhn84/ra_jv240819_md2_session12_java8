package ra.optional;

import ra.stream.Student;

import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        Student student = getStudent();//null
        //null.getStudentName() --> NullPointerException
        if (student != null) {
            System.out.println("Tên sinh viên là: " + student.getStudentName());
        }
        //1. Sử dụng Optional để kiểm tra null
        Optional<Student> optStudent = Optional.ofNullable(student);
        if (optStudent.isPresent()) {
            System.out.println("Tên sinh viên là: " + student.getStudentName());
        }
        optStudent.ifPresent(student1 -> System.out.println("Tên sinh viên là: " + student1.getStudentName()));

        Student studentA = optStudent.orElse(new Student("SV001", "Nguyễn Văn A", 20));
        System.out.println("Tên sinh viên A: " + studentA.getStudentName());
        Student studentB = optStudent.orElseGet(() -> new Student("SV002", "Nguyễn Văn B", 19));
        System.out.println("Tên sinh viên B: " + studentB.getStudentName());
    }

    public static Student getStudent() {
        return null;
    }
}
