import javax.swing.*;

/**
 * @author Abhishek Gunasekar, CS 180 Black
 * @version 09/24/19
 */
public class WorldClock {
    static final String TITLE = "World Clock";
    static final String[][] LOCATIONS = {
            {"Pago Pago"},  //-11
            {"Honolulu", "Papeete"},   //-10
            {"Anchorage"},  //-9
            {"Vancouver", "Los Angeles"},    //-8
            {"Edmonton", "Denver"},  //-7
            {"Mexico City", "Chicago"},  //-6
            {"Miami", "Toronto", "New York"}, //-5
            {"Santiago", "Halifax"}, //-4
            {"Rio De Janeiro"}, //-3
            {"King Edward Point"}, //-2
            {"Praia"},  //-1
            {"UTC", "Lisbon", "London"},  //0
            {"Madrid", "Paris", "Rome", "Berlin", "Stockholm"}, //+1
            {"Athens", "Cairo", "Jerusalem"}, //+2
            {"Moscow", "Jeddah"},    //+3
            {"Dubai"},  //+4
            {"Karachi"},    //+5
            {"Dhaka"},  //+6
            {"Bangkok"},    //+7
            {"Singapore", "Hong Kong", "Beijing", "Taipei"},   //+8
            {"Seoul", "Tokyo"}, //+9
            {"Guam", "Sydney"}, //+10
            {"Noumea"}, //+11
            {"Wellington"}  //+12
    };

    public static void main(String[] args) {
        //Stage 1 Below
        int welcomeMessage = JOptionPane.showConfirmDialog(null, "Welcome to the World Clock!", TITLE, JOptionPane.OK_CANCEL_OPTION);
        int[] timezone = {-11, -10, -10, -9, -8, -8, -7, -7, -6, -6, -5, -5, -5, -4, -4, -3, -2, -1, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 5, 6, 7, 8, 8, 8, 8, 9, 9, 10, 10, 11, 12};
        int cityIndex = 0;
        int destinationIndex = 0;
        String[] cities = new String[45];
        int localZone = 0;
        int destinationZone = 0;
        int destinationHour = 0;
        int localMinutes = 0;
        int localHour = 0;

        if (welcomeMessage == 0) {
            int abhi = 0;
            for (int i = 0; i < LOCATIONS.length; i++) {
                for (int j = 0; j < LOCATIONS[i].length; j++) {
//                    for(int k = 0; k < cities.length; k++){
                    cities[abhi] = LOCATIONS[i][j];
                    abhi++;
                }
            }
            //Stage 2 Below
            String city = (String) JOptionPane.showInputDialog(null, "Which city is in the local time zone?", TITLE, JOptionPane.PLAIN_MESSAGE, null, cities, cities[0]);
            if (city != null) {
                for (int i = 0; i < cities.length; i++) {
                    if (cities[i].equalsIgnoreCase(city)) {
                        cityIndex = i;
                    }
                }
                localZone = timezone[cityIndex];
                String localTime = (String) JOptionPane.showInputDialog(null, "What is the local time? (0-23):(0-59)", TITLE, JOptionPane.QUESTION_MESSAGE);
                if (localTime != null) {
                    if(localTime.indexOf(":") != -1){
                        int temp = localTime.indexOf(":");
                        localHour = Integer.parseInt(localTime.substring(0, temp));
                        localMinutes = Integer.parseInt(localTime.substring(temp + 1));
                        boolean temp1 = true;
                        while (true) {
                            if(localHour >= 0 && localHour <= 23 && localMinutes >= 0 && localMinutes <= 59){
                                break;
                            }else{
                                JOptionPane.showMessageDialog(null, "Please enter a valid time. For Example, 13:30", TITLE, JOptionPane.ERROR_MESSAGE);
                                localTime = (String) JOptionPane.showInputDialog(null, "What is the local time? (0-23):(0-59)", TITLE, JOptionPane.QUESTION_MESSAGE);
                                temp = localTime.indexOf(":");
                                localHour = Integer.parseInt(localTime.substring(0, temp));
                                localMinutes = Integer.parseInt(localTime.substring(temp + 1));
                                temp1 = false;
                            }
                        }
                    }else{

                    }

                    int continueTemp = 0;
                    do {
                        String destination = (String) JOptionPane.showInputDialog(null, "Which city is in the destination time zone?", TITLE, JOptionPane.PLAIN_MESSAGE, null, cities, cities[0]);
                        if (destination != null) {
                            for (int i = 0; i < cities.length; i++) {
                                if (cities[i].equalsIgnoreCase(destination)) {
                                    destinationIndex = i;
                                }
                            }
                            destinationZone = timezone[destinationIndex];
                            destinationHour = localHour + destinationZone - localZone;
                            int difference = destinationHour - localHour;
                            if (destinationHour > 24) {
                                destinationHour -= 24;
                            }
                            if(destinationHour < 0){
                                destinationHour+=24;
                            }
                            if(destinationHour + difference - localHour == 24){
                                JOptionPane.showConfirmDialog(null, "In " + destination + ", it is " + destinationHour + ":" + String.format("%02d", localMinutes) + " in the day before.", TITLE, JOptionPane.PLAIN_MESSAGE);
                            }else if(difference + localHour >= 24){
                                JOptionPane.showConfirmDialog(null, "In " + destination + ", it is " + destinationHour + ":" + String.format("%02d", localMinutes) + " in the next day.", TITLE, JOptionPane.PLAIN_MESSAGE);

                            }else{
                                JOptionPane.showConfirmDialog(null, "In " + destination + ", it is " + destinationHour + ":" + String.format("%02d", localMinutes), TITLE, JOptionPane.PLAIN_MESSAGE);
                            }
                            Object[] options1 = {"Enter Next Destination", "Quit"};
                            continueTemp = JOptionPane.showOptionDialog(null, "Continue with the World Clock?", TITLE,
                                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1,
                                    options1[0]);
                            System.out.println(continueTemp);
                        }else{
                            JOptionPane.showConfirmDialog(null, "Thank you for using the World Clock.", TITLE, JOptionPane.PLAIN_MESSAGE);
                        }
                    } while (continueTemp != 1);
                    JOptionPane.showConfirmDialog(null, "Thank you for using the World Clock.", TITLE, JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showConfirmDialog(null, "Thank you for using the World Clock.", TITLE, JOptionPane.PLAIN_MESSAGE);
                }
            } else {
                JOptionPane.showConfirmDialog(null, "Thank you for using the World Clock.", TITLE, JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JOptionPane.showConfirmDialog(null, "Thank you for using the World Clock.", TITLE, JOptionPane.PLAIN_MESSAGE);
        }
    }

}
