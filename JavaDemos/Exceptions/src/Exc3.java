public class Exc3 {
    public static void main(String[] args) {
        try
        {
            int[] intArr= {1,3,5,7, 9};
            System.out.println(intArr[10]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("rest of the code goes here");
    }
}

