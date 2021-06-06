package base;

import java.util.Scanner;

public class BAC {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        BAC bac = new BAC();
        bac.output();
    }

    private String sexPrompt() {
        System.out.print("Enter a 1 if you are male or a 2 if you are female: ");
        return in.nextLine();
    }

    private String alcPrompt() {
        System.out.print("How many ounces of alcohol did you have? ");
        return in.nextLine();
    }

    private String lbsPrompt() {
        System.out.print("What is your weight, in pounds? ");
        return in.nextLine();
    }

    private String hrsPrompt() {
        System.out.print("How many hours has it been since your last drink? ");
        return in.nextLine();
    }

    private boolean isNumber(String s) {
        try {
            int n = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private double bacCalc(String s, String a, String l, String h) {
        double adr = Integer.parseInt(s) == 2 ? 0.66 : 0.73;
        int alc = Integer.parseInt(a);
        int lbs = Integer.parseInt(l);
        int hrs = Integer.parseInt(h);

        return (alc * 5.14 / lbs * adr) - .015 * hrs;
    }

    private void output() {
        String sex = sexPrompt();
        String alc = alcPrompt();
        String lbs = lbsPrompt();
        String hrs = hrsPrompt();
        boolean s = isNumber(sex);
        boolean a = isNumber(alc);
        boolean l = isNumber(lbs);
        boolean h = isNumber(hrs);
        if (!s || !a || !l || !h) {
            System.out.println("Invalid input");
            return;
        }
        double bac = bacCalc(sex, alc, lbs, hrs);
        System.out.printf("Your BAC is %f\n", bac);
        if (bac < 0.08) {
            System.out.println("It is legal for you to drive.");
        }
        else {
            System.out.println("It is not legal for you to drive.");
        }
    }
}
