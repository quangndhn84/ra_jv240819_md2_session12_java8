package ra.functional_lambda;

public class Demo {
    public static void main(String[] args) {
        //1. Khởi tạo đối tượng gián tiếp từ IFunctional interface để tính tổng 2 số
        IFunctional if1 = new IFunctional() {
            @Override
            public int sumTwoNumber(int firstNumber, int secondNumber) {
                return firstNumber + secondNumber;
            }
        };
        System.out.println("Tổng 2 số 5 và 7 là: " + if1.sumTwoNumber(5, 7));
        //2. Khởi tạo đối tượng tù IFunctional interface để tính tổng 2 số có sử dụng biểu thức lambda
        IFunctional if2 = (a, b) -> {
            int sum = a + b;
            return sum;
        };
        System.out.println("Tổng 2 số 10 và 20 là: " + if2.sumTwoNumber(10, 20));
        //3. Khởi tạo đối tượng tù IFunctional interface để tính tổng 2 số có sử dụng biểu thức lambda rút gọn
        IFunctional if3 = (a, b) -> a + b;
        System.out.println("Tổng 2 số 15 và 30 là: " + if3.sumTwoNumber(15, 30));
    }
}
