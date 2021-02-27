package Shooter;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String dataIn = "";

        Player player = new Player();
        int slot = 0;

        System.out.println("Hello!");

        while (true) {
            System.out.println("Enter the number of weapon slot:");
            dataIn = scan.nextLine();

            if (dataIn.matches("(\\s*)(-?\\d+)")) {
                slot = Integer.parseInt(dataIn);

                if (slot == -1) {
                    System.out.println("\n\nBye!");
                    break;
                }

                slot--;
                player.shootByWeapon(slot);
            } else
                System.out.println("Try again!");
        }
    }
}
