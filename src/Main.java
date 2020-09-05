import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the SAP Community Coding Challenge #3");
        Scanner input = new Scanner(System.in);
        String emoticon1, emoticon2;
        String split;
        String add;
        System.out.println("Enter emoji for Splitting : ");
        emoticon1 = input.nextLine();
        System.out.println("Enter emoji for Combining : ");
        emoticon2 = input.nextLine();
        System.out.println("After Splitting : ");
        split = removeJoiner(emoticon1);
        System.out.print(split);
        System.out.println();
        System.out.println("After Combining : ");
        add = addJoiner(emoticon2);
        for (int i=0;i<add.length();i++)
            System.out.print(add.charAt(i));
    }

    public static String removeJoiner(String emoji) {
        String[] split;
        String rmjoin;
        if(emoji.contains("\u200D")) {
            split = (emoji.split("\u200D"));
            rmjoin = convert(split);
            return rmjoin;
        }
        else {
            return emoji;
        }
    }

    private static String convert(String[] split) {
        StringBuilder sb = new StringBuilder();
        for(String str : split) {
            sb.append(str);
        }
        return sb.substring(0, sb.length());
    }

    public static String addJoiner(String emojis) {
        String sub1;
        String zwj = "\u200D";
        String join = "";
        for (int i = 0; i < emojis.length(); i += 2) {
            sub1 = emojis.substring(i, i + 2);
            join += sub1 + zwj;
        }
        return join;
    }
}
