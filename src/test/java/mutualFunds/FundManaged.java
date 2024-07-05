package mutualFunds;

import java.util.List;

public class FundManaged {
    private String name;
    private String inceptionDate;
    private long assetsUnderManagement;
    private Performance performance;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInceptionDate() {
        return inceptionDate;
    }

    public void setInceptionDate(String inceptionDate) {
        this.inceptionDate = inceptionDate;
    }

    public long getAssetsUnderManagement() {
        return assetsUnderManagement;
    }

    public void setAssetsUnderManagement(long assetsUnderManagement) {
        this.assetsUnderManagement = assetsUnderManagement;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }
}

