package oopsConcepts;

	abstract class Bank 
 {
	abstract void saving();	//method signature
	abstract void current();
	abstract void salary();
	abstract void joint();

	public void branchDetails()
	{
		System.out.println("Mumbai");
	}
}
	 class AxisBank extends Bank 
	{
		@Override
		public void saving() 
		{
			// method signature
			// business logic
			System.out.println(" saving regular");
		}
		@Override
		public void current() 
		{
			System.out.println("Current");
		}
		@Override
		public void salary() {
			System.out.println("Salary Details");					
		}
		@Override
		public void joint() {
			System.out.println("Joint Account");
		}
	}
		
		class ICICIbank extends Bank
		{
			@Override
			void saving() {
					System.out.println("Saving");			
			}

			@Override
			void current() {
				System.out.println("Current");				
			}

			@Override
			void salary() {
				System.out.println("Salary");
			}

			@Override
			void joint() {
				System.out.println("Joint");
			}	
		}

   public class abstractclass {

	public static void main(String[] args) {
		
		AxisBank ab = new AxisBank();
		ICICIbank ib = new ICICIbank();
		
		ab.branchDetails();
		ib.branchDetails();
		ab.current();
		ab.joint();
		ib.salary();
		ib.saving();

	}
}

