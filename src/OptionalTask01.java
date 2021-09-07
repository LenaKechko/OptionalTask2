import java.util.Scanner;

/* Ввести с консоли n - размерность матрицы a [n] [n].
Задать значения элементов матрицы в интервале значений от -M до M с
помощью генератора случайных чисел (класс Random).
Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).
*/
public class OptionalTask01 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите n = ");
        int n = sc.nextInt();
        System.out.print("Введите m = ");
        int M = sc.nextInt();

        Matrix matrix = new Matrix(n, M);
        System.out.println("Матрица a:");
        matrix.print(matrix.a);

        System.out.print("Выберите k (от 1 до " + n + ") ");
        int k = sc.nextInt() - 1;

        System.out.printf("Матрица, в которой упорядочены строки в порядке возрастания значений элементов %d-го столбца\n", k + 1);
        matrix.print(matrix.changeRows(k));

        System.out.printf("Матрица, в которой упорядочены столбцы в порядке возрастания значений элементов %d-ой строки\n", k + 1);
        matrix.print(matrix.changeCols(k));
    }
}
