public class TreatmentRequest {
    int patientId;
    long arrivalTime;
    boolean isEmergency;
    public TreatmentRequest(int pid, boolean isUrgent) {
        this.patientId = pid;
        this.arrivalTime = System.currentTimeMillis();
        this.isEmergency = isUrgent;
    }
    public TreatmentRequest(int pid) {
        this(pid, false);
    }
    @Override
    public String toString() {
        String durum = isEmergency ? "[ACIL]" : "[Normal]";
        return durum + " Request | Patient ID: " + patientId;
    }
}