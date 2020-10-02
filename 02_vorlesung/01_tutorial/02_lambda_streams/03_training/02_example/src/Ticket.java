public class Ticket {
    private final String destination;
    private final String type;
    private final int price;

    public Ticket(String destination, String type, int price) {
        this.destination = destination;
        this.type = type;
        this.price = price;
    }

    public String getDestination() {
        return destination;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ Ticket : ").append("destination = ").append(destination);
        return stringBuilder.toString();
    }
}