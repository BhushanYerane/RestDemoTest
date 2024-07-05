package mutualFunds;

import java.util.List;

public class ComplexJson {
	
	private List<MajorTopic> MajorTopics;
    private List<String> KeyTerms;
	
    public List<MajorTopic> getMajorTopic() {
		return MajorTopics;
	}
	public void setMajorTopic(List<MajorTopic> majorTopic) {
		MajorTopics = majorTopic;
	}
	public List<String> getKeyTerms() {
		return KeyTerms;
	}
	public void setKeyTerms(List<String> keyTerms) {
		KeyTerms = keyTerms;
	}    
}
