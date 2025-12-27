public class HospitalSystemTest {
    public static void main(String[] args) {
        //sistemi başlatma
        HospitalSystem cityHospital = new HospitalSystem();

        System.out.println("Registering 10 Patients");
        // Format: ID, İsim, Severity (1-10), Yaş
        cityHospital.registerPatient(51, "Ederson Moraes", 3, 30);
        cityHospital.registerPatient(52, "Levent Mercan", 9, 45);
        cityHospital.registerPatient(53, "Milan Skriniar", 2, 22);
        cityHospital.registerPatient(54, "Jayden Oosterwolde", 8, 60);
        cityHospital.registerPatient(55, "Nelson Semedo", 1, 25);
        cityHospital.registerPatient(56, "İsmail Yüksek", 7, 35);
        cityHospital.registerPatient(57, "Edson Alvarez", 4, 28);
        cityHospital.registerPatient(58, "Marco Asensio", 10, 70);
        cityHospital.registerPatient(59, "Dorgeles Nene", 5, 40);
        cityHospital.registerPatient(60, "Jhon Duran", 6, 33);

        // Sorting Test kısmı
        System.out.println("\nPatients are prioritized according to the urgency of their condition.");
        cityHospital.triggerSorting();

        System.out.println("\nTreatment requests are creating.");
        // Acil istekleri sistem öne alır
        cityHospital.requestTreatment(52, true);
        cityHospital.requestTreatment(54, true);
        cityHospital.requestTreatment(58, true);

        // Normal hasta istekleri
        cityHospital.requestTreatment(51, false);
        cityHospital.requestTreatment(53, false);
        cityHospital.requestTreatment(55, false);
        cityHospital.requestTreatment(57, false);
        cityHospital.requestTreatment(59, false);

        System.out.println("\nManually discharging 2 people.");
        // 2 kişiyi tedavi etmeden listeden çıkarma
        cityHospital.dischargeManually(56);
        cityHospital.dischargeManually(70);

        // Anlık durumu görme
        System.out.println("\nCurrent status");
        cityHospital.showSystemStatus();

        System.out.println("\n4 requests are processing.");
        //Toplam 8 istek var ama 4 kere tedavi et deniyor Sistem önce 3 acil hastayı bitirmeli sonra normal sıradaki ilk hastayı almalı

        cityHospital.performTreatment();
        cityHospital.performTreatment();
        cityHospital.performTreatment();
        cityHospital.performTreatment();

        System.out.println("\nFinal System Status");
        cityHospital.showSystemStatus();
    }
}