import java.util.*;

public class Matrix {
    public int [][] a;
    public int n;
    public int m;

    Matrix(int[][] ar, int n, int m) {
        this.a = ar;
        this.n = n;
        this.m = m;
    }

    Matrix(int n, int M) {
        this.n = n;
        this.m = n;
        a = new int[n][m];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = random.nextInt(2 * M + 1) - M;
            }
        }
    }

    void print(int[][] mas) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%4d",mas[i][j]);
            }
            System.out.println();
        }
    }

    int[][] copyMatrix () {
        int[][] temp_a = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(a[i], 0, temp_a[i], 0, n);
        }
        return temp_a;
    }

    int[][] changeRows(int k){
        int[][] temp_a = this.copyMatrix();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                if (temp_a[i][k] > temp_a[j][k]) {
                    for (int l = 0; l < n; l++) {
                        int temp = temp_a[i][l];
                        temp_a[i][l] = temp_a[j][l];
                        temp_a[j][l] = temp;
                    }
                }
            }
        }
        return temp_a;
    }

    int[][] changeCols(int k){
        int[][] temp_a = this.copyMatrix();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                if (temp_a[k][i] > temp_a[k][j]) {
                    for (int l = 0; l < m; l++) {
                        int temp = temp_a[l][i];
                        temp_a[l][i] = temp_a[l][j];
                        temp_a[l][j] = temp;
                    }
                }
            }
        }
        return temp_a;
    }

    int maximum() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (max < a[i][j]) {
                    max = a[i][j];
                }
            }
        }
        return max;
    }

    Matrix removeRowsAndColsWithMax(int max) {
        int[][] temp_a = this.copyMatrix();
        Set<Integer> set_i = new HashSet<Integer>();
        Set<Integer> set_j = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == max) {
                    set_i.add(i);
                    set_j.add(j);
                }
            }
        }

        System.out.println(set_i + " " + set_j);
        for (int i = n - 1; i >= 0; i--) {
            if (set_i.contains(i)) {
                for (int k = i; k < n - 1; k++) {
                    for (int j = 0; j < m; j++) {
                        temp_a[k][j] = temp_a[k + 1][j];
                    }
                }
            }
        }
        for (int j = m - 1; j >= 0; j--) {
            if (set_j.contains(j)) {
                for (int k = j; k < m - 1; k++) {
                    for (int i = 0; i < n; i++) {
                        temp_a[i][k] = temp_a[i][k + 1];
                    }
                }
            }
        }
        return new Matrix(temp_a, n - set_i.size(), m - set_j.size());
    }

    int firstIndexPositiveElement(int i) {
        for (int j = 0; j < m; j++) {
            if (a[i][j] > 0) return j;
        }
        return -1;
    }

    int secondIndexPositiveElement(int i, int first) {
        for (int j = first + 1; j < m; j++) {
            if (a[i][j] > 0) return j;
        }
        return -1;
    }

    int sumElement() {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int firstIndex = firstIndexPositiveElement(i), secondIndex = secondIndexPositiveElement(i, firstIndex);
            if (firstIndex != -1 && secondIndex != -1) {
                for (int j = firstIndex + 1; j < secondIndex; j++) {
                    sum += a[i][j];
                }
            }
        }
        return sum;
    }

    int countIncreas (int i) {
        int count = 0;
        int j = 0;
        while (j < m){
            int temp_count = 0;
            int k;
            for (k = j; k < m - 1; k++) {
                if (a[i][k] < a[i][k + 1]) {
                    temp_count++;
                } else {
                    break;
                }
            }
            if (temp_count > count) {
                count = temp_count;
            }
            j = k + 1;
        }
        return count;
    }

    int countDecreas (int i) {
        int count = 0;
        int j = 0;
        while (j < m){
            int temp_count = 0;
            int k;
            for (k = j; k < m - 1; k++) {
                if (a[i][k] > a[i][k + 1]) {
                    temp_count++;
                } else {
                    break;
                }
            }
            if (temp_count > count) {
                count = temp_count;
            }
            j = k + 1;
        }
        return count;
    }

    int[] maxCount() {
        int[] count = {countIncreas(0), countDecreas(0)};
        for (int i = 1; i < n; i++) {
            if (count[0] < countIncreas(i)) {
                count[0] = countIncreas(i);
            }
            if (count[1] < countDecreas(i)) {
                count[1] = countDecreas(i);
            }
        }
        return count;
    }

}
