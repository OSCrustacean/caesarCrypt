import java.util.ArrayList;
import java.math.BigInteger;

public class Fibonacci {
    //INIT ARRAYLIST OF TYPE BIGINTEGER TO CREATE FIBONACCI NUMBERS
    private ArrayList<BigInteger> sequence = new ArrayList<BigInteger>();
    public int n = 0;
    public Fibonacci() {
        sequence.add(BigInteger.valueOf(0));
        sequence.add(BigInteger.valueOf(1));
    }
    
    public char shift(char character, int i, int mods, int base) {
        return (char) (((sequence.get(i).mod(BigInteger.valueOf(mods)).intValue() + ((int) character % base))%mods)+base);
    }

    //BUILD FIBONACCI NUMBERS TO PROPER LENGTH FOR ENTERED PHRASE
    public String fibShift(String str, int offset) {
        String shift = "";
        for(int i=0; i < (str.length() + offset); i++) {
            n=1+i;
            sequence.add(sequence.get(n-1).add(sequence.get(n))); //add previous 2 fib nums and add to end of sequence
        }
        for(int i=0; i < offset; i++) { //remove beginning fib numbers to account for offset
            sequence.remove(0);
        }

        for(int i=0; i < str.length(); i++) {
            char character = str.charAt(i);
            char shiftedChar;
            if(Character.isLetter(character)) {
                if(Character.isUpperCase(character)) {
                    shiftedChar = shift(character, i, 26, (int) 'A');
                }
                else {
                    shiftedChar = shift(character, i, 26, (int) 'a');
                }
            }
            else if (Character.isDigit(character)) {
                shiftedChar = shift(character, i, 10, (int) '0'); 
            }
            else {
                shiftedChar = shift(character, i, 15, (int) '!');
            }
            shift += shiftedChar;
        }
        return shift;
    }

    public String toString() {
        String statement = "";
        for(int i = 0; i < sequence.size(); i++){
            statement += sequence.get(i) + ", ";
        }
        return statement + "...";
    }
}
