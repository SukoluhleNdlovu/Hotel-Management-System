/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelreservationsystem;

/**
 *
 * @author Sukoluhe Ndlovu
 */
public class Room {
   private int floorNumber;
    private int roomNumber;
    private boolean isReserved;
    private String guestName;
    private int durationOfStay;
    private String foodAllergies;

    public Room(int floorNumber, int roomNumber) {
        this.floorNumber = floorNumber;
        this.roomNumber = roomNumber;
        this.isReserved = false;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserve(String guestName, int durationOfStay, String foodAllergies) {
        if (!isReserved) {
            this.isReserved = true;
            this.guestName = guestName;
            this.durationOfStay = durationOfStay;
            this.foodAllergies = foodAllergies;
            System.out.println("Room " + roomNumber + " on floor " + floorNumber + " has been reserved for " + guestName +
                    " for " + durationOfStay + " days. Food allergies: " + foodAllergies);
        } else {
            System.out.println("Room " + roomNumber + " on floor " + floorNumber + " is already reserved.");
        }
    }

    public void cancelReservation() {
        if (isReserved) {
            this.isReserved = false;
            this.guestName = null;
            this.durationOfStay = 0;
            this.foodAllergies = null;
            System.out.println("Reservation for room " + roomNumber + " on floor " + floorNumber + " has been canceled.");
        } else {
            System.out.println("Room " + roomNumber + " on floor " + floorNumber + " is not reserved.");
        }
    }

    public void displayReservationInfo() {
        if (isReserved) {
            System.out.println("Room " + roomNumber + " on floor " + floorNumber + " is reserved for " + guestName +
                    " for " + durationOfStay + " days. Food allergies: " + foodAllergies);
        } else {
            System.out.println("Room " + roomNumber + " on floor " + floorNumber + " is available.");
        }
    }
}