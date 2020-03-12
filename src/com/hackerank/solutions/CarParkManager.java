package com.hackerank.solutions;

import java.util.*;

public class CarParkManager {
    private static void manageParking(){
        //Map to store parked car data against its ticket number
        Map<Integer, String> carDataMap = new HashMap<>();
        //Clone of the above map to show the changes in the map
        Map<Integer, String> carDataMapClone = new HashMap<>();

        //Array to track parking slots availability
        String[] parkingSlots;
        parkingSlots = new String[10];

        //ticket number initialized at 5000
        int ticketNo = 5000;

        //final output string
        String output = "";
        StringBuilder result = new StringBuilder();
        StringBuilder freeSpace = new StringBuilder();
        StringBuilder takenSpace = new StringBuilder();

        //taking user input
        Scanner sc = new Scanner( System.in );
        System.out.println( "Enter an input string to process ....\n" );
        //storing the input string
        String input = sc.nextLine();

        String[] splitLicensePlate = input.split( "," );

        int i = 0;
        int flag = 0;
        try {
            do {
                if ( splitLicensePlate[i].startsWith( "p" ) ) {
                    String[] licensePlate = splitLicensePlate[i].split( "p" );
                    if(flag < parkingSlots.length){
                        parkingSlots[flag] = String.valueOf( ticketNo );
                        carDataMap.put( ticketNo, licensePlate[1] );
                        carDataMapClone.put( ticketNo, licensePlate[1] );
                        ticketNo++;
                        flag++;
                    }
                }
                if ((splitLicensePlate[i].startsWith( "u" ) && splitLicensePlate[i + 1].equalsIgnoreCase( "c" ))||splitLicensePlate[i].startsWith( "u" )) {
                    String[] licensePlate = splitLicensePlate[i].split( "u" );
                    int ticket = Integer.parseInt( licensePlate[1] );
                    if ( carDataMap.containsKey(ticket ) ) {
                        ArrayList<String> parkingSlots1 = new ArrayList<>( Arrays.asList( parkingSlots ) );
                        parkingSlots1.remove(String.valueOf( ticket ));
                        parkingSlots = parkingSlots1.toArray(parkingSlots);
                        carDataMap.remove( ticket );
                        flag--;
                    } else {
                        System.out.println( "Car with ticket no" + " " + ticket + " " + " not found !" );
                    }
                }
                i++;
            } while (i < splitLicensePlate.length);
        } catch (Exception e) {
            throw e;
        }

        for (String values : carDataMap.values()) {
            result.append(values).append(",");
            output = result.toString().replace( "p", "" );
        }

        for (int w = 0; w < parkingSlots.length; w++) {
            if ( (parkingSlots[w] == null) ) {
                freeSpace.append("Slot" + " ").append(w).append(",");
            } else {
                takenSpace.append("Slot" + " ").append(w).append(",");
            }
        }

        System.out.println( "Input => " + " " + input );
        System.out.println( "Output => " + " " + output );
        System.out.println( "Free Parking Slot => " + " " + freeSpace );
        System.out.println( "Taken Parking Slot => " + " " + takenSpace );
        System.out.println( "Car Parking Map (Before) => " + " " + carDataMapClone );
        System.out.println( "Car Parking Map (After)  => " + " " + carDataMap );
    }

    public static void main(String[] args) {
        manageParking();
    }
}
