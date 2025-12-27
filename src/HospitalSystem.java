import java.util.HashMap;

public class HospitalSystem {

    //Tüm veri yapılarını toplama
    private PatientList allPatients;
    private TreatmentQueue standardQueue;
    private TreatmentQueue emergencyQueue;
    private DischargeStack dischargeLog;

    // Hızlı arama yapmak için HashMap kullanımı
    private HashMap<Integer, Patient> patientDatabase;

    public HospitalSystem() {
        this.allPatients = new PatientList();
        this.standardQueue = new TreatmentQueue();
        this.emergencyQueue = new TreatmentQueue();
        this.dischargeLog = new DischargeStack();
        this.patientDatabase = new HashMap<>();
    }

    // 1. Sisteme Yeni Hasta Kaydetme
    public void registerPatient(int id, String name, int severity, int age) {
        Patient newPatient = new Patient(id, name, severity, age);

        // Listeye hasta ekleme yapma
        allPatients.addPatient(newPatient);

        // HashMape hasta ekleme (IDden kolayca bulunması için)
        patientDatabase.put(id, newPatient);
    }

    // 2.Hasta için muayene oluşturma
    public void requestTreatment(int id, boolean isUrgent) {
        // Bu id ile mevcutta bir hasta var mı kontrol etme
        if (!patientDatabase.containsKey(id)) {
            System.out.println("Error: Patient ID " + id + " is not found!");
            //Hasta bulunamadı
            return;
        }

        TreatmentRequest req = new TreatmentRequest(id, isUrgent);

        // Acil hastaysa acil kuyruğuna alma
        if (isUrgent) {
            emergencyQueue.enqueue(req);
        } else {
            // Acil hasta değilse normal hasta kuyruğuna alma
            standardQueue.enqueue(req);
        }
    }

    // Tedavi (Priority)
    public void performTreatment() {
        TreatmentRequest activeRequest = null;

        // Önce ACİL kuyruğuna bakıp Eğer acil hasta varsa önce onu almak için
        if (emergencyQueue.size() > 0) {
            System.out.println("PRIORITY TREATMENT STARTED");
            activeRequest = emergencyQueue.dequeue();
        }
        // Acil hasta yoksa normal hasta kuyruğuna bakma
        else if (standardQueue.size() > 0) {
            System.out.println("Standard Treatment Started");
            activeRequest = standardQueue.dequeue();
        }
        else {
            System.out.println("All waiting queues are empty!");
            return;
        }

        // Hasta tedavi olunca taburcu listesine alma (stack)
        if (activeRequest != null) {
            DischargeRecord dRec = new DischargeRecord(activeRequest.patientId);
            dischargeLog.push(dRec);
        }
    }

    // Hastayı manuel taburcu etme
    public void dischargeManually(int id) {
        if(patientDatabase.containsKey(id)){
            DischargeRecord dRec = new DischargeRecord(id);
            dischargeLog.push(dRec);
        }
    }

    // Hastaları aciliyete göre sıralama
    public void triggerSorting() {
        allPatients.sortPatientsBySeverity();
    }

    // Sistemin son durumu
    public void showSystemStatus() {
        System.out.println("\nHOSPITAL DASHBOARD");
        allPatients.printList();

        System.out.println("\n[Waiting Lists]");
        System.out.print("Severity Queue: "); emergencyQueue.printQueue();
        System.out.print("Normal Queue: "); standardQueue.printQueue();

        System.out.println("\n[Discharge History]");
        dischargeLog.printStack();
        System.out.println("- - - - - - - - - - - -\n");
    }
}