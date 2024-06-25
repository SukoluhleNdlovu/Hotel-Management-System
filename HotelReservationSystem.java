/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.hotelreservationsystem;

import java.util.Scanner;

/**
 *
 * @author Sukoluhle Ndlovu
 */
public class HotelReservationSystem {

    public static void main(String[] args) {
       Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        int choice;
        //Display menu 
        do {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. Reserve a room");
            System.out.println("2. Cancel reservation");
            System.out.println("3. Check availability");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
           //Reserve room questions
            switch (choice) {
                case 1:
                    System.out.print("Enter floor number (1-10): ");
                    int reserveFloor = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter guest name: ");
                    String guestName = scanner.nextLine();
                    System.out.print("Enter duration of stay (days): ");
                    int durationOfStay = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter food allergies (if any): ");
                    String foodAllergies = scanner.nextLine();
                    hotel.reserveRoom(reserveFloor, guestName, durationOfStay, foodAllergies);
                    break;
                //Cancel reservation questions
                case 2:
                    System.out.print("Enter floor number (1-10): ");
                    int cancelFloor = scanner.nextInt();
                    System.out.print("Enter room number (1-2): ");
                    int cancelRoom = scanner.nextInt();
                    hotel.cancelReservation(cancelFloor, cancelRoom);
                    break;
               //Check availability 
                case 3:
                    hotel.checkAvailability();
                    break;
                //Exist program
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}