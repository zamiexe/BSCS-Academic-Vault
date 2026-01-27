public class ArraySearchIndex {
  public static void main(String[] args) throws Exception {
    int[] numbers = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

    System.out.println("int[] numbers = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};");
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == 80) {
        System.out.println("Index " + i + ": " + numbers[i]);
      }
    }
  }
}