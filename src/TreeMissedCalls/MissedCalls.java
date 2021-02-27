package TreeMissedCalls;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {
    private Map<LocalDateTime, String> missedCalls;

    public MissedCalls() {
        missedCalls = new TreeMap<>();
    }

    public void addMissedCall(String missedNumber) {
        missedCalls.put(LocalDateTime.now(), missedNumber);
    }

    public void clearMissedCalls() {
        missedCalls.clear();
    }

    public void writeMissedCalls(ContactStore contacts) {
        String missedContact;
        if (missedCalls.isEmpty())
            System.out.println("Пропущенных вызовов нет");
        else {
            System.out.println("Список пропущенных вызовов:");
            for (Map.Entry<LocalDateTime, String> entry : missedCalls.entrySet()) {
                missedContact = contacts.getContactMap().containsKey(entry.getValue()) ? contacts.getContactMap().get(entry.getValue()).toString() : entry.getValue();
                System.out.printf("\n%s - %s", entry.getKey(), missedContact);
            }
            System.out.println();
        }
    }
}
