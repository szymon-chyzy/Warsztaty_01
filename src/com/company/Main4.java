package com.company;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.*;

public class Main4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String diceThrow = "";

        while (!diceThrow.equals("QUIT")) {

            System.out.println("===============================================================================================");
            System.out.println("Wpisz kostkę z modyfikatorami w formie xDy+/-z (np. 5D20+7), wpisz quit, żeby zakończyć program.");

            diceThrow = scanner.nextLine();
            diceThrow = StringUtils.upperCase(diceThrow);

            boolean check = Pattern.matches("[0-9]*D[0-9]+[+-]?[0-9]*", diceThrow);

            if (check == true) {

                String x = "1";
                String y = "";
                String z = "";

                x = StringUtils.substringBefore(diceThrow, "D");
                if (x.equals("")) {
                    x = "1";
                }

                String tyl = StringUtils.substringAfter(diceThrow, "D");

                boolean spr = StringUtils.containsAny(tyl, '+');
                boolean spr2 = StringUtils.containsAny(tyl, "-");

                if (spr == true) {
                    y = StringUtils.substringBefore(tyl, "+");
                    z = StringUtils.substringAfter(tyl, "+");

                } else if (spr2 == true) {
                    y = StringUtils.substringBefore(tyl, "-");
                    z = StringUtils.substringAfter(tyl, "-");

                } else if (spr == false && spr2 == false) {
                    y = tyl;
                    z = "0";
                }

                Random random = new Random();
                int x1 = Integer.parseInt(x);
                int y1 = Integer.parseInt(y);
                int sumaXY = 0;
                System.out.print("Symulacja turlania D" + y1 + " to: ");
                for (int i = 0; i < x1; i++) {
                    int rand = random.nextInt(y1) + 1;
                    if (i < x1 - 1) {
                        System.out.print(rand + ", ");
                    } else {
                        System.out.print(rand + ".");
                    }
                    sumaXY += rand;
                }

                int z1 = Integer.parseInt(z);
                int wynikRzutu;

                if (spr == true) {
                    wynikRzutu = sumaXY + z1;
                    System.out.println("\n" + "Rzut " + x + " D" + y + " z modyfikatorem +" + z + " to <<< " + wynikRzutu + " >>>");
                }

                if (spr2 == true) {
                    wynikRzutu = sumaXY - z1;
                    System.out.println("\n" + "Rzut " + x + " D" + y + " z modyfikatorem -" + z + " to <<< " + wynikRzutu + " >>>");
                }

                if (spr == false && spr2 == false) {
                    wynikRzutu = sumaXY;
                    System.out.println("\n" + "Rzut " + x + " D" + y + " bez modyfikatora to <<< " + wynikRzutu + " >>>");
                }

            } else if (diceThrow.equals("QUIT")) {
                    System.out.println("!!! ZAKOŃCZONO DZIAŁANIE PROGRAMU !!!");

            } else {
                System.out.println("!!! Wpisz poprawnie dane !!!");
            }
        }
    }
}
