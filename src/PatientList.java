public class PatientList {

    // Liste yapısını oluşturacak node sınıfı oluşturma
    private class PatientNode {
        Patient patientData;
        PatientNode nextNode;
        //Patient x adını verdim
        PatientNode(Patient x) {
            this.patientData = x;
            this.nextNode = null;
        }
    }
    private PatientNode headNode;

    // Yeni hasta ekleme addPatient kullanıp
    public void addPatient(Patient y) {
        // Eklenecek veriyi node içine eklemek için
        PatientNode newEntry = new PatientNode(y);

        // liste boşsa gelen ilk hasta en başa geçmesi
        if (headNode == null) {
            headNode = newEntry;
        } else {
            // Liste doluysa son elemanı bulana kadar ilerleme
            PatientNode iterator = headNode;
            while (iterator.nextNode != null) {
                iterator = iterator.nextNode;
            }
            // Son elemanı bulup sonuna eklemek
            iterator.nextNode = newEntry;
        }
        System.out.println("New patient registered into the system: " + y.name);
    }

    public void removePatient(int id) {
        if (headNode == null) {
            System.out.println("Error! Patient list empty!");
            return;
        }

        // Silinecek hasta en baştaysa headi kaydırma
        if (headNode.patientData.id == id) {
            headNode = headNode.nextNode;
            //Hastayı idsi ile birlikte listeden silmek için
            System.out.println("Patient " + id + " is removed.");
            return;
        }

        // Aradaki veya sondaki hastayları silmeden önce arama yapma
        PatientNode current = headNode;
        PatientNode previous = null;

        // Aranan ID'yi bulana kadar veya liste bitene kadar döndürme
        while (current != null && current.patientData.id != id) {
            // Bağı koparmamak için geçtiğimiz düğümü previous olarak tutma
            previous = current;
            current = current.nextNode;
        }

        // current null ise liste bitti ama hasta yok demektir
        if (current == null) {
            //Hasta bulunamadı hatası
            System.out.println("Patient ID " + id + " is not found.");
        } else {
            // Hastayı bulup önceki düğümü bir sonrakine bağlamak için
            previous.nextNode = current.nextNode;
            System.out.println("Patient with ID " + id + " is removed .");
        }
    }

    // Id ile arama yapıp hastayı döndürmek
    public Patient findPatient(int id) {
        PatientNode searcher = headNode;

        // Baştan sona kadar tek tek kontrol etmek
        while (searcher != null) {
            if (searcher.patientData.id == id) {
                return searcher.patientData;
            }
            searcher = searcher.nextNode;
        }
        return null;
    }

    // Tüm hastaları yazdırma printList methodu ile
    public void printList() {
        if (headNode == null) {
            System.out.println("The patient list is empty!");
            return;
        }

        System.out.println("Current Inpatient List");
        PatientNode temp = headNode;
        // Listeyi bozmamak için temp kullanımı
        while (temp != null) {
            System.out.println(temp.patientData);
            temp = temp.nextNode;
        }
        System.out.println("- - - - - - - - -");
    }
    public void sortPatientsBySeverity() {

        // Liste boşsa veya tek hasta varsa sıralamaya gerek yok
        if (headNode == null || headNode.nextNode == null) {
            return;
        }

        boolean swapping;
        do {
            swapping = false;
            PatientNode current = headNode;

            while (current.nextNode != null) {
                // Aciliyete göre kıyaslama yapma hangi hasta daha acilse ona bakmak için
                if (current.patientData.severity < current.nextNode.patientData.severity) {

                    // Node bağlantılarını koparmadan sadece içindeki datayı swapleme
                    Patient temp = current.patientData;
                    current.patientData = current.nextNode.patientData;
                    current.nextNode.patientData = temp;

                    swapping = true;
                }
                current = current.nextNode;
            }
        } while (swapping);
        //hastaların aciliyetlerine göre sıralandığını belirtmek için
        System.out.println("Patients are sorted by their severities.");
    }
}