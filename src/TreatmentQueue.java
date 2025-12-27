public class TreatmentQueue {

    // kuyruk için özel node yapısı
    private class RequestNode {
        TreatmentRequest data;
        RequestNode next;

        RequestNode(TreatmentRequest req) {
            this.data = req;
            this.next = null;
        }
    }

    private RequestNode queueHead;
    private RequestNode queueTail;
    private int activeCount;

    // Constructor yapısı
    public TreatmentQueue() {
        this.queueHead = null;
        this.queueTail = null;
        this.activeCount = 0;
    }

    // kuyruğun sonuna ekleme (enqueue)
    public void enqueue(TreatmentRequest newRequest) {
        RequestNode newNode = new RequestNode(newRequest);

        // kuyruk boşsa kuyruğun başı ve sonu aynı
        if (queueTail == null) {
            queueHead = newNode;
            queueTail = newNode;
        } else {
            //FIFO
            queueTail.next = newNode;
            queueTail = newNode; // Artık yeni son bu oldu
        }
        activeCount++;
        System.out.println("Patient ID for queued request : " + newRequest.patientId);
    }

    // kuyruğun başından çıkarma (dequeue)
    public TreatmentRequest dequeue() {
        // kuyruk boşsa
        if (queueHead == null) {
            System.out.println("Queue is empty.");
            return null;
        }

        // Çıkarılacak veriyi saklama
        TreatmentRequest processedData = queueHead.data;
        //FIFO
        queueHead = queueHead.next;

        // Eğer kuyruğun başı nullsa, kuyruk tamamen boşa demektir, sonu da null yapmak için
        if (queueHead == null) {
            queueTail = null;
        }

        activeCount--;
        System.out.println("Processing request for Patient ID: " + processedData.patientId);
        return processedData;
    }

    // eleman sayısı bulma size methodu
    public int size() {
        return activeCount;
    }

    // listeleme printQueue ile
    public void printQueue() {
        if (queueHead == null) {
            System.out.println("Treatment queue is empty.");
            return;
        }

        System.out.println("Current Waiting Queue");
        RequestNode temp = queueHead;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("- - - - - - - - - -");
    }
}