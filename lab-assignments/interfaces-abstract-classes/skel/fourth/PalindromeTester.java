package fourth;

public final class PalindromeTester {
    private PalindromeTester() {}
    public static boolean isPalindrome(int num) {
        int reversedNum = 0;
        int originalNum = num;
        int remainder;
        while (num != 0) {
            remainder = num % 10;
            reversedNum = reversedNum * 10 + remainder;
            num  /= 10;
        }
        return originalNum == reversedNum;
    }

}
