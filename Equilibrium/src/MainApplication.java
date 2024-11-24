//In this public class we have the MainApplication and also the code of a seperate Class for equlibrium
package Equilibrium;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("$ Enter statement size: ");
        int size = scanner.nextInt();
        int[] transactions = new int[size];

        System.out.print("$ Enter statement: ");
        for (int i = 0; i < size; i++) {
            transactions[i] = scanner.nextInt();
        }

        Equilibrium equilibrium = new Equilibrium(transactions);
        int[] longestPeriod = equilibrium.findLongestEquilibriumPeriod();

        System.out.print("Longest Equilibrium Period is [");
        for (int i = longestPeriod[0]; i <= longestPeriod[1]; i++) {
            System.out.print(i);
            if (i < longestPeriod[1]) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        scanner.close();
    }
}
class Equilibrium {
    private int[] transactions;

    public Equilibrium(int[] transactions) {
        this.transactions = transactions;
    }

    public int[] findLongestEquilibriumPeriod() {
        int maxLength = 0;
        int start = -1;
        int end = -1;

        for (int i = 0; i < transactions.length; i++) {
            int sum = 0;
            for (int j = i; j < transactions.length; j++) {
                sum += transactions[j];
                if (sum == 0) {
                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return new int[]{start, end};
    }
}
