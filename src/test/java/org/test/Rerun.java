package org.test;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(WithoutKnown.class)
public class Rerun {
	@Test
private void testA() {
Assert.assertTrue(true);
System.out.println("Test A");
}
	@Test(retryAnalyzer=Known.class)
	private void testB() {
Assert.assertTrue(false);
System.out.println("Test B");

	}
@Test
private void testC() {
Assert.assertTrue(true);
System.out.println("Test c");

}
}
