public class DischargeStackTest {
    public static void main(String[] args) {
        // Stack oluşturma
        DischargeStack historyStack = new DischargeStack();

        System.out.println("=== 1. Adding 5 Discharge Records (Push) ===");
        // 5 farklı hasta taburcu etme LIFO ile
        historyStack.push(new DischargeRecord(7));
        historyStack.push(new DischargeRecord(8));
        historyStack.push(new DischargeRecord(9));
        historyStack.push(new DischargeRecord(10));
        historyStack.push(new DischargeRecord(11));

        historyStack.printStack();

        System.out.println("\n 2. Processing 2 Records");
        // LIFO
        historyStack.pop();
        historyStack.pop();

        System.out.println("\n 3. Remaining Stack State");
        historyStack.printStack();
    }
}