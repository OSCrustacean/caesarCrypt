import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter phrase: ");
        String str = sc.nextLine();
        
        System.out.print("Enter offset: ");
        int offset = sc.nextInt();
        
        Fibonacci f = new Fibonacci();
        System.out.println(f.fibShift(str, offset));
        
        sc.close();
    }
}
