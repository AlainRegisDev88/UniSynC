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
        if (venueId != null) this.venueId = venueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity != 0) this.capacity = capacity;
    }

    public Map<LocalDate, Event> getBookings() {
        return bookings;
    }

    public void setBookings(Map<LocalDate, Event> bookings) {
        this.bookings = bookings;
    }

    // methods
    public void bookVenue(LocalDate date, Event e){
        if (!isAvailable(date)) {
            throw new IllegalStateException(name + " is on already on" + date);
        }

        bookings.put(date, e);


    }

    public boolean isAvailable(LocalDate date){
        return !bookings.containsKey(date);
    }

    public void cancelBooking(LocalDate date){
        bookings.remove(date);

    }

   
   




    


}
