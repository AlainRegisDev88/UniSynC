package unisync;
import java.util.HashMap;
import java.util.Map;
public class Budget {
  private double allocatedAmount;
  private Map<String, Double> expenses;

  public Budget(double allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
        this.expenses = new HashMap<>();
    }
  public void recordExpense(String description, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Expense amount cannot be negative.");
        }
        expenses.merge(description, amount, Double::sum);
    }
  public double getTotalExpenses() {
        double total = 0;
        for (double amount : expenses.values()) {
            total += amount;
        }
        return total;
    }
  public double getRemainingFunds() {
        return allocatedAmount - getTotalExpenses();
    }
  public boolean isOverBudget() {
        return getRemainingFunds() < 0;
    }
  public double getAllocatedAmount() {
        return allocatedAmount;
    }

  public void setAllocatedAmount(double allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }

  public Map<String, Double> getExpenses() {
        return expenses;
    }

  public void setExpenses(Map<String, Double> expenses) {
        this.expenses = expenses;
    }
}
