/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelreservationsystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sukoluhle Ndlovu
 */
public class Hotel {
   private static final int FLOORS = 10;
    private static final int ROOMS_PER_FLOOR = 2;
    private static final int TOTAL_ROOMS = FLOORS * ROOMS_PER_FLOOR;
    private List<Room> rooms;
    private boolean[] roomOccupation;

    public Hotel() {
        rooms = new ArrayList<>();
        roomOccupation = new boolean[TOTAL_ROOMS];
        for (int floor = 1; floor <= FLOORS; floor++) {
            for (int room = 1; room <= ROOMS_PER_FLOOR; room++) {
                rooms.add(new Room(floor, room));
            }
        }
    }

    public void reserveRoom(int floor, String guestName, int durationOfStay, String foodAllergies) {
        int room1 = (floor - 1) * ROOMS_PER_FLOOR;
        int room2 = room1 + 1;

        if (!roomOccupation[room1]) {
            rooms.get(room1).reserve(guestName, durationOfStay, foodAllergies);
            roomOccupation[room1] = true;
        } else if (!roomOccupation[room2]) {
            rooms.get(room2).reserve(guestName, durationOfStay, foodAllergies);
            roomOccupation[room2] = true;
        } else {
            System.out.println("No available rooms on floor " + floor);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Would you like to be placed on another available floor? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                System.out.print("Enter alternate floor number (1-10): ");
                int alternateFloor = scanner.nextInt();
                scanner.nextLine(); 
                if (alternateFloor >= 1 && alternateFloor <= 10) {
                    reserveRoom(alternateFloor, guestName, durationOfStay, foodAllergies);
                } else {
                    System.out.println("Invalid floor number.");
                }
            } else {
                System.out.println("We are sorry, we could not provide you a room on the floor of your choice.");
            }
        }
    }

    public void cancelReservation(int floor, int room) {
        int index = (floor - 1) * ROOMS_PER_FLOOR + (room - 1);
        if (index >= 0 && index < TOTAL_ROOMS) {
            rooms.get(index).cancelReservation();
            roomOccupation[index] = false;
        } else {
            System.out.println("Room not found.");
        }
    }

    public void checkAvailability() {
        for (Room room : rooms) {
            room.displayReservationInfo();
        }
    }
}