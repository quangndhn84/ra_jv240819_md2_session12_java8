package ra.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Student> listStudent = new ArrayList<>();
        listStudent.add(new Student("SV001", "Nguyễn Văn A", 20));
        listStudent.add(new Student("SV002", "Nguyễn Văn C", 18));
        listStudent.add(new Student("SV003", "Nguyễn Văn G", 22));
        listStudent.add(new Student("SV004", "Nguyễn Văn B", 20));
        listStudent.add(new Student("SV005", "Nguyễn Văn D", 20));
        listStudent.add(new Student("SV006", "Nguyễn Văn E", 25));
        //1. In ra các sinh viên có tuổi lớn hơn 20
        /*
         *   B1: Chuyển sang stream
         *   B2: thực hiện các thao tác trung gian
         *   B3: Thực hiên các thao tác đầu cuối
         * */
        System.out.println("1. CÁC SINH VIÊN CÓ TUỔI LỚN HƠN 20 LÀ:");
        //listStudent.stream().filter(student -> student.getAge() > 20).forEach(student->System.out.println(student));
        listStudent.stream().filter(student -> student.getAge() > 20).forEach(System.out::println);
        System.out.println("2. IN RA THÔNG TIN 3 SINH VIÊN ĐẦU TIÊN TRONG DANH SÁCH:");
        listStudent.stream().limit(3).forEach(System.out::println);
        System.out.println("3. IN RA THÔNG TIN 3 SINH VIÊN BẮT ĐẦU TỪ SINH VIÊN THỨ 3:");
        listStudent.stream().skip(2).limit(3).forEach(System.out::println);
        System.out.println("4. VIẾT HOA TÊN SINH VIÊN TRONG DANH SÁCH:");
        listStudent.stream().map(student -> student.getStudentName().toUpperCase()).forEach(System.out::println);
        //map {"NGUYỄN VĂN A", "NGUYỄN VĂN D",.....,"NGUYỄN VĂN E"}
        System.out.println("5. SẮP XẾP CÁC SINH VIÊN THEO TUỔI TĂNG DẦN:");
        listStudent.stream().sorted(Comparator.comparing(Student::getAge)).forEach(System.out::println);
        System.out.println("6. SẮP XẾP CÁC SINH VIÊN THEO TUỔI TĂNG DẦN VÀ TÊN GIẢM DẦN:");
        listStudent.stream()
                .sorted(Comparator.comparing(Student::getAge)
                        .thenComparing(Comparator.comparing(Student::getStudentName).reversed()))
                .forEach(System.out::println);
        System.out.println("7. TẠO DANH SÁCH SINH VIÊN GỒM CÁC SINH VIÊN CÓ TUỔI CHẴN VÀ IN RA:");
        List<Student> listStudentEvents = listStudent.stream().filter(student -> student.getAge() % 2 == 0).toList();
        listStudentEvents.forEach(System.out::println);
        System.out.println("8. TRONG DANH SÁCH CÓ SINH VIÊN NÀO TRONG ĐỘ TUỔI TỪ 23 ĐẾN 30 KHÔNG:");
        boolean resultAny = listStudent.stream().anyMatch(student -> student.getAge() >= 23 && student.getAge() <= 30);
        System.out.println("Kết quả: " + resultAny);
        System.out.println("9. TRONG DANH SÁCH TẤT CẢ SINH VIÊN CÓ TRONG ĐỘ TUỔI 18 ĐẾN 25 KHÔNG: ");
        boolean resultAll = listStudent.stream().allMatch(student -> student.getAge() >= 18 && student.getAge() <= 25);
        System.out.println("Kết quả: " + resultAll);
        System.out.println("10. TRONG DANH SÁCH TẤT CẢ SINH VIÊN ĐỀU KHÔNG NHỎ HƠN 18 TUỔI:");
        boolean resultNone = listStudent.stream().noneMatch(student -> student.getAge() < 18);
        System.out.println("Kết quả: " + resultNone);
        System.out.println("11. SỐ SINH VIÊN CÓ TUỔI LỚN HƠN HOẶC BẰNG 22 LÀ:");
        long cntStudent22 = listStudent.stream().filter(student -> student.getAge() >= 22).count();
        System.out.println("Số sinh viên có tuổi lớn hơn hoặc bằng 22: " + cntStudent22);
        System.out.println("12. IN RA SINH VIÊN CÓ TUỔI LỚN NHẤT");
        System.out.println(listStudent.stream().max(Comparator.comparing(Student::getAge)).get());
        System.out.println("13. IN RA SINH VIÊN CÓ TUỔI NHỎ NHẤT:");
        System.out.println(listStudent.stream().min(Comparator.comparing(Student::getAge)).get());
        System.out.println("THỐNG KÊ TUỔI SINH VIÊN:");
        IntSummaryStatistics iss = listStudent.stream().mapToInt(student -> student.getAge()).summaryStatistics();
        System.out.println("Tuổi trung bình: " + iss.getAverage());
        System.out.println("Tuổi lớn nhất: " + iss.getMax());
        System.out.println("Tuổi nhỏ nhất: " + iss.getMin());
        System.out.println("Tổng tuổi: " + iss.getSum());
        System.out.println("14. TÍNH TỔNG TUỔI CỦA CÁC SINH VIÊN:");
        int sumAge = listStudent.stream().reduce(0, (total, student) -> total + student.getAge(), Integer::sum);
        System.out.println("Tổng tuổi là: " + sumAge);

    }
}
