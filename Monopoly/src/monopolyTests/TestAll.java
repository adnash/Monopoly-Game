package monopolyTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

@SuiteClasses({ 
	DiceTest.class,
	JailTest.class,
	PlayerTest.class,
	RailroadsAndUtilitiesTest.class,
	RealEstateTest.class,
	SquareTest.class,
	TaxTest.class
})

public class TestAll {

}
