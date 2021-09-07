import java.util.Random;
import java.util.Scanner;

/* Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.*/
/*т.к. в условии нет конкретики, то рассматриваю в пределах строк*/
public class OptionalTask02 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите n = ");
        int n = sc.nextInt();
        System.out.print("Введите m = ");
        int M = sc.nextInt();


        Matrix matrix = new Matrix(n, M);
        System.out.println("Матрица a:");
        matrix.print(matrix.a);

        int[] result = matrix.maxCount();
        System.out.println("Наибольшее число возрастающих элементов матрицы, идущих подряд равно " + (result[0] + 1));
        System.out.println("Наибольшее число убывающих элементов матрицы, идущих подряд равно " + (result[1] + 1));


    }
}
