package unisync;

import java.time.LocalDate;

public class Competition extends Event {

    private double prizeAmount;
    private int numberOfJudges;
    private double feePerJudge;

    public Competition(String eventId, String name, LocalDate date, int capacity, 
                       Club organizingClub, Venue venue, Budget budget,
                       double prizeAmount, int numberOfJudges, double feePerJudge) {
        
        super(eventId, name, date, capacity, organizingClub, venue, budget);
        
        this.prizeAmount = prizeAmount;
        this.numberOfJudges = numberOfJudges;
        this.feePerJudge = feePerJudge;
    }

    // Getters and Setters
    public double getPrizeAmount() {
        return prizeAmount;
    }

    public int getNumberOfJudges() {
        return numberOfJudges;
    }

    public double getFeePerJudge() {
        return feePerJudge;
    }

    public void setNumberOfJudges(int numberOfJudges) {
        this.numberOfJudges = numberOfJudges;
    }

    public void setPrizeAmount(double prizeAmount) {
        this.prizeAmount = verifyPrizeAmount(prizeAmount);
    }

    public void setFeePerJudge(double feePerJudge) {
        this.feePerJudge = verifyFeePerJudge(feePerJudge);
    }


    private double verifyPrizeAmount(double prizeAmount) {
        if (prizeAmount < 0) {
            throw new IllegalArgumentException("Prize amount cannot be negative.");
        }

        return prizeAmount;
    }

    private double verifyFeePerJudge(double feePerJudge) {
        if (feePerJudge < 0) {
            throw new IllegalArgumentException("Fee per judge cannot be negative.");
        }

        return feePerJudge;
    }

     @Override 
    public double calculateCost() {
        return (numberOfJudges * feePerJudge) + prizeAmount;
    }

}
