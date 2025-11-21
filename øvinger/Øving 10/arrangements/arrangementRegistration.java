import java.util.*;

class arrangementRegistration {
    private List<arrangement> arrangements;

    public arrangementRegistration() {
        arrangements = new ArrayList<>();
    }

    /** Register a new arrangement. */
    public void registrer(arrangement a) {
        arrangements.add(a);
    }

    /** find all arrangements on a given location. */
    public List<arrangement> findOnlocation(String location) {
        List<arrangement> result = new ArrayList<>();
        for (arrangement a : arrangements) {
            if (a.getLocation().equalsIgnoreCase(location)) {
                result.add(a);
            }
        }
        return result;
    }

    /** find all arrangements on a given date (yyyyMMdd). */
    public List<arrangement> findOnDate(int date) {
        List<arrangement> result = new ArrayList<>();
        for (arrangement a : arrangements) {
            if (a.getDate() == date){
                result.add(a);
            }
        }
        return result;
    }

    /**find all arrangements within an intervall of dates. */
    public List<arrangement> findBetweenDates(int fromDate, int toDate) {
        List<arrangement> result = new ArrayList<>();
        for (arrangement a : arrangements){
            int dato = a.getDate();
            if (dato >= fromDate && dato <= toDate){
                result.add(a);
            }
        }
        result.sort(Comparator.comparingLong(arrangement::getTimestamp));
        return result;
    }

    /** all arrangements sorted By location. */
    public List<arrangement> sortedBylocation() {
        List<arrangement> copy = new ArrayList<>(arrangements);
        copy.sort(Comparator.comparing(arrangement::getLocation)
                            .thenComparingLong(arrangement::getTimestamp));
        return copy;
    }

    /** all arrangements sorted By type. */
    public List<arrangement> sortedByType() {
        List<arrangement> copy = new ArrayList<>(arrangements);
        copy.sort(Comparator.comparing(arrangement::getType)
                            .thenComparingLong(arrangement::getTimestamp));
        return copy;
    }

    /** all arrangements sorted By Timestamp. */
    public List<arrangement> sortedByTimestamp() {
        List<arrangement> copy = new ArrayList<>(arrangements);
        copy.sort(Comparator.comparingLong(arrangement::getTimestamp));
        return copy;
    }

    /** get all uten sortering (som de ligger lagret). */
    public List<arrangement> getall() {
        return new ArrayList<>(arrangements);
    }
}
