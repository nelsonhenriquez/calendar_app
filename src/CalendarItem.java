public class CalendarItem {
    private String itemName;
    private String itemDate;

    public CalendarItem(String itemName, String itemTime) {
        this.itemName = itemName;
        this.itemDate = itemTime;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String eventName) {
        this.itemName = itemName;
    }

    public String getItemDate() {
        return this.itemDate;
    }

    public void setItemDate(String itemDate) {
        this.itemDate = itemDate;
    }
}

class Event extends CalendarItem {
    private String locationName;

    public Event(String itemName, String itemDate, String locationName) {
        super(itemName, itemDate);
        this.locationName = locationName;
    }

    public String toString() {
        return "Event!\n" + getItemName() + "\n" + "Date: " + getItemDate() + "\n" + "Location: " + getLocationName();
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}

class Reminder extends CalendarItem {
    private String reminderTime;

    public Reminder(String itemName, String itemDate, String reminderTime) {
        super(itemName, itemDate);
        this.reminderTime = reminderTime;
    }

    public String toString() {
        return "Reminder!\n" + getItemName() + "\n" + "Date: " + getItemDate() + "\n" + "Reminder Time: " + getReminderTime();
    }

    public String getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(String reminderTime) {
        this.reminderTime = reminderTime;
    }
}