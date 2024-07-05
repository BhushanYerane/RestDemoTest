package mutualFunds;

public class FundDetails {
    private String category;
    private String inceptionDate;
    private double netAssetValue;
    private double expenseRatio;

    // Getters and setters
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInceptionDate() {
        return inceptionDate;
    }

    public void setInceptionDate(String inceptionDate) {
        this.inceptionDate = inceptionDate;
    }

    public double getNetAssetValue() {
        return netAssetValue;
    }

    public void setNetAssetValue(double netAssetValue) {
        this.netAssetValue = netAssetValue;
    }

    public double getExpenseRatio() {
        return expenseRatio;
    }

    public void setExpenseRatio(double expenseRatio) {
        this.expenseRatio = expenseRatio;
    }
}

