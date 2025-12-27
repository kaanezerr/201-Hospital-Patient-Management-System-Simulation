public class PatientListTest {
    public static void main(String[] args) {
        // Yeni liste oluşturmak için
        PatientList myPatientList = new PatientList();

        // 5 adet hasta ekleme
        System.out.println("=== Adding 5 Patients ===");
        myPatientList.addPatient(new Patient(1907, "Volkan Demirel", 9, 41));
        myPatientList.addPatient(new Patient(13, "Gökhan Gönül", 3, 39));
        myPatientList.addPatient(new Patient(15, "Mehmet Aurelio", 1, 45));
        myPatientList.addPatient(new Patient(17, "Selçuk Şahin", 4, 43));
        myPatientList.addPatient(new Patient(19, "Caner Erkin", 8, 35));

        // Listeyi görme
        myPatientList.printList();

        // ID ile hastayı silme
        System.out.println("\n=== Removing patient with ID 13 ===");

        myPatientList.removePatient(13);

        // Kodu test için listede olmayan birini silme
        System.out.println("\n=== Trying to remove non-existing ID 1905 ===");

        myPatientList.removePatient(1905);

        // ID ile hasta arama
        System.out.println("\n=== Searching for Patient with ID 15 ===");
        Patient found = myPatientList.findPatient(15);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Patient is not found.");
        }

        // Listeyi yazdırmak için
        System.out.println("\n=== Final Patient List ===");
        myPatientList.printList();
    }
}