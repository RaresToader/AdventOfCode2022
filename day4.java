import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("in.txt"));
        int current = 0;
        while (sc.hasNextLine()) {
            String aux = sc.next();
            String[] split = aux.split(",");
            String[] first = split[0].split("-");
            int a = Integer.parseInt(first[0]);
            int b = Integer.parseInt(first[1]);
            first = split[1].split("-");
            int c = Integer.parseInt(first[0]);
            int d = Integer.parseInt(first[1]);
            // a ... a+1 ... b
            // c ... c+1 ... d
           Set<Integer> f =  create(a,b);
           Set<Integer> s = create(c,d);
           for(int i : f){
               if(s.contains(i)){
                   current++;
                   break;
               }
           }

            } //528
        System.out.println(current);
        }


    public static Set<Integer> create(int left, int right) {
        int size = right - left + 1;
        int[] arr = new int[size];
        Set<Integer> s = new HashSet<>();
        for(int i = left; i<= right; i++){
            s.add(i);
        }
        return s;
}
}
