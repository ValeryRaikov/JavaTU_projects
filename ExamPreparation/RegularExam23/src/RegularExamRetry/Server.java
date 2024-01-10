package RegularExamRetry;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Server {
    private static final String USERS_FILENAME = "users.bin";
    private final Object usersLock;
    private ServerSocket server;

    public Server() {
        try {
            initAdmins();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        usersLock = new Object();
    }

    public void initAdmins() throws IOException {
        File file = new File(USERS_FILENAME);

        if (!file.exists()) {
            boolean isCreated = file.createNewFile();

            if (!isCreated) {
                throw new IOException("Error creating file!");
            }
        } else {
            return;
        }

        List<User> users = new ArrayList<>();
        users.add(new Admin("Admin", "Admin"));

        //saveUsers(users);
    }

    public void start() {
        try {
            System.out.println("Server listening.");
            server = new ServerSocket(8080);

            while (true) {
                Socket client = server.accept();

                Thread clientThread = new Thread(() -> {
                    System.out.println("Accepted client.");
                    Scanner sc = null;
                    PrintStream out = null;

                    try {
                        sc = new Scanner(client.getInputStream());
                        out = new PrintStream(client.getOutputStream());
                        //userMenu(sc, out);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        if (sc != null)
                            sc.close();
                        if (out != null)
                            out.close();
                    }
                });

                clientThread.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<User> readUsersFromFile() throws IOException{
        List<User> users = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERS_FILENAME))) {
            while (true) {
                User currUser = (User) ois.readObject();

                if (currUser == null)
                    break;

                users.add(currUser);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return users;
    }

    public void writeUsersToFile(List<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILENAME))) {
            for (User user: users) {
                oos.writeObject(user);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void registerUser(String username, String password, UserType userType) throws CredentialsException {
        User user = UserFactory.createUser(username, password, userType);

        synchronized (usersLock) {
            try {
                List<User> users = readUsersFromFile();
                users.add(user);
                writeUsersToFile(users);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private User login(String username, String password) throws IOException{
        List<User> users = readUsersFromFile();

        synchronized (usersLock) {
            for (User user: users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return user;
                }
            }

            System.out.println("No user with the given credentials found!");
            return null;
        }
    }

    private void userMenu(Scanner in, PrintStream out) throws IOException {
        while (true) {
            out.println("Login?Y/N");

            String command = in.nextLine();
            if (command.equalsIgnoreCase("N")) {
                out.println("Exiting the system! Goodbye.");
                return;
            } else {
                out.println("Enter username:");
                String username = in.nextLine();

                out.println("Enter password:");
                String password = in.nextLine();

                User user = login(username, password);

                if (user == null) {
                    out.println("Invalid user! Try again:");
                    continue;
                }

                switch (user.getUserType()) {
                    case ADMIN:
                        //TODO
                    case STUDENT:
                        //TODO
                    case TEACHER:
                        //TODO
                }
            }
        }
    }

    public void adminMenu(Scanner in, PrintStream out) throws CredentialsException{
        out.println("Logged in as Admin.");

        out.println("Enter user type to create... (ADMIN/STUDENT/TEACHER)");
        String command = in.nextLine();

        try {
            UserType userType = UserType.valueOf(command.toUpperCase());

            out.println("Enter username:");
            String username = in.nextLine();

            out.println("Enter password:");
            String password = in.nextLine();

            registerUser(username, password, userType);

            out.println("Success.");
        } catch (IllegalArgumentException e) {
            out.println("Error! Invalid user type.");
        }
    }

    public void studentMenu(Scanner in, PrintStream out, Student student) {
        out.println("Logged in as Student.");

        List<Grade> sortedGrades = student.getGrades()
                .stream()
                .sorted(Comparator.comparingInt(Grade::getSemesterNumber).thenComparing(Grade::getSubject))
                .collect(Collectors.toList());

        out.println(sortedGrades);
    }

    public void teacherMenu(Scanner in, PrintStream out, Teacher teacher) throws IOException {
        out.println("Logged in as Teacher.");

        out.println("Enter student faculty number:");
        String facultyNumber = in.nextLine();

        out.println("Enter subject:");
        String subject = in.nextLine();

        out.println("Enter semester:");
        int semester = Integer.parseInt(in.nextLine());

        out.println("Enter grade:");
        int gradeValue = Integer.parseInt(in.nextLine());

        Grade grade = new Grade(subject, semester, gradeValue);

        synchronized (usersLock) {
            List<User> users = readUsersFromFile();
            for (User user : users)
            {
                if (user.getUsername().equals(facultyNumber) && user instanceof Student)
                {
                    Student student = (Student) user;

                    student.getGrades().add(grade);

                    writeUsersToFile(users);

                    out.println("Success.");
                    return;
                }
            }

            out.println("No such student.");
        }
    }
}
