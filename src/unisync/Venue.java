package unisync;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class Venue {
    private String venueId;
    private String name;
    private int capacity;
    private Map<LocalDate, Event> bookings = new HashMap<> ();

    
    // constructors
    public Venue(String venueId, String name, int capacity){
        if (venueId != null) this.venueId = venueId;
        if (name != null) this.name = name;
        if (capacity != 0) this.capacity = capacity;
        this.bookings = new HashMap<>();  
    }


    // getters and setters
    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Map<LocalDate, Event> getBookings() {
        return bookings;
    }

    public void setBookings(Map<LocalDate, Event> bookings) {
        this.bookings = bookings;
    }

    // methods
    public void bookVenue(LocalDate date, Event e){

    }

    public boolean isAvailable(LocalDate date){
        
    }


    


}
