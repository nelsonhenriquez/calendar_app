import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int menuChoice;
        boolean running = true;

        Calendar calendar = new Calendar(readFromFile());


        while (running) {
            System.out.println("Welcome to Calendar App\n\n" +
                "1. Show All Items\n" +
                "2. Add New Item\n" +
                "3. Delete Item\n" +
                "4. Quit and Write Items to .txt file\n");

            //add numberformatexception catch later
            menuChoice = Integer.parseInt(sc.nextLine());

            switch (menuChoice) {
                case 1:
                    calendar.showItems();
                    break;
                case 4:
                    running = false;
                    ArrayList<String> itemStrings = new ArrayList<String>();

                    for (CalendarItem item : calendar.getItemList()) {
                        if (item instanceof Event) {
                            itemStrings.add("Event," + item.getItemName() + "," + item.getItemDate() + "," + ((Event) item).getLocationName() + "\n");
                        }
                        if (item instanceof Reminder) {
                            itemStrings.add("Reminder," + item.getItemName() + "," + item.getItemDate() + "," + ((Reminder) item).getReminderTime() + "\n");
                        }
                    }

                    writeToFile(itemStrings);
                    break;
                case 3:
                    int i = 1;
                    System.out.println("Enter the item you want to delete: \n");
                    for (CalendarItem item : calendar.getItemList()) {
                        System.out.println(i + ". " + item.getItemName() + "\n");
                        i++;
                    }
                    int delChoice = Integer.parseInt(sc.nextLine());

                    calendar.deleteItem(delChoice - 1);
                    break;


                case 2:
                    System.out.println("Which Item Type?\n\n" +
                            "1. Event\n" +
                            "2. Reminder\n");


                    int subMenuChoice = Integer.parseInt(sc.nextLine());


                    switch (subMenuChoice) {
                        case 1:
                            System.out.println("Enter Event Name\n");
                            String eventName = sc.nextLine();
                            System.out.println("Enter Event Date\n");
                            String eventDate = sc.nextLine();
                            System.out.println("Enter Event Location\n");
                            String eventLocation = sc.nextLine();

                            calendar.addEvent(eventName, eventDate, eventLocation);
                            break;

                        case 2:
                            System.out.println("Enter Reminder Name\n");
                            String reminderName = sc.nextLine();
                            System.out.println("Enter Reminder Date\n");
                            String reminderDate = sc.nextLine();
                            System.out.println("Enter Reminder Time\n");
                            String reminderTime = sc.nextLine();

                            calendar.addReminder(reminderName, reminderDate, reminderTime);
                            break;
                    }

            }
        }

    }

    public static ArrayList<CalendarItem> readFromFile() {
        BufferedReader reader = null;
        ArrayList<CalendarItem> temp = new ArrayList<CalendarItem>();

        try {
            reader = new BufferedReader(new FileReader("output.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.split(",")[0].equals("Reminder")) {
                    temp.add(new Reminder(line.split(",")[1], line.split(",")[2], line.split(",")[3]));
                }
                if (line.split(",")[0].equals("Event")) {
                    temp.add(new Event(line.split(",")[1], line.split(",")[2], line.split(",")[3]));
                }

            }
        }
        catch (FileNotFoundException e) {
            System.out.println("No file detected...");
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return temp;
        }
    }

    public static void writeToFile(ArrayList<String> itemStrings) {
        BufferedWriter writer = null;

        try {
            // Create a BufferedWriter object with FileWriter
            writer = new BufferedWriter(new FileWriter("output.txt"));

            for (String s : itemStrings) {
                writer.write(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the BufferedWriter
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}