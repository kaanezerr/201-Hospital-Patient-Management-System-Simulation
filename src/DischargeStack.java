public class DischargeStack {

    private class StackNode {
        DischargeRecord recordData;
        StackNode next;

        StackNode(DischargeRecord r) {
            this.recordData = r;
            this.next = null;
        }
    }

    //Stackin en üstü (top)
    private StackNode topRecord;

    //LIFO
    public void push(DischargeRecord record) {
        StackNode newLayer = new StackNode(record);

        if (topRecord == null) {
            topRecord = newLayer;
        } else {
            // LIFO
            newLayer.next = topRecord;

            // Eklediğimiz artık yeni top oldu
            topRecord = newLayer;
        }
        System.out.println("Discharge record pushed " + record.patientId);
    }

    // LIFO
    public DischargeRecord pop() {
        if (topRecord == null) {
            System.out.println("Stack is empty now.");
            return null;
        }

        DischargeRecord poppedItem = topRecord.recordData;

        //LIFO
        topRecord = topRecord.next;

        System.out.println("Popped record for Patient ID: " + poppedItem.patientId);
        return poppedItem;
    }

    public DischargeRecord peek() {
        if (topRecord == null) {
            System.out.println("Stack is empty now.");
            return null;
        }
        return topRecord.recordData;
    }

    public void printStack() {
        if (topRecord == null) {
            System.out.println("No discharge records found.");
            return;
        }
        System.out.println("Discharge History");
        StackNode temp = topRecord;
        while (temp != null) {
            System.out.println(temp.recordData);
            temp = temp.next;
        }
        System.out.println("- - - - - - - - - - - -");
    }
}