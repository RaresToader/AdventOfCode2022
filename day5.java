import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Stack<Character>[] stacks = new Stack[9];
        for (int i = 0; i < 9; i++) {
            stacks[i] = new Stack<>();
        }
        stacks[0].push('Q');
        stacks[0].push('W');
        stacks[0].push('P');
        stacks[0].push('S');
        stacks[0].push('Z');
        stacks[0].push('R');
        stacks[0].push('H');
        stacks[0].push('D');

        stacks[1].push('V');
        stacks[1].push('B');
        stacks[1].push('R');
        stacks[1].push('W');
        stacks[1].push('Q');
        stacks[1].push('H');
        stacks[1].push('F');

        stacks[2].push('C');
        stacks[2].push('V');
        stacks[2].push('S');
        stacks[2].push('H');

        stacks[3].push('H');
        stacks[3].push('F');
        stacks[3].push('G');

        stacks[4].push('P');
        stacks[4].push('G');
        stacks[4].push('J');
        stacks[4].push('B');
        stacks[4].push('Z');

        stacks[5].push('Q');
        stacks[5].push('T');
        stacks[5].push('J');
        stacks[5].push('H');
        stacks[5].push('W');
        stacks[5].push('F');
        stacks[5].push('L');

        stacks[6].push('Z');
        stacks[6].push('T');
        stacks[6].push('W');
        stacks[6].push('D');
        stacks[6].push('L');
        stacks[6].push('V');
        stacks[6].push('J');
        stacks[6].push('N');

        stacks[7].push('D');
        stacks[7].push('T');
        stacks[7].push('Z');
        stacks[7].push('C');
        stacks[7].push('J');
        stacks[7].push('G');
        stacks[7].push('H');
        stacks[7].push('F');

        stacks[8].push('W');
        stacks[8].push('P');
        stacks[8].push('V');
        stacks[8].push('M');
        stacks[8].push('B');
        stacks[8].push('H');
        Scanner sc = new Scanner(new File("in.txt"));
        int current = 0;
        while (sc.hasNextLine()) {
            String aux = sc.nextLine();
            //move 1 from 3 to 9
            Scanner helper = new Scanner(aux);
            helper.next();
            int amount = Integer.parseInt(helper.next());
            helper.next();
            int from = Integer.parseInt(helper.next()) - 1;
            helper.next();
            int to = Integer.parseInt(helper.next()) - 1;
            Stack<Character> helperStack = new Stack<>();
            while (amount > 0 && !stacks[from].isEmpty()) {
                helperStack.push(stacks[from].pop());
                amount--;
            }
            while (!helperStack.isEmpty()) {
                stacks[to].push(helperStack.pop());
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!stacks[i].isEmpty())
                System.out.print(stacks[i].peek());
        }
        System.out.println(current);
    }
}
