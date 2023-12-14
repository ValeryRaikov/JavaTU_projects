public class Regex {
    private int id;
    private String pattern;
    private String description;
    private int rating;
    private static int nextId = 0;

    public Regex(String pattern, String description){
        this.pattern = pattern;
        this.description = description;
        this.rating = 0;
        nextId += 1;
        this.id = nextId;
    }
    public int getId () {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPattern() {
        return this.pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating () {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Regex.nextId = nextId;
    }

    @Override
    public String toString() {
        return id + ", " + pattern + ", " + description + ", " + rating;
    }
}