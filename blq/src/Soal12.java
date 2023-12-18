import java.util.Scanner;

public class Soal12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input: ");
        String input = scanner.nextLine();
        input = input.replaceAll("\\s", "");
        String[] arrInput = input.split("");
        int[] arr = new int[arrInput.length];

        for(int i = 0; i < arrInput.length; ++i) {
            arr[i] = Integer.parseInt(arrInput[i]);
        }

        for(int i = 0; i < arr.length; ++i) {
            for(int j = 0; j < arr.length; ++j) {
                if (arr[j] > arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        System.out.print("output : ");

        for(int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }

    }
}
