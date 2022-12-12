import java.util.*;

public class Main {
    public static List<int[]> find(char[][] heightmap, char letter) {
        List<int[]> res = new ArrayList<>();
        int rows = heightmap.length;
        int cols = heightmap[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (heightmap[r][c] == letter) {
                    res.add(new int[]{r, c});
                }
            }
        }
        return res;
    }

    public static int height(int r, int c, char[][] heightmap) {
        if (heightmap[r][c] == 'S') {
            return 'a';
        }
        if (heightmap[r][c] == 'E') {
            return 'z';
        }
        return heightmap[r][c];
    }

    public static int fewestSteps(char[][] heightmap, int sr, int sc, int er, int ec) {
        int rows = heightmap.length;
        int cols = heightmap[0].length;
        int[][] steps = new int[rows][cols];
        for (int[] row : steps) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        steps[sr][sc] = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc});
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            for (int[] move : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                int nr = r + move[0];
                int nc = c + move[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && steps[nr][nc] == Integer.MAX_VALUE && height(nr, nc, heightmap) <= height(r, c, heightmap) + 1) {
                    steps[nr][nc] = steps[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return steps[er][ec];
    }

    public static void main(String[] args) {
        List<String> rows = new ArrayList<>();
        Scanner scanner = new Scanner("in.txt");
        while (scanner.hasNextLine()) {
            rows.add(scanner.nextLine());
        }
        char[][] heightmap = new char[rows.size()][rows.get(0).length()];
        for (int i = 0; i < rows.size(); i++) {
            heightmap[i] = rows.get(i).toCharArray();
        }
        List<int[]> startPos = find(heightmap, 'S');
        int[] start = startPos.get(0);
        int startr = start[0], startc = start[1];
        List<int[]> endPos = find(heightmap, 'E');
        int[] end = endPos.get(0);
        int endr = end[0], endc = end[1];
        int part1 = fewestSteps(heightmap, startr, startc, endr, endc);
        List<int[]> aPos = find(heightmap, 'a');
        int part2 = Integer.MAX_VALUE;
        for (int[] pos : aPos) {
            part2 = Math.min(part2, fewestSteps(heightmap, pos[0], pos[1], endr, endc));
        }
        System.out.println(String.format("Part 1: %d, Part 2: %d", part1, part2));
    }

}



