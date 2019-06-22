/*
String to Integer

Write a recursive function to convert a given string into the number it represents. That is input will be a 
numeric string that contains only numbers, you need to convert the string into corresponding integer and return the answer.
*/


public class ConvertStringToInt {

	public static int convertStringToInt(String input) {
		if (input.length() == 1) {
            return input.charAt(0) - '0';
        }
        int res = 0; 
        int first = input.charAt(0) - '0';
        int power = input.length() - 1;
        res = convertStringToInt(input.substring(1));
        res = res + first*((int)Math.pow(10,power));
        return res;
	}
}
