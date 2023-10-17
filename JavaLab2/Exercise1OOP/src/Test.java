public class Test {
    public static void main(String[] args) {

        Person p1 = new Person();
        Person p2 = new Person("Ivan Petrov", "0021233");
        System.out.println(p2.getName());

        Person.testingMethod();
        p2.sayHi();

        Student s1 = new Student("Ivan Ivanov", "0341087221", "121222010");
        System.out.println(s1.getName());

        Course c1 = new Course("Mathematics");
        Teacher t1 = new Teacher("Mihail Marinov", "98457465", c1);

        // Modify course name
        c1.setCourseName("Electronics");
        System.out.println(c1.getCourseName());

        Course c2 = new Course("Informatics");
        Teacher t2 = new Teacher("Nikola Krasimirov", "78659524", c2);

        Course c3 = new Course("PPE");
        Teacher t3 = new Teacher("Dimitar Peshov", "85461310", c3);

        Teacher[] arr = new Teacher[3];
        arr[0] = t1;
        arr[1] = t2;
        arr[2] = t3;
        for (Teacher t: arr){
            System.out.println(t.getCourse());
        }
    }
}