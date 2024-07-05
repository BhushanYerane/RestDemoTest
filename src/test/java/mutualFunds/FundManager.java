package mutualFunds;

import java.util.List;

public class FundManager {
    private String name;
    private int experience;
    private List<FundManaged> fundsManaged;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<FundManaged> getFundsManaged() {
        return fundsManaged;
    }

    public void setFundsManaged(List<FundManaged> fundsManaged) {
        this.fundsManaged = fundsManaged;
    }
}

