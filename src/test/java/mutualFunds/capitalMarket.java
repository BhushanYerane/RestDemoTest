package mutualFunds;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class capitalMarket {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ComplexJson complexJson = objectMapper.readValue(new File("src/test/resources/config/captalMarket.json"), ComplexJson.class);
            
            // Print all values from the JSON
            List<MajorTopic> MajorTopic = complexJson.getMajorTopic();
            for (MajorTopic majorTopic : MajorTopic) {
                System.out.println("Major Topic: " + majorTopic.getTopic());
                List<String> subtopics = majorTopic.getSubtopics();
                for (String subtopic : subtopics) {
                    System.out.println("  Subtopic: " + subtopic);
                }
            }

            List<String> keyTerms = complexJson.getKeyTerms();
            System.out.println("Key Terms:");
            for (String keyTerm : keyTerms) {
                System.out.println("  " + keyTerm);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
