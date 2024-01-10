package RegexExam;

import java.io.Serializable;

public class Regex implements Serializable {
    private static int nextId = 0;
    private int id;
    private String pattern;
    private String description;
    private int rating;

    public Regex(String pattern, String description) {
        setPattern(pattern);
        setDescription(description);
        setRating(0);
        setId(nextId += 1);
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Regex.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %s, %d", getId(), getPattern(), getDescription(), getRating());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
