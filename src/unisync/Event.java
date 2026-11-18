package unisync;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Event {
    private String eventId;
    private String name;
    private LocalDate date;
    private int capacity;
    private Club organizingClub;
    private Venue venue;
    private Budget budget;
    private List<Member> registeredMembers;


    public Event(String eventId, String name, LocalDate date, int capacity, Club organizingClub, Venue venue, Budget budget) {
        this.eventId = validateEventId(eventId) ? eventId : null;
        this.name = validateName(name) ? name : null;
        this.date = validateDate(date) ? date : null;
        this.capacity = validateCapacity(capacity) ? capacity : 0;
        this.organizingClub = validateOrganizingClub(organizingClub) ? organizingClub : null;
        this.venue = validateVenue(venue) ? venue : null;
        this.budget = validateBudget(budget) ? budget : null;
        this.registeredMembers = new ArrayList<>();

        
    }

    // validators

    public static boolean validateEventId(String eventId) {
        if (eventId == null || eventId.isEmpty() || eventId.isBlank()) {
            return false;
        }
        return true;
    }

    public static boolean validateName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            return false;
        }
        return true;
    }

    public static boolean validateDate(LocalDate date) {
        if (date == null) {
            return false;
        }
        return true;
    }

    public static boolean validateCapacity(int capacity) {
        if (capacity <= 0) {
            return false;
        }
        return true;
    }

    public static boolean validateOrganizingClub(Club organizingClub) {
        if (organizingClub == null) {
            return false;
        }
        return true;
    }

    public static boolean validateVenue(Venue venue) {
        if (venue == null) {
            return false;
        }
        return true;
    }

    public static boolean validateBudget(Budget budget) {
        if (budget == null) {
            return false;
        }
        return true;
    }


      // getters and setters
    public String getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getCapacity() {
        return capacity;
    }

    public Club getOrganizingClub() {
        return organizingClub;
    }

    public Venue getVenue() {
        return venue;
    }

    public Budget getBudget() {
        return budget;
    }

    public List<Member> getRegisteredMembers() {
        return registeredMembers;
    }

    public void setEventId(String eventId) {
        this.eventId = validateEventId(eventId) ? eventId : null;
    }

    public void setName(String name) {
        this.name = validateName(name) ? name : null;
    }

    public void setDate(LocalDate date) {
        this.date = validateDate(date) ? date : null;
    }

    public void setCapacity(int capacity) {
        this.capacity = validateCapacity(capacity) ? capacity : 0;
    }

    public void setOrganizingClub(Club organizingClub) {
        this.organizingClub = validateOrganizingClub(organizingClub) ? organizingClub : null;
    }

    public void setVenue(Venue venue) {
        this.venue = validateVenue(venue) ? venue : null;
    }

    public void setBudget(Budget budget) {
        this.budget = validateBudget(budget) ? budget : null;
    }

    public void setRegisteredMembers(List<Member> registeredMembers) {
        this.registeredMembers = registeredMembers;
    }

  
    
}
