public class ArrayDeleteValue {
  public static void main(String[] args) throws Exception {
    int todelete = 50;
    int[] numbers = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == todelete) {
        for (int j = i; j < numbers.length - 1; j++) {
          numbers[j] = numbers[j + 1];
        }
        break;
      }
    }
    numbers[numbers.length - 1] = 0;

    System.out.println("Number 50 deleted.");
    System.out.print("[");
    for (int i = 0; i < numbers.length; i++) {
      System.out.print(numbers[i]);
      if (i < numbers.length - 1) {
        System.out.print(", ");
      }
    }
    System.out.print("]");
  }
}