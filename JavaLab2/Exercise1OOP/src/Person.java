public class Person {
    private String name;
    private String egn;

    public Person() {
        this.name = "";
        this.egn = "";
    }

    public Person(String name, String egn) {
        this.name = name;
        this.egn = egn;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void testingMethod() {
        System.out.println("Test");
    }

    public void sayHi() {
        System.out.println("Hi, my name is " + this.getName());
    }

}
