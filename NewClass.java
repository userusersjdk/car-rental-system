//CAR CLASS//
public class Car {
    private String make;
    private String model;
    private int year;
    private double dailyPrice;
    private boolean available;

    public Car(String make, String model, int year, double dailyPrice) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.dailyPrice = dailyPrice;
        this.available = true;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

//CUSTOMER CLASS//

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String licenseNumber;
    private List<Car> rentedCars;

    public Customer(String name, String licenseNumber) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.rentedCars = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public List<Car> getRentedCars() {
        return rentedCars;
    }

    public void rentCar(Car car) {
        rentedCars.add(car);
    }

    public void returnCar(Car car) {
        rentedCars.remove(car);
    }
}

//RENTAL AGENCY CLASS//

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<Car> cars;
    private List<Customer> customers;

    public RentalAgency() {
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void rentCar(Customer customer, Car car) {
        if (car.isAvailable()) {
            customer.rentCar(car);
            car.setAvailable(false);
        } else {
            System.out.println("Car is not available for rent.");
        }
    }

    public void returnCar(Customer customer, Car car) {
        if (customer.getRentedCars().contains(car)) {
            customer.returnCar(car);
            car.setAvailable(true);
        } else {
            System.out.println("Customer did not rent this car.");
        }
    }
}

//TEST CLASS/

public class CarRentalSystemTest {
    public static void main(String[] args) {
        // Test the car rental system

        // Create cars
        Car car1 = new Car("Toyota", "Camry", 2019, 50.0);
        Car car2 = new Car("Honda", "Civic", 2020, 60.0);

        // Create customers
        Customer customer1 = new Customer("John", "ABC123");
        Customer customer2 = new Customer("Alice", "XYZ456");

        // Create rental agency
        RentalAgency rentalAgency = new RentalAgency();
        rentalAgency.addCar(car1);
        rentalAgency.addCar(car2);
        rentalAgency.addCustomer(customer1);
        rentalAgency.addCustomer(customer2);

        // Rent a car
        rentalAgency.rentCar(customer1, car1);

        // Try to rent a car that's already rented
        rentalAgency.rentCar(customer2, car1);

        // Return a car
        rentalAgency.returnCar(customer1, car1);

        // Try to return a car that wasn't rented by the customer
        rentalAgency.returnCar(customer1, car2);
    }
}
