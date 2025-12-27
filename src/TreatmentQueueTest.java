public class TreatmentQueueTest {
    public static void main(String[] args) {
        TreatmentQueue hospitalQueue = new TreatmentQueue();

        System.out.println("New 8 Treatment Requests");
        // ID ile 8 hasta ekleme
        hospitalQueue.enqueue(new TreatmentRequest(1));
        hospitalQueue.enqueue(new TreatmentRequest(2));
        hospitalQueue.enqueue(new TreatmentRequest(3));
        hospitalQueue.enqueue(new TreatmentRequest(4));
        hospitalQueue.enqueue(new TreatmentRequest(5));
        hospitalQueue.enqueue(new TreatmentRequest(6));
        hospitalQueue.enqueue(new TreatmentRequest(7));
        hospitalQueue.enqueue(new TreatmentRequest(8));

        hospitalQueue.printQueue();

        System.out.println("\nProcessing Requests");
        hospitalQueue.dequeue();
        hospitalQueue.dequeue();
        hospitalQueue.dequeue();

        System.out.println("\nRemaining Queue");
        hospitalQueue.printQueue();

        System.out.println("Total queue: " + hospitalQueue.size());
    }
}