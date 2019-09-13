//Palindrome Number
//Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        long y = 0; int input = x;
        while (input != 0) {
            int rem = input%10;
            y = y * 10 + rem;
            input = input / 10;
        }
        return x == (int)y;
    }
}
