package util;

import java.sql.Date;
import java.util.Scanner;

public class Menu {

    private static final Scanner sc = new Scanner(System.in);


    public static int getInteger(String massage) {
        System.out.println(massage);
        return sc.nextInt();
    }

    public static String getString(String massage) {
        System.out.println(massage);
        return sc.next();
    }

    public static Date getDate(String massage) {
        System.out.println(massage);
        sc.nextLine();
        String s = sc.nextLine();
        String[] split = s.split("-");
        int year = Integer.parseInt(split[0]) - 1900;
        int mount = Integer.parseInt(split[1]) - 1;
        return new Date(year, mount, Integer.parseInt(split[2]));
    }

}
