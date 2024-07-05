package mutualFunds;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MFTest {
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			MutualFund mutualFund = objectMapper.readValue(new File("src/test/resources/config/MutualFunds.json"), MutualFund.class);

			// Print all values from the JSON
			System.out.println("Fund Name: " + mutualFund.getFundName());
			System.out.println("Fund Manager Name: " + mutualFund.getFundManager().getName());
			System.out.println("Experience: " + mutualFund.getFundManager().getExperience());

			List<FundManaged> fundsManaged = mutualFund.getFundManager().getFundsManaged();
			double totalReturn = 0;
			int totalReturnCount = 0;
			long totalAssets = 0;

			for (int i = 0; i < fundsManaged.size(); i++) {
				FundManaged fund = fundsManaged.get(i);
				System.out.println("Fund Managed Name: " + fund.getName());
				System.out.println("Inception Date: " + fund.getInceptionDate());
				System.out.println("Assets Under Management: " + fund.getAssetsUnderManagement());

				totalAssets += fund.getAssetsUnderManagement();

				System.out.println("Yearly Performance:");
				for (int j = 0; j < fund.getPerformance().getYearly().size(); j++) {
					FundPerformance performance = fund.getPerformance().getYearly().get(j);
					System.out.println("Year: " + performance.getYear() + ", Return: " + performance.getReturn());

					totalReturn += performance.getReturn();
					totalReturnCount++;
				}
				System.out.println();
			}

			double avgReturn = totalReturnCount > 0 ? totalReturn / totalReturnCount : 0;
			double avgAssets = fundsManaged.size() > 0 ? (double) totalAssets / fundsManaged.size() : 0;

			System.out.println("Average Return: " + avgReturn);
			System.out.println("Average Assets Under Management: " + avgAssets);

			// Print fund details
			System.out.println("Fund Category: " + mutualFund.getFundDetails().getCategory());
			System.out.println("Fund Inception Date: " + mutualFund.getFundDetails().getInceptionDate());
			System.out.println("Net Asset Value: " + mutualFund.getFundDetails().getNetAssetValue());
			System.out.println("Expense Ratio: " + mutualFund.getFundDetails().getExpenseRatio());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//
		MutualFund MF = objectMapper.readValue(new File("src/test/resources/config/MutualFunds.json"),
				MutualFund.class);
		String firstMF = MF.getFundManager().getFundsManaged().get(1).getName();
		System.out.println(firstMF);

		int fundManageSize = MF.getFundManager().getFundsManaged().size();
		for (int i = 0; i < fundManageSize; i++) {
			System.out.println(MF.getFundManager().getFundsManaged().get(i).getName());
			System.out.println(
					MF.getFundManager().getFundsManaged().get(i).getPerformance().getYearly().get(i).getYear());

		}
		//
	}
}
