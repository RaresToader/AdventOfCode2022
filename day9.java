import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new java.io.File("in.txt"));
        List<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            list.add(sc.nextLine());
        }
        System.out.println(part2(list));

    }

    static class position {
        int x;

        public position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof position position)) return false;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public position add(int x, int y) {
            this.x += x;
            this.y += y;
            return this;
        }
    }


    public static long part1(final Collection<String> values) {
        position currentH = new position(0, 0);
        position currentT = new position(0, 0);

        Set<position> visitedByTail = new LinkedHashSet<>();
        visitedByTail.add(currentT);

        for (final String value : values) {
            final String[] tokens = value.split("\\s+");
            final String dir = tokens[0];
            final int num = Integer.parseInt(tokens[1]);
            for (int i = 0; i < num; i++) {
                currentH = getPosition(currentH, dir);

                currentT = getPosition2(currentH, currentT);
                visitedByTail.add(currentT);
            }
        }
        //visitedByTail.forEach(System.out::println);
        return visitedByTail.size();
    }

    private static position getPosition2(position currentH, position currentT) {
        if (areTouching(currentH, currentT)) {

            if (currentH.x == currentT.x) {
                if (currentH.y > currentT.y) {
                    currentT = new position(currentT.x, currentT.y + 1);
                } else {
                    currentT = new position(currentT.x, currentT.y - 1);
                }
            } else if (currentH.y == currentT.y) {
                if (currentH.x > currentT.x) {
                    currentT = new position(currentT.x + 1, currentT.y);
                } else {
                    currentT = new position(currentT.x - 1, currentT.y);
                }
            } else {
                if (currentH.x < currentT.x && currentH.y > currentT.y) {
                    // move down-right
                    currentT = new position(currentT.x - 1, currentT.y + 1);
                } else if (currentH.x < currentT.x) {
                    // move down-left
                    currentT = new position(currentT.x - 1, currentT.y - 1);
                } else if (currentH.y > currentT.y) {
                    // move up-right
                    currentT = new position(currentT.x + 1, currentT.y + 1);
                } else {
                    // move up-left
                    currentT = new position(currentT.x + 1, currentT.y - 1);
                }
            }

        }
        return currentT;
    }

    private static position getPosition(position currentH, String dir) {
        switch (dir) {
            case "U" -> currentH = new position(currentH.x + 1, currentH.y);
            case "D" -> currentH = new position(currentH.x - 1, currentH.y);
            case "L" -> currentH = new position(currentH.x, currentH.y - 1);
            case "R" -> currentH = new position(currentH.x, currentH.y + 1);
        }
        return currentH;
    }


    public static boolean areTouching(final position h, final position t) {
        final Set<position> n = getNeighbours(h.x, h.y);
        n.add(h);
        return !n.contains(t);
    }

    private static Set<position> getNeighbours(final int row, final int column) {
        final Set<position> neighbours = new HashSet<>();
        neighbours.add(new position(next(row), column));
        neighbours.add(new position(previous(row), column));
        neighbours.add(new position(row, next(column)));
        neighbours.add(new position(row, previous(column)));
        neighbours.add(new position(next(row), next(column)));
        neighbours.add(new position(previous(row), previous(column)));
        neighbours.add(new position(next(row), previous(column)));
        neighbours.add(new position(previous(row), next(column)));
        // Remove current position, in case it was added in above calculations
        neighbours.remove(new position(row, column));
        return neighbours;
    }

    public static int next(final int rowOrColumn) {
        return rowOrColumn + 1;
    }

    private static int previous(final int rowOrColumn) {
        return rowOrColumn - 1;
    }


    public static long part2(final Collection<String> values) {
        position currentH = new position(0, 0);

        final position[]
                tails = {
                new position(0, 0),
                new position(0, 0),
                new position(0, 0),
                new position(0, 0),
                new position(0, 0),
                new position(0, 0),
                new position(0, 0),
                new position(0, 0),
                new position(0, 0)
        };

        Set<position> visitedByTail = new LinkedHashSet<>();
        visitedByTail.add(tails[tails.length - 1]);

        for (final String value : values) {
            final String[] tokens = value.split("\\s+");
            final String dir = tokens[0];
            final int num = Integer.parseInt(tokens[1]);


            for (int i = 0; i < num; i++) {
                currentH = getPosition(currentH, dir);

                for (int tail = 0; tail < tails.length; tail++) {
                    final position target = tail == 0 ? currentH : tails[tail - 1];
                    position currentT = tails[tail];

                    currentT = getPosition2(target, currentT);

                    tails[tail] = currentT;
                }


                visitedByTail.add(tails[tails.length - 1]);
            }
        }

        return visitedByTail.size();
    }


}





