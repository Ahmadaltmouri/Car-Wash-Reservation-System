package DB;


public class Booking {
    private String customerName;
    private String phone;
    private String serviceType;
    private String carType;
    private String time;

    public Booking(String customerName, String phone, String serviceType, String carType, String time) {
        this.customerName = customerName;
        this.phone = phone;
        this.serviceType = serviceType;
        this.carType = carType;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void printBookingDetails() {
        System.out.println("\n----- Booking Details -----");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Phone: " + phone);
        System.out.println("Service: " + serviceType);
        System.out.println("Car Type: " + carType);
        System.out.println("Time: " + time);
        System.out.println("----------------------------\n");
    }
}
