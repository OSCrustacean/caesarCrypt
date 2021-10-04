import java.util.ArrayList;

public class Fibonacci {
    private ArrayList<Integer> sequence = new ArrayList<Integer>();
    public int n = 0;
    public Fibonacci() {
        sequence.add(0);
        sequence.add(1);
    }
    
    public void fib(int num) {
        for(int i=0; i < num; i++) {
            n=2+i;
            sequence.add(sequence.get(n-1)+sequence.get(n-2));
        }
    }

    public String toString() {
        String statement = "";
        for(int i = 0; i < sequence.size(); i++){
            statement += sequence.get(i) + ", ";
        }
        return statement + "...";
    }
}
