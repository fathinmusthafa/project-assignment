import java.util.Scanner;

public class Soal06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String word = scanner.nextLine();
        if (isPalindrome(word)) {
            System.out.println(word + " is palindrome");
        } else {
            System.out.println(word + " is not palindrome");
        }

    }

    public static boolean isPalindrome(String word) {
        word = word.replaceAll("\\s", "").toLowerCase();

        for(int i = 0; i < word.length() / 2; ++i) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
