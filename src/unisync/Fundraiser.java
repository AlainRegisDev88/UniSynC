package unisync;
import java.time.LocalDate;

public class Fundraiser extends Event {

    private double targetAmount;
    private double amountRaised;
    private double setupCost;
    private double publicityCost;


    public Fundraiser(String eventId, String name, LocalDate date, int capacity, 
                      Club organizingClub, Venue venue, Budget budget,
                      double targetAmount, double amountRaised, double setupCost, double publicityCost) {
        
        super(eventId, name, date, capacity, organizingClub, venue, budget);
        
        this.targetAmount = isPositive(targetAmount);
        this.amountRaised = isPositive(amountRaised);
        this.setupCost = isPositive(setupCost);
        this.publicityCost = isPositive(publicityCost);
    }


    private double isPositive(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative.");
        }
        return value;
    }

    public String recordDonation( double donation) {
        donation = isPositive(donation);
        amountRaised += donation;
        return "Donation of " + donation + " recorded. Total amount raised: " + amountRaised;
    }

    // Getters and Setters

     public double getTargetAmount() {
         return targetAmount;
     }


     public void setTargetAmount(double targetAmount) {
         this.targetAmount = isPositive(targetAmount);
     }


     public double getAmountRaised() {
         return amountRaised;
     }


     public void setAmountRaised(double amountRaised) {
         this.amountRaised = isPositive(amountRaised);
     }


     public double getSetupCost() {
         return setupCost;
     }


     public void setSetupCost(double setupCost) {
         this.setupCost = isPositive(setupCost);
     }


     public double getPublicityCost() {
         return publicityCost;
     }


     public void setPublicityCost(double publicityCost) {
         this.publicityCost = isPositive(publicityCost);
     }


     @Override 
    public double calculateCost() {
        return 0;
    }

}
