package org.test;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Known implements IRetryAnalyzer{
	int mincount=0, maxcount=4;

	@Override
	public boolean retry(ITestResult result) {
		if(mincount<maxcount) {
			mincount++;
			return true;
		}
		return false;
	}

}
