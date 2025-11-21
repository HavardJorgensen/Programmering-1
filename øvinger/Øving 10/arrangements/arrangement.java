
class arrangement {
    private int nr;             
    private String name;
    private String location;
    private String organizer;
    private String type;     
    private long timestamp;

    public arrangement(int nr, String name, String location, String organizer, String type, long timestamp) {
        this.nr = nr;
        this.name = name;
        this.location = location;
        this.organizer = organizer;
        this.type = type;
        this.timestamp = timestamp;
    }

    public int getNr(){ 
        return nr; 
    }

    public String getName(){ 
        return name; 
    }

    public String getLocation(){
        return location; 
    }

    public String getOrganizer(){
        return organizer;
    }

    public String getType(){ 
        return type; 
    }

    public long getTimestamp(){ 
        return timestamp;
    }


    /** Date in yyyyMMdd from timestamp. */
    public int getDate() {
        return (int)(timestamp / 10000L);
    }

    @Override
    public String toString() {
        return "Nr: " + nr +
               ", Name: " + name +
               ", Location: " + location +
               ", Organizer: " + organizer +
               ", Type: " + type +
               ", Timestamp: " + timestamp;
    }
}
