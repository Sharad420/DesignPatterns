public class BeverageTester {
    public static void main(String[] args) {
        Tea tea = new Tea();
        Coffee coffee = new Coffee();

        coffee.prepare();
        tea.prepare();
    }
}