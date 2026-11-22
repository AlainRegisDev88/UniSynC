package unisync;

import java.time.LocalDate;

public class Workshop extends Event {

    private String facilitatorName;
    private double facilitatorFee;
    private double materialCostPerPerson;

    public Workshop(String eventId, String name, LocalDate date, int capacity, 
                    Club organizingClub, Venue venue, Budget budget,
                    String facilitatorName, double facilitatorFee, double materialCostPerPerson) {
        
        super(eventId, name, date, capacity, organizingClub, venue, budget);
        
        this.facilitatorName = facilitatorName;
        this.facilitatorFee = facilitatorFee;
        this.materialCostPerPerson = materialCostPerPerson;
    }

    




    @Override 
    public double calculateCost() {
        return facilitatorFee + (materialCostPerPerson * getCapacity());  
    }

}
