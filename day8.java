import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new java.io.File("in.txt"));

        String firstLine = sc.nextLine();
        int n = firstLine.length();
        int[][] mat = new int[n][n];
        int current = 0;
        int currRow = 0;
        int currColumn = 0;
        do {
            for (int i = 0; i < firstLine.length(); i++) {
                String s = "" + firstLine.charAt(i);
                mat[currRow][i] = Integer.parseInt(s);
            }
            currRow++;
            firstLine = sc.nextLine();
        } while (sc.hasNextLine());
        for (int i = 0; i < firstLine.length(); i++) {
            String s = "" + firstLine.charAt(i);
            mat[currRow][i] = Integer.parseInt(s);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                current = Math.max(current, visibleFrom(i, j, mat));
            }
        }
        System.out.println(current);
        // 3 1
    }

    public static int visibleFrom(int posX, int posY, int[][] matrix) {
        int tree = matrix[posX][posY];
        int n = matrix.length;
        int first = 0;
        // check row from left
        for (int i = posX - 1; i >= 0; i--) {
            if (matrix[i][posY] >= tree) {
                first++;
                break;
            } else {
                first++;
            }
        }
        int second = 0;
        for (int i = posX + 1; i < n; i++) {
            if (matrix[i][posY] >= tree) {
                second++;
                break;
            } else {
                second++;
            }
        }

        int third = 0;
        for (int i = posY + 1; i < n; i++) {
            if (matrix[posX][i] >= tree) {
                third++;
                break;
            } else {
                third++;
            }
        }
        int fourth = 0;
        for (int i = posY - 1; i >= 0; i--) {
            if (matrix[posX][i] >= tree) {
                fourth++;
                break;
            } else {
                fourth++;
            }
        }
        return first * second * fourth * third;
    }


}

