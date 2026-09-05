import java.util.Scanner;

public class LibraryISBNValidator {

    public static String normalizeCode(String raw) {

        String code = raw.trim();

        if (code.length() >= 3) {
            code = code.substring(0, 3).toUpperCase() + code.substring(3);
        }

        return code;
    }

    public static String validateAndFormat(String code) {

        if (code.length() != 13)
            return "Invalid: wrong length";

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i)))
                return "Invalid: publisher code must be 3 letters";
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i)))
                return "Invalid: body must contain only digits";
        }

        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(publisher).append("] ");
        sb.append("YEAR: ").append(year);
        sb.append(" | CATALOG: ").append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Code: ");
        String raw = sc.nextLine();

        String normalized = normalizeCode(raw);

        System.out.println(validateAndFormat(normalized));
    }
}