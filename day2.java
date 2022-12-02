import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("in.txt"));
        int current = 0;
        List<Integer> list = new ArrayList<>();
        Map<Character,Integer> s = new HashMap<>();
        s.put('X', 0);
        s.put('Y', 3);
        s.put('Z', 6);
        s.put('A', 1); // rock
        s.put('B', 2); // paper
        s.put('C', 3); // scissors

        //1 for Rock, 2 for Paper, and 3 for Scissors
        while (sc.hasNextLine()) {
            String aux = sc.nextLine();
            char h = aux.charAt(0);
            char b = aux.charAt(2);
            if(b == 'Y'){
                current += s.get(h); // choose same
            }
            else if(b =='X'){
                char selected;
                if(h =='A'){
                    selected = 'C';
                }
                else if(h == 'B'){
                    selected = 'A';
                }
                else{
                    selected ='B';
                }
                current+= s.get(selected);
            }
            else{
                char sel;
                if(h =='A'){
                    sel = 'B';
                }
                else if(h =='B'){
                    sel = 'C';
                }
                else {
                    sel = 'A';
                }
                current+= s.get(sel);
            }
            current += s.get(b);

        }
        System.out.println(current);
    }
}
