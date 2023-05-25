import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<String>> solutions;

    public List<List<String>> solveNQueens(int n) {
        char[][] ans = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = '.';
            }
        }
        solutions = new LinkedList<List<String>>();
        backTracker(ans, 0, n);
        return solutions;
    }

    void backTracker(char[][] ans, int row, int n) {
        if (row == n) {
            List<String> solution = new LinkedList<String>();
            for (int i = 0; i < n; i++) {
                solution.add(new String(ans[i]));
            }
            solutions.add(solution);
            return;
        }

        for (int i = 0; i < n; i++) {
            ans[row][i] = 'Q';
            if (isValidPlacement(ans, row, i, n)) {
                backTracker(ans, row + 1, n);
            }
            ans[row][i] = '.';
        }
    }

    boolean isValidPlacement(char[][] matrix, int row, int column, int n) {
        // checking vertical
        for (int i = 0; i < n; i++) {
            if (i != row && matrix[i][column] == 'Q') {
                return false;
            }
        }
        // checking horizontal
        for (int i = 0; i < n; i++) {
            if (i != column && matrix[row][i] == 'Q') {
                return false;
            }
        }
        // NW direction
        int i = row - 1;
        int j = column - 1;
        while (i >= 0 && j >= 0) {
            if (matrix[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        // NE direction
        i = row - 1;
        j = column + 1;
        while (i >= 0 && j < n) {
            if (matrix[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        // SW direction
        i = row + 1;
        j = column - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == 'Q') {
                return false;
            }
            i++;
            j--;
        }

        // SE direction
        i = row + 1;
        j = column + 1;
        while (i < n && j < n) {
            if (matrix[i][j] == 'Q') {
                return false;
            }
            i++;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        List<List<String>> solutions = solver.solveNQueens(4);
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
