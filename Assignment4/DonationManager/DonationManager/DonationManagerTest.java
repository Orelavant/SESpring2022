/** 
 * @author Jacob Valero
 *
 * This class contains the tests for the DonationManager.donate method
 * 
 * Modified: 19 Feb 2021 (starter code) 
 */

package DonationManager;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DonationManagerTest {

	// STEP 1 ----------------------------------------------
	// Test when both fund manager and user manager are null.
	@Test(expected=IllegalStateException.class)
	public void testParametersNull() {
		new DonationManager(null, null).donate("testUser", "testFund", 1);
	}


	// Test for when user manager is null.
	@Test(expected=IllegalStateException.class)
	public void testUserManagerParameterNull() {
		class Fund implements FundManager {
			@Override
			public boolean isValidFund(String name) {
				return false;
			}

			@Override
			public double getFundTarget(String name) {
				return 0;
			}

			@Override
			public double getFundBalance(String name) {
				return 0;
			}
		}
		Fund testFund = new Fund();

		new DonationManager(testFund, null).donate("testUser", "testFund", 1);
	}
	
	// Test when fund manager are null.
	@Test(expected=IllegalStateException.class)
	public void testFundManagerParameterNull() {
		class User implements UserManager {
			@Override
			public boolean isValidUser(String name) {
				return false;
			}

			@Override
			public double getBalance(String name) {
				return 0;
			}
		}
		User testUser = new User();

		new DonationManager(null, testUser).donate("testUser", "testFund", 1);
	}

	// STEP 2 ----------------------------------------------
	// Test when both fund and user are null for donate method.
	@Test(expected=IllegalArgumentException.class)
	public void testDonateUserFundParametersNull() {
		class Fund implements FundManager {
			@Override
			public boolean isValidFund(String name) {
				return false;
			}

			@Override
			public double getFundTarget(String name) {
				return 0;
			}

			@Override
			public double getFundBalance(String name) {
				return 0;
			}
		}

		class User implements UserManager {
			@Override
			public boolean isValidUser(String name) {
				return false;
			}

			@Override
			public double getBalance(String name) {
				return 0;
			}
		}

		User testUser = new User();
		Fund testFund = new Fund();

		new DonationManager(testFund, testUser).donate(null, null, 1);
	}

	// Test when user parameter is null for donate method.
	@Test(expected=IllegalArgumentException.class)
	public void testDonateUserParameterNull() {
		class Fund implements FundManager {
			@Override
			public boolean isValidFund(String name) {
				return false;
			}

			@Override
			public double getFundTarget(String name) {
				return 0;
			}

			@Override
			public double getFundBalance(String name) {
				return 0;
			}
		}

		class User implements UserManager {
			@Override
			public boolean isValidUser(String name) {
				return false;
			}

			@Override
			public double getBalance(String name) {
				return 0;
			}
		}

		User testUser = new User();
		Fund testFund = new Fund();

		new DonationManager(testFund, testUser).donate(null, "testFund", 1);
	}

	// Test when user parameter is null for donate method.
	@Test(expected=IllegalArgumentException.class)
	public void testDonateFundParameterNull() {
		class Fund implements FundManager {
			@Override
			public boolean isValidFund(String name) {
				return false;
			}

			@Override
			public double getFundTarget(String name) {
				return 0;
			}

			@Override
			public double getFundBalance(String name) {
				return 0;
			}
		}

		class User implements UserManager {
			@Override
			public boolean isValidUser(String name) {
				return false;
			}

			@Override
			public double getBalance(String name) {
				return 0;
			}
		}

		User testUser = new User();
		Fund testFund = new Fund();

		new DonationManager(testFund, testUser).donate("testUser", null, 1);
	}

	// Test when both fund and user are empty for donate method.
	@Test(expected=IllegalArgumentException.class)
	public void testDonateUserFundParametersEmpty() {
		class Fund implements FundManager {
			@Override
			public boolean isValidFund(String name) {
				return false;
			}

			@Override
			public double getFundTarget(String name) {
				return 0;
			}

			@Override
			public double getFundBalance(String name) {
				return 0;
			}
		}

		class User implements UserManager {
			@Override
			public boolean isValidUser(String name) {
				return false;
			}

			@Override
			public double getBalance(String name) {
				return 0;
			}
		}

		User testUser = new User();
		Fund testFund = new Fund();

		new DonationManager(testFund, testUser).donate("", "", 1);
	}

	// Test when fund parameter is empty for donate method.
	@Test(expected=IllegalArgumentException.class)
	public void testDonateFundParameterEmpty() {
		class Fund implements FundManager {
			@Override
			public boolean isValidFund(String name) {
				return false;
			}

			@Override
			public double getFundTarget(String name) {
				return 0;
			}

			@Override
			public double getFundBalance(String name) {
				return 0;
			}
		}

		class User implements UserManager {
			@Override
			public boolean isValidUser(String name) {
				return false;
			}

			@Override
			public double getBalance(String name) {
				return 0;
			}
		}

		User testUser = new User();
		Fund testFund = new Fund();

		new DonationManager(testFund, testUser).donate("testUser", "", 1);
	}

	// Test when user parameter is empty for donate method.
	@Test(expected=IllegalArgumentException.class)
	public void testDonateUserParameterEmpty() {
		class Fund implements FundManager {
			@Override
			public boolean isValidFund(String name) {
				return false;
			}

			@Override
			public double getFundTarget(String name) {
				return 0;
			}

			@Override
			public double getFundBalance(String name) {
				return 0;
			}
		}

		class User implements UserManager {
			@Override
			public boolean isValidUser(String name) {
				return false;
			}

			@Override
			public double getBalance(String name) {
				return 0;
			}
		}

		User testUser = new User();
		Fund testFund = new Fund();

		new DonationManager(testFund, testUser).donate("", "testFund", 1);
	}

	// STEP 3 ----------------------------------------------
	// Test when amount is 0 for donate method.
	@Test(expected=IllegalArgumentException.class)
	public void testAmountParameter0() {
		class Fund implements FundManager {
			@Override
			public boolean isValidFund(String name) {
				return false;
			}

			@Override
			public double getFundTarget(String name) {
				return 0;
			}

			@Override
			public double getFundBalance(String name) {
				return 0;
			}
		}

		class User implements UserManager {
			@Override
			public boolean isValidUser(String name) {
				return false;
			}

			@Override
			public double getBalance(String name) {
				return 0;
			}
		}

		User testUser = new User();
		Fund testFund = new Fund();

		new DonationManager(testFund, testUser).donate("testUser", "testFund", 0);
	}

	// Test when amount is negative for donate method.
	@Test(expected=IllegalArgumentException.class)
	public void testAmountParameterNegative() {
		class Fund implements FundManager {
			@Override
			public boolean isValidFund(String name) {
				return false;
			}

			@Override
			public double getFundTarget(String name) {
				return 0;
			}

			@Override
			public double getFundBalance(String name) {
				return 0;
			}
		}

		class User implements UserManager {
			@Override
			public boolean isValidUser(String name) {
				return false;
			}

			@Override
			public double getBalance(String name) {
				return 0;
			}
		}

		User testUser = new User();
		Fund testFund = new Fund();

		new DonationManager(testFund, testUser).donate("testUser", "testFund", -1);
	}

	// STEP 4 ----------------------------------------------
	// Test when is valid user returns false
	@Test(expected=InvalidUserException.class)
	public void testIsValidUserFalse() {

		class User implements UserManager {
			@Override
			public boolean isValidUser(String name) {
				return false;
			}

			@Override
			public double getBalance(String name) {
				return 0;
			}
		}

		class Fund implements FundManager {
			@Override
			public boolean isValidFund(String name) {
				return true;
			}

			@Override
			public double getFundTarget(String name) {
				return 0;
			}

			@Override
			public double getFundBalance(String name) {
				return 0;
			}
		}

		User testUser = new User();
		Fund testFund = new Fund();

		new DonationManager(testFund, testUser).donate("testUser", "testFund", 1);
	}

	// STEP 5 ----------------------------------------------
	// Test when is valid fund returns false
	@Test(expected=InvalidFundException.class)
	public void testIsValidFundFalse() {

		class User implements UserManager {
			@Override
			public boolean isValidUser(String name) {
				return true;
			}

			@Override
			public double getBalance(String name) {
				return 0;
			}
		}

		class Fund implements FundManager {
			@Override
			public boolean isValidFund(String name) {
				return false;
			}

			@Override
			public double getFundTarget(String name) {
				return 0;
			}

			@Override
			public double getFundBalance(String name) {
				return 0;
			}
		}

		User testUser = new User();
		Fund testFund = new Fund();

		new DonationManager(testFund, testUser).donate("testUser", "testFund", 1);
	}

	// STEP 6 ----------------------------------------------
	// Test when get fund target returns a negative number.
	@Test(expected=IllegalStateException.class)
	public void testFundTargetNegative() {

		class User implements UserManager {
			@Override
			public boolean isValidUser(String name) {
				return true;
			}

			@Override
			public double getBalance(String name) {
				return 0;
			}
		}

		class Fund implements FundManager {
			@Override
			public boolean isValidFund(String name) {
				return true;
			}

			@Override
			public double getFundTarget(String name) {
				return -1;
			}

			@Override
			public double getFundBalance(String name) {
				return 0;
			}
		}

		User testUser = new User();
		Fund testFund = new Fund();

		new DonationManager(testFund, testUser).donate("testUser", "testFund", 1);
	}

	// STEP 7 ----------------------------------------------
	// Test when get balance returns less (1) than the donate amount parameter (2).
	@Test(expected=InsufficientBalanceException.class)
	public void testGetBalanceInsufficient() {

		class User implements UserManager {
			@Override
			public boolean isValidUser(String name) {
				return true;
			}

			@Override
			public double getBalance(String name) {
				return 1;
			}
		}

		class Fund implements FundManager {
			@Override
			public boolean isValidFund(String name) {
				return true;
			}

			@Override
			public double getFundTarget(String name) {
				return 0;
			}

			@Override
			public double getFundBalance(String name) {
				return 0;
			}
		}

		User testUser = new User();
		Fund testFund = new Fund();

		new DonationManager(testFund, testUser).donate("testUser", "testFund", 2);
	}

	// Normal Operation Case 1 ----------------------------------------------
	@Test
	public void testDonateAmountSmallerThanFundTarget() {
		// Define and instantiate mock objects.
		class User implements UserManager {
			@Override
			public boolean isValidUser(String name) {
				return true;
			}

			@Override
			public double getBalance(String name) {
				return 100;
			}
		}

		class Fund implements FundManager {
			@Override
			public boolean isValidFund(String name) {
				return true;
			}

			@Override
			public double getFundTarget(String name) {
				return 10;
			}

			@Override
			public double getFundBalance(String name) {
				return 2;
			}
		}

		User testUser = new User();
		Fund testFund = new Fund();

		Double testAmount = 5.0;
		Double result = new DonationManager(testFund, testUser).donate("testUser", "testFund", testAmount);

		// Check if the amount donated was equal to the result (Diff is 8).
		assertEquals(testAmount, result);
	}

	@Test
	public void testDonateAmountLargerThanFundTarget() {
		// Define and instantiate mock objects.
		class User implements UserManager {
			@Override
			public boolean isValidUser(String name) {
				return true;
			}

			@Override
			public double getBalance(String name) {
				return 100;
			}
		}

		class Fund implements FundManager {
			@Override
			public boolean isValidFund(String name) {
				return true;
			}

			@Override
			public double getFundTarget(String name) {
				return 10;
			}

			@Override
			public double getFundBalance(String name) {
				return 2;
			}
		}

		User testUser = new User();
		Fund testFund = new Fund();

		Double testAmount = 20.0;
		Double result = new DonationManager(testFund, testUser).donate("testUser", "testFund", testAmount);

		// Check if the amount donated was equal to the funding gap (Diff is 8).
		Double fundGap = testFund.getFundTarget("testFund")-testFund.getFundBalance("testFund");
		assertEquals(fundGap, result);
	}
	
	// Normal Operation Case 2 ----------------------------------------------
	@Test
	public void testDonateMatchedAmountSmallerThanFundTarget() {
		// Define and instantiate mock objects.
		class User implements UserManager {
			@Override
			public boolean isValidUser(String name) {
				return true;
			}

			@Override
			public double getBalance(String name) {
				return 10000;
			}
		}

		class Fund implements FundManager {
			@Override
			public boolean isValidFund(String name) {
				return true;
			}

			@Override
			public double getFundTarget(String name) {
				return 6000;
			}

			@Override
			public double getFundBalance(String name) {
				return 0;
			}
		}

		User testUser = new User();
		Fund testFund = new Fund();

		Double testAmount = 2001.0;
		Double result = new DonationManager(testFund, testUser).donate("testUser", "testFund", testAmount);

		// Check if the result is double the amount donated.
		Double doubleAmount = testAmount*2;
		assertEquals(doubleAmount, result);
	}

	@Test
	public void testDonateMatchedAmountLargerThanFundTarget() {
		// Define and instantiate mock objects.
		class User implements UserManager {
			@Override
			public boolean isValidUser(String name) {
				return true;
			}

			@Override
			public double getBalance(String name) {
				return 100000;
			}
		}

		class Fund implements FundManager {
			@Override
			public boolean isValidFund(String name) {
				return true;
			}

			@Override
			public double getFundTarget(String name) {
				return 8000;
			}

			@Override
			public double getFundBalance(String name) {
				return 0;
			}
		}

		User testUser = new User();
		Fund testFund = new Fund();

		Double testAmount = 5000.0;
		Double result = new DonationManager(testFund, testUser).donate("testUser", "testFund", testAmount);

		// Check if the amount donated was equal to the funding gap.
		Double fundGap = testFund.getFundTarget("testFund")-testFund.getFundBalance("testFund");
		assertEquals(fundGap, result);
	}

	@Test
	public void testDonateFundTargetReached() {
		// Define and instantiate mock objects.
		class User implements UserManager {
			@Override
			public boolean isValidUser(String name) {
				return true;
			}

			@Override
			public double getBalance(String name) {
				return 100000;
			}
		}

		class Fund implements FundManager {
			@Override
			public boolean isValidFund(String name) {
				return true;
			}

			@Override
			public double getFundTarget(String name) {
				return 100;
			}

			@Override
			public double getFundBalance(String name) {
				return 100;
			}
		}

		User testUser = new User();
		Fund testFund = new Fund();

		Double testAmount = 10.0;
		Double result = new DonationManager(testFund, testUser).donate("testUser", "testFund", testAmount);

		// Check if the amount donated was equal to the funding gap.
		Double fundGap = testFund.getFundTarget("testFund")-testFund.getFundBalance("testFund");
		assertEquals(fundGap, result);
	}

	@Test
	public void testDonateFundTargetExceeded() {
		// Define and instantiate mock objects.
		class User implements UserManager {
			@Override
			public boolean isValidUser(String name) {
				return true;
			}

			@Override
			public double getBalance(String name) {
				return 100000;
			}
		}

		class Fund implements FundManager {
			@Override
			public boolean isValidFund(String name) {
				return true;
			}

			@Override
			public double getFundTarget(String name) {
				return 100;
			}

			@Override
			public double getFundBalance(String name) {
				return 150;
			}
		}

		User testUser = new User();
		Fund testFund = new Fund();

		Double testAmount = 10.0;
		Double result = new DonationManager(testFund, testUser).donate("testUser", "testFund", testAmount);

		// Check if the amount donated was equal to the funding gap.
		Double expected = 0.0;
		assertEquals(expected, result);
	}
}
