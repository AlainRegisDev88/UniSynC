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

    // Getters and Setters
     public String getFacilitatorName() {
        return facilitatorName;
    }

    public void setFacilitatorName(String facilitatorName) {
        this.facilitatorName = facilitatorName;
    }

    public double getFacilitatorFee() {
        return facilitatorFee;
    }

    public void setFacilitatorFee(double facilitatorFee) {
        this.facilitatorFee = facilitatorFee;
    }

    public double getMaterialCostPerPerson() {
        return materialCostPerPerson;
    }

    public void setMaterialCostPerPerson(double materialCostPerPerson) {
        this.materialCostPerPerson = materialCostPerPerson;
    }



    @Override 
    public double calculateCost() {
        return facilitatorFee + (materialCostPerPerson * getCapacity());  
    }

}
