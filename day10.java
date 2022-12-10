import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new java.io.File("in.txt"));
        int currCycle = 1;
        long signalStrength = 0L;
        long register = 1L;
        /*
        20th cycle and every 40 cycles after that (that is, during the 20th, 60th, 100th, 140th, 180th, and 220th cycles).
         */
        while (sc.hasNextLine()) {
            String string = sc.nextLine();
            if(correct(currCycle)){
                signalStrength += currCycle * register;
            }
            if (string.startsWith("noop")) {
                currCycle++;
            } else {
                int aux = Integer.parseInt(string.split(" ")[1]);
                currCycle++;
                if (correct(currCycle)) {
                    signalStrength += currCycle * register;
                }
                currCycle++;
                register += aux;
            }
        }
        System.out.println(signalStrength);

    }

    public static boolean correct(int cycle) {
        return (cycle == 20) || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220;
    }
}