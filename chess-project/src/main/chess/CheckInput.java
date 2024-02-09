package chess;

public class CheckInput {

	public static boolean checkCoordinateValidity(String input) {
		if (((String) input).length() == 2 ) {
			if ((input.charAt(1) >= 'a' && input.charAt(1) <= 'h')
					&& (input.charAt(0) >= '1' && input.charAt(0) <= '8')) {
				return true;
			}
		}
		return false;
	}
}
