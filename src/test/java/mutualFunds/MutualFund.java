package mutualFunds;

public class MutualFund {
    private String fundName;
    private FundManager fundManager;
    private FundDetails fundDetails;

    // Getters and setters
    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public FundManager getFundManager() {
        return fundManager;
    }

    public void setFundManager(FundManager fundManager) {
        this.fundManager = fundManager;
    }

    public FundDetails getFundDetails() {
        return fundDetails;
    }

    public void setFundDetails(FundDetails fundDetails) {
        this.fundDetails = fundDetails;
    }
}
