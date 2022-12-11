import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new java.io.File("in.txt"));
        List<Monkey> monkeys = new ArrayList<>();
        Monkey basic = new Monkey();
        for (int i = 0; i < 3; i++) {
            monkeys.add(basic);
        }

        while (sc.hasNextLine()) {
            String string = sc.nextLine();
            Scanner helper = new Scanner(string);
            helper.next();
            String ind = helper.next().split(":")[0];
            int monkeyIndex = Integer.parseInt(ind);
            string = sc.nextLine();
            helper = new Scanner(string);
            helper.next();
            helper.next();
            while (helper.hasNext()) {
                String another = helper.next().split(",")[0];
                monkeys.get(monkeyIndex).items.add(Integer.parseInt(another));
            }

            string = sc.nextLine();
            helper = new Scanner(string);
            if (string.contains("+")) {
                monkeys.get(monkeyIndex).isAddition = true;
            } else {
                monkeys.get(monkeyIndex).isAddition = false;
            }
            helper.next();
            helper.next();
            helper.next();
            helper.next();
            helper.next();
            monkeys.get(monkeyIndex).amount = Integer.parseInt(helper.next());

            string = sc.nextLine();
            helper = new Scanner(string);
            helper.next();
            helper.next();
            helper.next();
            monkeys.get(monkeyIndex).divBy = Integer.parseInt(helper.next());

            string = sc.nextLine();
            helper = new Scanner(string);
            helper.next();
            helper.next();
            helper.next();
            helper.next();
            helper.next();
            monkeys.get(monkeyIndex).ifTrue = Integer.parseInt(helper.next());

            string = sc.nextLine();
            helper = new Scanner(string);
            helper.next();
            helper.next();
            helper.next();
            helper.next();
            helper.next();
            monkeys.get(monkeyIndex).ifFalse = Integer.parseInt(helper.next());

            if (sc.hasNextLine()) {
                sc.nextLine();
            }
        }

    }

    static class Monkey {
        List<Integer> items;
        int divBy;
        int ifTrue;
        int ifFalse;
        boolean isAddition;
        int amount;

        public Monkey() {
            this.items = new ArrayList<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Monkey monkey)) return false;
            return divBy == monkey.divBy && ifTrue == monkey.ifTrue && ifFalse == monkey.ifFalse && isAddition == monkey.isAddition && amount == monkey.amount && Objects.equals(items, monkey.items);
        }

        @Override
        public int hashCode() {
            return Objects.hash(items, divBy, ifTrue, ifFalse, isAddition, amount);
        }
    }
}