import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Application implements IApplication {
    private List<Record> records = new ArrayList<>();

    public static void main(String... args) {
        Application application = new Application();
        application.execute();
    }

    public List<Record> loadRecords() {
        List<Record> records = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Configuration.instance.dataPath + "records.csv"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] entries = line.split(";");
                int id = Integer.parseInt(entries[0]);
                int waitingTimeInMinutes = Integer.parseInt(entries[1]);
                int serviceDesk = Integer.parseInt(entries[2]);
                int source = Integer.parseInt(entries[3]);
                String dayOfWeek = entries[4];
                String destination = entries[5];
                String type = entries[6];
                int price = Integer.parseInt(entries[7]);
                Ticket ticket = new Ticket(destination, type, price);
                String premiumService = entries[8];
                records.add(new Record(id, waitingTimeInMinutes, serviceDesk, source, dayOfWeek, ticket, premiumService));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return records;
    }

    // count
    public void executeSQL01() {
        long solution = records.stream().count();
        System.out.println("1: " + solution);
    }

    // count, where
    public void executeSQL02() {
        long solution = records.stream()
                .filter(x -> x.getServiceDesk() == 8)
                .filter(x -> x.getTicket().getType().equals("w"))
                .count();
        System.out.println("2: " + solution);
    }

    public void execute() {
        records = loadRecords();
        executeSQL01();
        executeSQL02();
    }
}