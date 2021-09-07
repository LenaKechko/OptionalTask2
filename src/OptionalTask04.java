import java.util.Scanner;

/*Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие*/
public class OptionalTask04 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите n = ");
        int n = sc.nextInt();
        System.out.print("Введите m = ");
        int M = sc.nextInt();

        Matrix matrix = new Matrix(n, M);
        System.out.println("Матрица a:");
        matrix.print(matrix.a);

        System.out.println("Максимальный элемент в матрице = " + matrix.maximum());
        Matrix result = matrix.removeRowsAndColsWithMax(matrix.maximum());
        System.out.println("Полученная матрица:");
        result.print(result.a);

    }
}
