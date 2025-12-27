public class DischargeRecord {
    int patientId;
    long dischargeTime;

    public DischargeRecord(int pid) {
        this.patientId = pid;
        this.dischargeTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Discharged Patient ID: " + patientId + " | Time: " + dischargeTime;
    }
}