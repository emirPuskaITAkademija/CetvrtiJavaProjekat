/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konsultacije;

import java.util.Scanner;

public class PrestupnaGodina {

    public static void main(String[] args) {

        Scanner nasScanner = new Scanner(System.in);
        System.out.println("Unesite broj mjeseca");

        int monthNumber = nasScanner.nextInt();
        System.out.println("unesite broj godine");
        int yearNumber = nasScanner.nextInt();
        int numberOfDaysInMonth = 0;
        switch (monthNumber) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numberOfDaysInMonth = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numberOfDaysInMonth = 30;
                break;
            case 2:
                if ((yearNumber % 4 == 0 && yearNumber % 100 != 0)) {
                    numberOfDaysInMonth = 29;
                    System.out.println("Prestupna godina, februar ima " + numberOfDaysInMonth + "  dana");
                } else {
                    numberOfDaysInMonth = 28;

                }
                break;
            default:
                System.out.println("Invalidan unos");
                System.out.println(numberOfDaysInMonth);
                break;
        }

    }

}
