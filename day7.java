import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new java.io.File("in.txt"));

        int current = 0;
        Directory root = new Directory("/");
        root.parent = null;
        while (sc.hasNextLine()) {
            String[] helper = sc.nextLine().split(" ");
            if (helper[0].equals("$")) {
                String command = helper[1];
                if (command.equals("cd")) {
                    String arg = helper[2];
                    if (arg.equals("..")) {
                        root = root.parent;
                    } else {
                        for (Directory dir : root.dirs) {
                            if (dir.name.equals(arg)) {
                                root = dir;
                                break;
                            }
                        }
                    }
                } else if (command.equals("ls")) {
                    continue;
                }
            } else if (helper[0].equals("dir")) {
                String name = helper[1];
                Directory newDir = new Directory(name);
                newDir.parent = root;
                root.dirs.add(newDir);
            } else {
                long size = Long.parseLong(helper[0]);
                String fileName = helper[1];
                root.files.add(new File(fileName, size));
            }
        }
        while (root.parent != null) {
            root = root.parent;
        }
        List<Directory> list = new ArrayList<>();
        Queue<Directory> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Directory curr = q.poll();
            list.add(curr);
            q.addAll(curr.dirs);
        }
        for(Directory x: list){
            x.size = countSums(x, 0L);
        }
        long unused = 8381165;
        PriorityQueue<Directory> pq = new PriorityQueue<>(Comparator.comparing(o -> o.size));
        for(Directory x :list){
            if(x.size >= unused){
                pq.add(x);
            }
        }
        System.out.println(pq.peek().size);
    }

    public static long countSums(Directory root, long x) {
        if (root == null) {
            return 0;
        }
        long aux = root.size;
        for(File y:root.files){
            aux += y.size;
        }
        for(Directory t :root.dirs){
            aux += countSums(t, 0);
        }
        return aux;
    }


}

class Directory {
    String name;
    List<Directory> dirs;
    List<File> files;
    Directory parent;
    long size;

    public Directory(String name) {
        this.name = name;
        dirs = new ArrayList<>();
        files = new ArrayList<>();
        long size = 0L;
    }
}

class File {
    String name;
    long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }
}

