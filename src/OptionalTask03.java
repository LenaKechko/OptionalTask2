import java.util.Random;
import java.util.Scanner;

/* Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки*/
public class OptionalTask03 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите n = ");
        int n = sc.nextInt();
        System.out.print("Введите m = ");
        int M = sc.nextInt();

        Matrix matrix = new Matrix(n, M);
        System.out.println("Матрица a:");
        matrix.print(matrix.a);
        System.out.println("Сумма элементов матрицы, расположенных между первым и вторым положительными " +
                "элементами каждой строки равна " + matrix.sumElement());
    }
}
