import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    private String name;
    private String address;
    private double unitsConsumed;

    public Customer(String name, String address, double unitsConsumed) {
        this.name = name;
        this.address = address;
        this.unitsConsumed = unitsConsumed;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getUnitsConsumed() {
        return unitsConsumed;
    }
}

class Bill {
    private Customer customer;
    private double totalAmount;

    public Bill(Customer customer, double totalAmount) {
        this.customer = customer;
        this.totalAmount = totalAmount;
    }

    public String generateBill() {
        return "Customer Name: " + customer.getName() +
                "\nAddress: " + customer.getAddress() +
                "\nUnits Consumed: " + customer.getUnitsConsumed() +
                "\nTotal Amount: $" + totalAmount;
    }
}

class BillingSystem {
    private ArrayList<Customer> customers;
    private ArrayList<Bill> bills;

    public BillingSystem() {
        customers = new ArrayList<>();
        bills = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void generateBills() {
        for (Customer customer : customers) {
            double unitsConsumed = customer.getUnitsConsumed();
            double totalAmount = unitsConsumed * 0.12; // Assuming unit price is $0.12
            Bill bill = new Bill(customer, totalAmount);
            bills.add(bill);
        }
    }

    public void displayBills() {
        for (Bill bill : bills) {
            System.out.println(bill.generateBill());
            System.out.println("-----------------------------");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BillingSystem billingSystem = new BillingSystem();

        // Adding sample customers
        billingSystem.addCustomer(new Customer("John Doe", "123 Main St", 150));
        billingSystem.addCustomer(new Customer("Jane Smith", "456 Oak Dr", 200));

        // Generate bills
        billingSystem.generateBills();

        // Display bills
        billingSystem.displayBills();
    }
}

