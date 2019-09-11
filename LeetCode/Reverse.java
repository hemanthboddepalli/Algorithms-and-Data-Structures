//Title: Reverse Integer
// Given a 32-bit signed integer, reverse digits of an integer.

class Reverse {
    public int reverse(int x) {
        long res = 0;
    	while (x != 0) {
    		int rem = x % 10;
    		x = x/10;
    		res = res * 10 + rem;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
    	}
		return (int) res;
    }
}
