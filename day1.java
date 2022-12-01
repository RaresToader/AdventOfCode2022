import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello world!");
        Scanner sc = new Scanner(new File("in.txt"));
        int current = 0;
        List<Integer> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String aux = sc.nextLine();
            if (aux.length() == 0) {
                list.add(current);
                current = 0;
            } else {
                current += Integer.parseInt(aux);
            }
        }
        list.sort(Comparator.comparingInt(x -> x));
        System.out.println(list.get(list.size() -1) +list.get(list.size() -2)+list.get(list.size() -3));
    }
}
