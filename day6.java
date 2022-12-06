import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("in.txt"));

        int current = 14;
        while (sc.hasNextLine()) {
            String helper = sc.nextLine();
            String substring;
            for (int i = 0; i < helper.length() - 13; i++) {
                substring = helper.substring(i, i + 14);
                System.out.println(substring);
                if(isDiff(substring.toCharArray())){
                    break;
                }
                else {
                    current = current + 1;
                }
            }
        }
        System.out.println(current);
    }

    public static boolean isDiff(char[] arr) {
        Set<Character> set = new HashSet<>();
        for(Character x : arr){
            set.add(x);
        }
        return set.size() == arr.length;
    }

}

