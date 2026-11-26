package unisync;

import java.time.LocalDate;

public class Main {

    // Prints a heading at the start of a step.
    private static void printStepStart(int number, String title) {
        System.out.println();
        System.out.println(">>> STEP " + number + ": " + title);
        System.out.println("----------------------------------------------");
    }

    // Prints a line at the end of a step.
    private static void printStepEnd(int number) {
        System.out.println("<<< Step " + number + " done.");
    }

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("   UniSynC - University Sync Club (CLI Demo)");
        System.out.println("   Ashesi University");
        System.out.println("==============================================");

        // STEP 1: Create a club and add two members
        printStepStart(1, "Create a club and add two members");
        Club club = new Club("C001", "Tech Innovators Club",
                "A club at Ashesi University for students who love building software.");
        Member ama = new Member("M001", "Ama Mensah", "ama.mensah@ashesi.edu.gh");
        Member kofi = new Member("M002", "Kofi Boateng", "kofi.boateng@ashesi.edu.gh");
        ama.joinClub(club);
        kofi.joinClub(club);
        System.out.println("Club created: " + club.getName());
        System.out.println("Members added: " + ama.getName() + " and " + kofi.getName());
        printStepEnd(1);

        // STEP 2: Create an event (a Competition)
        printStepStart(2, "Create an event (Competition)");
        LocalDate eventDate = LocalDate.of(2026, 12, 10);
        Venue venue = new Venue("V001", "The Hive", 200);
        Budget budget = new Budget(2000.00);

        // The capacity is 2 so that step 5 can show the "event is full" refusal.
        Competition hackathon = new Competition("E001", "Campus Hackathon", eventDate, 2,
                club, venue, budget, 1000.00, 3, 150.00);
        club.addEvent(hackathon);
        System.out.println("Event created: " + hackathon.getName() + " on " + eventDate);
        System.out.println("Capacity: " + hackathon.getCapacity());
        System.out.println("Prize: GHS 1000.0, 3 judges at GHS 150.0 each");
        System.out.println("Budget allocated: GHS " + budget.getAllocatedAmount());
        printStepEnd(2);

        // STEP 3: Book the venue for the event
        printStepStart(3, "Book a venue for the event");
        try {
            venue.bookVenue(eventDate, hackathon);
            System.out.println("SUCCESS: " + venue.getName() + " is booked for "
                    + eventDate + " (" + hackathon.getName() + ").");
        } catch (IllegalStateException e) {
            System.out.println("Unexpected booking problem: " + e.getMessage());
        }
        printStepEnd(3);

        // STEP 4: Try to book the same venue and date again
        printStepStart(4, "Try to book the same venue and date again");
        Competition quizNight = new Competition("E002", "Quiz Night", eventDate, 30,
                club, venue, new Budget(500.00), 200.00, 2, 50.00);
        System.out.println("Trying to book " + venue.getName() + " on "
                + eventDate + " for " + quizNight.getName() + "...");
        try {
            venue.bookVenue(eventDate, quizNight);
            System.out.println("Booking worked (this should NOT happen).");
        } catch (IllegalStateException e) {
            // The venue is already booked, so Venue throws an exception.
            // We catch it here so the program does not crash.
            System.out.println("BOOKING CONFLICT CAUGHT: " + e.getMessage());
            System.out.println("The double booking was stopped.");
        }
        printStepEnd(4);

        // STEP 5: Register members until the event is full
        printStepStart(5, "Register members until the event is full");
        Member esi = new Member("M003", "Esi Appiah", "esi.appiah@ashesi.edu.gh");
        esi.joinClub(club);
        System.out.println("(" + esi.getName() + " joined the club as a third member");
        System.out.println(" so we can show what happens when the event is full.)");

        Member[] attendees = {ama, kofi, esi};
        for (int i = 0; i < attendees.length; i++) {
            Member m = attendees[i];
            boolean registered = hackathon.registerMember(m);
            if (registered) {
                System.out.println("REGISTERED: " + m.getName() + " ("
                        + hackathon.getRegisteredCount() + " of "
                        + hackathon.getCapacity() + " spots taken)");
            } else {
                System.out.println("REFUSED: " + m.getName()
                        + " could not register because the event is full ("
                        + hackathon.getRegisteredCount() + " of "
                        + hackathon.getCapacity() + ").");
            }
        }
        printStepEnd(5);

        // STEP 6: Print the event cost using calculateCost()
        printStepStart(6, "Print the event cost using calculateCost()");
        // An Event variable holding a Competition object (polymorphism).
        Event event = hackathon;
        double cost = event.calculateCost();
        System.out.println("Event: " + event.getName());
        System.out.println("Cost = prize 1000.0 + judge fees (3 x 150.0)");
        System.out.println("Total event cost: GHS " + cost);
        printStepEnd(6);

        // STEP 7: Record an expense and print the remaining budget
        printStepStart(7, "Record an expense and print the remaining budget");
        Budget eventBudget = event.getBudget();
        System.out.println("Allocated budget: GHS " + eventBudget.getAllocatedAmount());
        eventBudget.recordExpense("Prize money", 1000.00);
        System.out.println("Expense recorded: Prize money, GHS 1000.0");
        eventBudget.recordExpense("Judge fees", 450.00);
        System.out.println("Expense recorded: Judge fees, GHS 450.0");
        System.out.println("Total expenses: GHS " + eventBudget.getTotalExpenses());
        System.out.println("Remaining funds: GHS " + eventBudget.getRemainingFunds());
        if (eventBudget.isOverBudget()) {
            System.out.println("Over budget? Yes");
        } else {
            System.out.println("Over budget? No");
        }
        printStepEnd(7);

        System.out.println();
        System.out.println("==============================================");
        System.out.println("   Journey complete - all 7 steps finished.");
        System.out.println("==============================================");
    }
}
