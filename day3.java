import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("in.txt"));
        int current = 0;
        while (sc.hasNextLine()) {
            String aux = sc.next();
            String aux2 = sc.next();
            String aux3 = sc.next();
            int left = aux.length()/2;

            Set<Character> set1 = new HashSet<>();
            Set<Character> set2 = new HashSet<>();
            Character helper = '-';
            for(int i = 0; i < aux.length(); i++){
                if(aux2.contains(Character.toString(aux.charAt(i))) && aux3.contains(Character.toString(aux.charAt(i)))){
                    helper = aux.charAt(i);
                }
            }

            if(Character.isUpperCase(helper)){
                current += helper - 38;
            }
            else{
                current += helper - 96;
            }
        }
        System.out.println(current);
    }
}
