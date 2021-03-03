package javaBasics.Elevator;

import java.util.*;

public class Elevator {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        String scanData = "";
        int floor;
        Deque<Integer> floorList = new ArrayDeque<>();

        System.out.println("Привет!");
        while (true) {
            System.out.println("Введите номер этажа (для завершения введите 0):");
            scanData = scan.nextLine();
            scanData = scanData.trim();
            if (scanData.matches("(-?\\d+)")) {
                scanData = scanData.trim();
                floor = Integer.parseInt(scanData);
                if (floor == 0) {
                    floorList.offerLast(floor);
                    writeFloorList(floorList);
                    break;
                } else if ((floor <= 25) && (floor > 0)) {
                    floorList.offerLast(floor);
                } else {
                    System.out.println("Такого этажа в доме нет");
                }
            } else
                System.out.println("Формат введенных данных не верный");
        }

        scan.close();
    }

    public static void writeFloorList(Queue<Integer> queue) {
        int waitDoorsInSeconds = 10;
        int waitMoveInSeconds = 5;
        int totalTime = 0;

        int currentFloor = -1;
        int previousFloor;
        while (queue.peek() != null) {
            previousFloor = currentFloor;
            currentFloor = queue.poll();
            if (previousFloor != -1)
                totalTime += Math.abs(currentFloor - previousFloor)*waitMoveInSeconds;
            totalTime += waitDoorsInSeconds;

            System.out.print("этаж " + currentFloor);
            if (currentFloor != 0)
                System.out.print(" -> ");
            else
                System.out.print("\nВремя, затраченное лифтом на маршрут: " + totalTime + "c");
        }
    }
}


