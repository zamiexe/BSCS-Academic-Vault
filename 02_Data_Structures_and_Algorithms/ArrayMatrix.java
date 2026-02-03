import java.util.Scanner;

public class ArrayStats {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[][] matrix = new int[3][3];

    // Enter values
    System.out.println("Enter values for 3x3 array:");
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        matrix[i][j] = input.nextInt();

      }

    }

    //min/max
    int max = matrix[0][0];
    int min = matrix[0][0];

    // 2. Print

    System.out.println("\nArray");
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(matrix[i][j] + "\t");

        if (matrix[i][j] > max) max = matrix[i][j];
        if (matrix[j][i] < min) min = matrix[j][i];

      }
      System.out.println();
    }



     

    System.out.println("\n");

    for (int i = 0; i < 3; i++) {
      int rowSum = 0;
      for (int j = 0; j < 3; j++) {
        rowSum += matrix[i][j];

      }
      System.out.println("Sum of Row " + (i + 1) + ": " + rowSum);

    // Column 

    System.out.println("\n");

    for (int j = 0; j < 3; j++) {
      int colSum = 0;
      for (int i = 0; i < 3; i++) {
        colSum += matrix[i][j];

      
      System.out.println("Sum of Column " + (j + 1) + ": " + colSum);
    }

    System.out.println("Largest Value: " + max);
    System.out.println("Lowest Value: " + min);

    input.close();
  }
}

