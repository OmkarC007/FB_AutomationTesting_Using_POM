package com.company.util;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.company.base.TestBase;

public class CustomListner extends TestBase implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("FAILED Test");
		takeScreenshotAtEndOfTest(result.getMethod().getMethodName());
	}	 
}
