import java.util.ArrayList;


public class Calendar {
    private ArrayList<CalendarItem> itemList = new ArrayList<CalendarItem>();

    public Calendar(ArrayList<CalendarItem> itemList) {
        this.itemList = itemList;
    }

    public ArrayList<CalendarItem> getItemList() {
        return this.itemList;
    }

    public void addEvent(String itemName, String itemDate, String locationName) {
        itemList.add(new Event(itemName, itemDate, locationName));
    }

    public void addReminder(String itemName, String itemDate, String reminderTime) {
        itemList.add(new Reminder(itemName, itemDate, reminderTime));
    }

    public void deleteItem(int index) {
        itemList.remove(index);
    }

    public void showItems() {
        for (CalendarItem item : itemList) {
            System.out.println(item.toString() + "\n");
        }
    }
}
