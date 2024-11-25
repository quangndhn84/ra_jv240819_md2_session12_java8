package ra.datetime_api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        //1. Ngày hiện tại
        LocalDate today = LocalDate.now();
        System.out.println("Ngày hiện tại: " + today);
        //2. Khởi tạo đối tượng sinh nhật từ năm 1984, tháng 4, ngày 23
        LocalDate birthDay = LocalDate.of(1984, 4, 23);
        System.out.println("Ngày sinh nhật của bạn: " + birthDay);
        //3. Ngày thứ 100 trong năm 2024
        LocalDate day100 = LocalDate.ofYearDay(2024, 100);
        System.out.println("Ngày thứ 100 của năm 2024: " + day100);
        //4. Giờ hiện tại
        LocalTime now = LocalTime.now();
        System.out.println("Giờ hiện tại: " + now);
        //5. Khởi tạo đối tương time từ giờ, phút, giây, nano giây
        LocalTime birthTime = LocalTime.of(5, 30, 15, 0);
        System.out.println("Giờ sinh của bạn: " + birthTime);
        //6. Lấy ngày giờ hiện tại
        LocalDateTime todayDateTime = LocalDateTime.now();
        System.out.println("Ngày giờ hiện tại: " + todayDateTime);
        //7. Tính khoảng thời gian từ ngày sinh đến hiện tại
        Period period = Period.between(birthDay, today);
        System.out.println("Khoảng thời gian từ sinh nhật đến hiện tại: " + period);
        Period periodPlus3 = period.plusYears(3);
        System.out.println("Period thêm 3 năm: " + periodPlus3);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào ngày sinh của bạn:");
        LocalDate bod = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Ngày sinh của bạn: "+bod);

    }
}
