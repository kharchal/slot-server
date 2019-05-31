package ua.com.hav.slotserver;

import java.util.Random;

public class Randomizer {
    public static final String chars = "AKQJ9876";
    public static final int MIN = 8;
    public static final int MAX = 24;

    public static void main(String[] args) {
        System.out.println("s = " + create(15));
        System.out.println("s = " + create(23));
        System.out.println("s = " + create(10));
    }

    private static String create(final int n) {
        Random random = new Random();
        int max = chars.length();
        char[] ch = new char[n];
        for (int i = 0; i < MIN; i++) {
            ch[i] = chars.charAt(i);
        }
        for (int i = MIN; i < n; i++) {
            ch[i] = chars.charAt(random.nextInt(max));
        }
        do {
            for (int i = 0; i < n - 1; i++) {
                int ind = random.nextInt(n);
                if (i != ind) {
                    char c = ch[i];
                    ch[i] = ch[ind];
                    ch[ind] = c;
                }
            }
        } while (check(ch));
        return new String(ch);
    }

    private static boolean check(char[] ch) {
        for (int i = 0; i < ch.length - 1; i++) {
            if (ch[i] == ch[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
