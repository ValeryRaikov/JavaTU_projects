import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Email {
    private String sender;
    private String subject;
    private String content;

    public Email(String sender, String subject, String content) {
        setSender(sender);
        setSubject(subject);
        setContent(content);
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(sender, email.sender) && Objects.equals(subject, email.subject) && Objects.equals(content, email.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender, subject, content);
    }

    @Override
    public String toString() {
        return "Email{" +
                "sender='" + sender + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

//    Method for saving emails to file
    public void appendToFile(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(getSender() + "#" + getSubject() + "#" + getContent() + "$");
        } catch (IOException e) {
            System.err.println("Error writing to file!");
            e.printStackTrace();
        }
    }

//    Method for loading emails from file
    public static List<Email> loadFromFile(String path) {
        List<Email> emails = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String[] allEmailsData = reader.readLine().split("\\$");

            for (String emailData: allEmailsData) {
                String[] currEmailData = emailData.split("#");

                String sender = currEmailData[0];
                String subject = currEmailData[1];
                String content = currEmailData[2];

                emails.add(new Email(sender, subject, content));
            }
        } catch (IOException e) {
            System.err.println("Error reading from file!");
            e.printStackTrace();
            return null;
        }

        return emails;
    }
}
