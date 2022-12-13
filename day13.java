import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.util.*;

public class Main {
    public static int f(Object a, Object b) {
        if (a instanceof Integer && b instanceof Integer) {
            return ((Integer) a).compareTo((Integer) b);
        }

        if (a instanceof Integer) {
            a = new Integer[]{(Integer) a};
        } else if (b instanceof Integer) {
            b = new Integer[]{(Integer) b};
        }

        Integer[] arr1 = (Integer[]) a;
        Integer[] arr2 = (Integer[]) b;

        for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
            int x = f(arr1[i], arr2[i]);
            if (x != 0) {
                return x;
            }
        }
        return Integer.compare(arr1.length, arr2.length);
    }
    public static void main(String[] args) {
        try {
            File file = new File("in.txt");
            Scanner scanner = new Scanner(file);
            List<String> lines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();

            List<Object> p = new ArrayList<>();
            p.add(new Integer[][] { { 2 } });
            p.add(new Integer[][] { { 6 } });

            for (int i = 0; i < lines.size(); i += 3) {
                p.add(eval(lines.get(i)));
                p.add(eval(lines.get(i + 1)));
            }

            int i = 0;
            while (i < p.size() - 1) {
                if (f(p.get(i), p.get(i + 1)) == 1) {
                    Collections.swap(p, i, i + 1);
                    i = Math.max(0, i - 1);
                } else {
                    i++;
                }
            }

            System.out.println((p.indexOf(new Integer[][] { { 2 } }) + 1) * (p.indexOf(new Integer[][] { { 6 } }) + 1));
        } catch (FileNotFoundException | ScriptException e) {
            e.printStackTrace();
        }
    }
    public static Object eval(String expression) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("python");
        return engine.eval(expression);
    }


}
