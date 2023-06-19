package hero.vired.javasessions;

class Appointment {
    private String visitorName;
    private String date;
    private String time;

    public Appointment(String visitorName, String date, String time) {
        this.visitorName = visitorName;
        this.date = date;
        this.time = time;
    }

    // Getter and Setter methods
    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Visitor: " + visitorName + "\nDate: " + date + "\nTime: " + time;
    }
}
