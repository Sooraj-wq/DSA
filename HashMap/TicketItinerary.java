// Find the source and destination and the path taken towards it

/* HINT - Generate a reverse map, since it is much easier to compare keys
 * than compares values. 
 */


import java.util.*;
public class TicketItinerary {

    public static String getStart(HashMap<String, String> tick){
        HashMap<String,String> revMap = new HashMap<>();

        for(String key : tick.keySet()){
            revMap.put(tick.get(key),key);
        }

        for(String key : tick.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }
        }

        return null;
    }
    
    public static void main(String[] args) {

        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai","Bengaluru");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa","Chennai");
        tickets.put("Delhi","Goa");

        String start = getStart(tickets);

        while(tickets.containsKey(start)){
            System.out.print(start+" -> ");
            start = tickets.get(start);
        }

        System.out.println(start);

    }
}
