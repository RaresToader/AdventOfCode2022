import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("in.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String l = br.readLine();
        br.close();
        int[][] g = new int[200][1000];
        int my = 0;
        String[] c = l.split(" -> ");
        for (int i = 0; i < c.length; i++) {
            int[] coordinates = Arrays.stream(c[i].split(",")).mapToInt(Integer::parseInt).toArray();
            int x = coordinates[0];
            int y = coordinates[1];
            int dx = coordinates[2];
            int dy = coordinates[3];
            g[y][x] = 1;
            while (x != dx || y != dy) {
                x += (x < dx) ? 1 : -1;
                y += (y < dy) ? 1 : -1;
                g[y][x] = 1;
            }
            my = Math.max(my, y);
            my = Math.max(my, dy);
        }
        for (int ix = 0; ix < g[0].length; ix++) {
            g[my + 2][ix] = 1;
        }
        int co = 0;
        while (g[0][500] == 0) {
            int x = 500;
            int y = 0;
            while (true) {
                if (g[y + 1][x] == 0) {
                } else if (g[y + 1][x - 1] == 0) {
                    x -= 1;
                } else if (g[y + 1][x + 1] == 0) {
                    x += 1;
                } else {
                    break;
                }
                y += 1;
            }

            co += 1;
            g[y][x] = 1;
            System.out.println(c);
        }
    }
}
