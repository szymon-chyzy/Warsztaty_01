package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Wylosuję od 1 do 100 - zgadnij jaka:");

        Random r = new Random();
        int liczba = r.nextInt(100-1)+1;

        int strzal = sprawdzacz();

        while (liczba != strzal) {
            if (liczba < strzal) {
                System.out.println("za duża, spróbuje jeszcze");
                strzal = sprawdzacz();
            } else if (liczba > strzal) {
                System.out.println("za mała, spróbuje jeszcze");
                strzal = sprawdzacz();
                }
            }

        System.out.println("Zgadłeś - liczba to " + liczba);
    }

    static int sprawdzacz() {

        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Nieprawidłowe dane. Podaj jeszcze raz:");
        }

        return scan.nextInt();

    }

}

