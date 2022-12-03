//Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("N =  ");
        int N = in.nextInt();
        int[][] matrix = new int[N][N];
        int count = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0, value = i; j < matrix[i].length; j++, value += N) {
                matrix[i][j] = count++;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
