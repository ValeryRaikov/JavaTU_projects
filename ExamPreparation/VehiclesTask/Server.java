package VehiclesTask;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Server {
    private static final String VEHICLE_FILENAME = "vehicles_info.bin";
    private final Object vehiclesLock;
    private ServerSocket server;

    public Server() {
        vehiclesLock = new Object();
    }

    public void start() {
        try {
            System.out.println("Server awaiting connection...");
            server = new ServerSocket(8080);

            while (true) {
                Socket client = server.accept();

                Thread clientThread = new Thread(() -> {
                    System.out.println("Accepted client.");
                    Scanner in = null;
                    PrintStream out = null;

                    try {
                        in = new Scanner(client.getInputStream());
                        out = new PrintStream(client.getOutputStream());
                        menu(in, out);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Vehicle> loadVehicles() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(VEHICLE_FILENAME))) {
            return (List<Vehicle>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        If failed to read vehicles
        return null;
    }

    public void saveVehicles(List<Vehicle> vehicles) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(VEHICLE_FILENAME))) {
            oos.writeObject(vehicles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void menu(Scanner in, PrintStream out) {
        synchronized (vehiclesLock) {
            while (true) {
                out.println("Vehicle system menu:\n" +
                        "1 - Register vehicle\n" +
                        "2 - Remove vehicle\n" +
                        "3 - Search for vehicle\n" +
                        "4 - Display sorted vehicles\n" +
                        "(Other) - QUIT!"
                );

                int choice = Integer.parseInt(in.nextLine());

                switch (choice) {
                    case 1:
                        registerVehicle(in, out);
                        break;
                    case 2:
                        removeVehicle(in, out);
                        break;
                    case 3:
                        searchVehicle(in, out);
                        break;
                    case 4:
                        displaySortedVehicles(in, out);
                        break;
                    default:
                        out.println("Invalid choice!");
                        return;
                }
            }
        }
    }

    public Vehicle commonCreation(Scanner in, PrintStream out) {
        synchronized (vehiclesLock) {
            out.println("Enter vehicle type to register:");
            VehicleType vehicleType = VehicleType.valueOf(in.nextLine().toUpperCase());
            Vehicle vehicle = VehicleFactory.createVehicle(in, out, vehicleType);

            if (vehicle == null) {
                out.println("Failed to create vehicle!");
                return null;
            }

            return vehicle;
        }
    }

    public void registerVehicle(Scanner in, PrintStream out) {
        synchronized (vehiclesLock) {
            Vehicle vehicle = commonCreation(in, out);

            List<Vehicle> vehicles = loadVehicles();

            if (vehicles.isEmpty()) {
                vehicles.add(vehicle);
                saveVehicles(vehicles);
            }

//        for (Vehicle currVehicle: vehicles) {
//            if (currVehicle.getBrand().equals(vehicle.getBrand()) &&
//                currVehicle.getModel().equals(vehicle.getModel()) &&
//                currVehicle.getYear() == vehicle.getYear()) {
//                out.println("This vehicle is already in the file!");
//                return;
//            }
//        }

            if (vehicles.contains(vehicle)) {
                out.println("This vehicle is already in the file!");
                return;
            }

            vehicles.add(vehicle);
            saveVehicles(vehicles);
        }
    }

    public void removeVehicle(Scanner in, PrintStream out) {
        synchronized (vehiclesLock) {
            Vehicle vehicle = commonCreation(in, out);

            List<Vehicle> vehicles = loadVehicles();

            if (!vehicles.contains(vehicle)) {
                out.println("No such vehicle found!");
                return;
            }

            vehicles.remove(vehicle);
            saveVehicles(vehicles);
        }
    }

    public void searchVehicle(Scanner in, PrintStream out) {
        synchronized (vehiclesLock) {
            Vehicle vehicle = commonCreation(in, out);

            List<Vehicle> vehicles = loadVehicles();

            if (vehicles.contains(vehicle))
                out.println("Found vehicle" + vehicle);
            else
                out.println("No such vehicle!");
        }
    }

    public void displaySortedVehicles(Scanner in, PrintStream out) {
        synchronized (vehiclesLock) {
            out.println("How do you want to sort the vehicles\n:" +
                    "1 - Sort by year & name\n" +
                    "2 - Sort by brand & model"
            );

            int choice1 = Integer.parseInt(in.nextLine());

            out.println("What type of sorting to apply: ASC | DESC");

            String choice2 = in.nextLine();

            List<Vehicle> sortedVehicles = null;

            switch (choice1) {
                case 1:
                    sortedVehicles = loadVehicles().stream().sorted(
                            Comparator.comparingInt(Vehicle::getYear).thenComparing(Vehicle::getBrand)
                    ).toList();
                    break;
                case 2:
                    sortedVehicles = loadVehicles().stream().sorted(
                            Comparator.comparing(Vehicle::getBrand).thenComparing(Vehicle::getModel)
                    ).toList();
                    break;
                default:
                    out.println("Invalid sorting chosen!");
                    return;
            }

            if (choice2.equalsIgnoreCase("ASC"))
                out.println("Ascending vehicles: " + sortedVehicles);
            else if (choice2.equalsIgnoreCase("DESC"))
                out.println("Descending vehicles: " + sortedVehicles.reversed());
            else
                out.println("No sorting selected!");
        }
    }
}
